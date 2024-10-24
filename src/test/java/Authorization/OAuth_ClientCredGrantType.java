
package Authorization;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.*;	

public class OAuth_ClientCredGrantType {
	
	@Test
	public void getCourseDetails()
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
		
		String accessToken = js.getString("access_token");
		
		response = given()
		.queryParam("access_token", accessToken)
		.log()
		.all()
		.when()
		.get("oauthapi/getCourseDetails")
		.then()
		.log()
		.all()
		.extract()
		.asPrettyString();
		
		js = new JsonPath(response);
		
		String titleAct = js.get("courses.webAutomation[0].courseTitle");
		
		Assert.assertEquals(titleAct,"Selenium Webdriver Java","Course Title");
	}

}
