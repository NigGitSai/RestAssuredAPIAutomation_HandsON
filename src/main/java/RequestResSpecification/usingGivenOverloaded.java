package RequestResSpecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class usingGivenOverloaded {

	@Test
	public void usingGivenOverloadedM()
	{
		RequestSpecification spec = given().baseUri("https://rahulshettyacademy.com/").header("Content-Type", "application/json")
				.queryParam("key", "qaclick123");
		
	Response response = 	given(spec).log().all().body(RequestSpecificationM1.jsonPayload()).when().post("maps/api/place/add/json").then().log().all().extract().response();
		System.out.println(response.asString());
	}
}
