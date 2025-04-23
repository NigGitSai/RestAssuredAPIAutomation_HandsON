package RequestResSpecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UsingResponseSpecBuilder {
	
	@Test
	public void responseSpecBuilderTest()
	{
		ResponseSpecBuilder responseSpec = new ResponseSpecBuilder();
		
		ResponseSpecification rs = responseSpec.expectStatusCode(201).expectContentType(ContentType.JSON).build();
	
		RequestSpecBuilder spec = new RequestSpecBuilder();
		
		RequestSpecification reqSpec =	spec.setBaseUri("https://rahulshettyacademy.com/").addHeader("Content-Type", "application/json").addQueryParam("key", "qaclick123").build();
			
		Response response = 	given().spec(reqSpec).log().all().body(RequestSpecificationM1.jsonPayload()).when().post("maps/api/place/add/json").then().spec(rs).log().all().extract().response();
	
	}

}
