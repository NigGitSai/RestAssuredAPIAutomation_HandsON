package RequestResSpecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UsingStaticReqSpec {
	
	@Test
	public void usingStaticReqSpec()
	{
		RequestSpecification spec = given().baseUri("https://rahulshettyacademy.com/").header("Content-Type", "application/json")
				.queryParam("key", "qaclick123");
		
		RestAssured.requestSpecification=spec;
		
		Response response = 	given().log().all().body(RequestSpecificationM1.jsonPayload()).when().post("maps/api/place/add/json").then().log().all().extract().response();
		System.out.println(response.asString());
	}
	
	

}
