package Deserialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DeserializeGetCourseResponse {
	
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
		GetCourses courses = given()
		.queryParam("access_token", accessToken)
		.log()
		.all()
		.when()
		.get("oauthapi/getCourseDetails").as(GetCourses.class);
		
		
		List<WebAutomation> webAutomation    = courses.getCourses().getWebAutomation();
		ArrayList<String> webAutomationCoursesAct = new ArrayList<String>();
		for(int i=0;i<webAutomation.size();i++)
		{
			webAutomationCoursesAct.add(webAutomation.get(i).getCourseTitle());
		}
		System.out.println("Without using Object mapper"+webAutomationCoursesAct);
		
	}
	
	@Test(priority=1)
	public void withObjectMapper() throws JsonMappingException, JsonProcessingException
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String responseJson = given()
		.queryParam("access_token", accessToken)
		.log()
		.all()
		.when()
		.get("oauthapi/getCourseDetails").then().log().all().extract().asPrettyString();
		
		ObjectMapper mapper = new ObjectMapper();
		
		GetCourses courses = mapper.readValue(responseJson, GetCourses.class);
		
		List<WebAutomation> webAutomation    = courses.getCourses().getWebAutomation();
		ArrayList<String> webAutomationCoursesAct = new ArrayList<String>();
		for(int i=0;i<webAutomation.size();i++)
		{
			webAutomationCoursesAct.add(webAutomation.get(i).getCourseTitle());
		}
		System.out.println("Using Object mapper"+webAutomationCoursesAct);
		
	}
	
	@Test(priority=2)
	public void withJaywayJsonPathAndConfig() throws JsonMappingException, JsonProcessingException
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String responseJson = given()
		.queryParam("access_token", accessToken)
		.log()
		.all()
		.when()
		.get("oauthapi/getCourseDetails").then().log().all().extract().asPrettyString();
		
		ObjectMapper mapper = new ObjectMapper();
		
		JacksonMappingProvider  mappingProvider = new JacksonMappingProvider();
		
		Configuration config = Configuration.builder().mappingProvider(mappingProvider).build();
		
		GetCourses courses = com.jayway.jsonpath.JsonPath.using(config).parse(responseJson).read("$",GetCourses.class);
		
		
		List<WebAutomation> webAutomation    = courses.getCourses().getWebAutomation();
		ArrayList<String> webAutomationCoursesAct = new ArrayList<String>();
		for(int i=0;i<webAutomation.size();i++)
		{
			webAutomationCoursesAct.add(webAutomation.get(i).getCourseTitle());
		}
		System.out.println("Using Jayway Json and Mapping Provider "+webAutomationCoursesAct);
		
	}
}
