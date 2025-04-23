package APIRequestPractice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class JsonSchemaValidatorInClasspathRevise {
	
	@Test
	public void JsonSchemaValidatorInClasspathRevise()
	{
		RestAssured.baseURI ="https://rahulshettyacademy.com/";
		given().log().all().header("Content-Type", "application/json").body(jsonPayload())
		.queryParam("key", "qaclick123").
		when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body(JsonSchemaValidator.matchesJsonSchemaInClasspath("AddPlaceJsonSchema.json"));
	}
	
	public String jsonPayload()
	{
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
	}

}
