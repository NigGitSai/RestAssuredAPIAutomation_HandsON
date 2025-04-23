package RequestResSpecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilder1 {
	
	@Test
	public void usingRequestSpecBuilder()
	{
		RequestSpecBuilder spec = new RequestSpecBuilder();
		
	RequestSpecification reqSpec =	spec.setBaseUri("https://rahulshettyacademy.com/").addHeader("Content-Type", "application/json").addQueryParam("key", "qaclick123").build();
		
	Response response = 	given().spec(reqSpec).log().all().body(RequestSpecificationM1.jsonPayload()).when().post("maps/api/place/add/json").then().log().all().extract().response();
	System.out.println(response.asString());
	}

}
