package Deserialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ToRetrieveValueOfNestedUsingRestAssuredJsonPath {

String accessToken;
	
	@BeforeMethod
	public void createAccessToken()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String response = given()
				.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.formParam("grant_type", "client_credentials")
				.formParam("scope", "trust")
				.log()
				.all()
				.when()
				.post("oauthapi/oauth2/resourceOwner/token")
				.then()
				.log()
				.all()
				.assertThat()
				.statusCode(200)
				.extract()
				.asPrettyString();
				
				JsonPath js = new JsonPath(response);
				
				
				accessToken = js.getString("access_token");
				
	}
	@Test(priority=0)
	public void withoutObjectMapper()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String response = given()
		.queryParam("access_token", accessToken)
		.log()
		.all()
		.when()
		.get("oauthapi/getCourseDetails")
		.then()
		.extract()
		.asPrettyString();
	
		JsonPath jsonPath = new JsonPath(response);
		
		
		Map<Object,Object> coursesMap = jsonPath.getMap("courses");
		
		outerLoop:
		for(Entry<Object, Object> courses:coursesMap.entrySet())
		{
			if(courses.getKey().equals("webAutomation"))
			{
				System.out.println(courses.getValue());
				List<HashMap<String,Object>> hm = (List<HashMap<String, Object>>) courses.getValue();
				
				for(int i=0;i<hm.size();i++)
				{
					if(hm.get(i).get("courseTitle").equals("Cypress"))
							{
								System.out.println("Price of Cypress course is "+hm.get(i).get("price"));
								break outerLoop;
							}
				}
			}
		}
		
		
	}
}
