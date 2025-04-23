package RequestResSpecification;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class RequestSpecificationM1 {

	@Test
	public void usingReqSpecification()
	{
		RequestSpecification spec = given().baseUri("https://rahulshettyacademy.com/").header("Content-Type", "application/json")
				.queryParam("key", "qaclick123");
		
	Response response = 	given().spec(spec).log().all().body(jsonPayload()).when().post("maps/api/place/add/json").then().log().all().extract().response();
		System.out.println(response.asString());
	}
	
	
	public static String jsonPayload()
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
