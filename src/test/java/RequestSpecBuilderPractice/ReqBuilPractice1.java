package RequestSpecBuilderPractice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class ReqBuilPractice1 {

	RequestSpecification requestSpec;
	
	@BeforeClass
	public void test1()
	{
		requestSpec = given().baseUri("https://rahulshettyacademy.com/").contentType("application/json").queryParam("key", "qaclick123");
		
	}
	
	@Test
	public void addPlace()
	{
		String response = given()
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -328500,\r\n"
				+ "    \"lng\": 31.927365\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 89,\r\n"
				+ "  \"name\": \"Wedfaf house\",\r\n"
				+ "  \"phone_number\": \"(+91) 232 232 3937\",\r\n"
				+ "  \"address\": \"29, side lane, asff 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"ENGLISH-IN\"\r\n"
				+ "}\r\n"
				+ "")
		.log()
		.all()
		.spec(requestSpec)
		.when()
		.post("maps/api/place/add/json")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.extract()
		.response()
		.asString();
		
		System.out.println("response add place "+response);
		
	}
	
	@Test
	public void testPostMethod()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383499,\r\n"
				+ "    \"lng\": 33.427365\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 60,\r\n"
				+ "  \"name\": \"Aswer house\",\r\n"
				+ "  \"phone_number\": \"(+91) 232 893 3937\",\r\n"
				+ "  \"address\": \"29, side lane, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"ENGLISH-IN\"\r\n"
				+ "}\r\n").when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server",equalTo("Apache/2.4.52 (Ubuntu)"));
		
	}


}

