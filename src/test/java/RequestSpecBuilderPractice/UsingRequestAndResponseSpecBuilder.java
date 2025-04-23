package RequestSpecBuilderPractice;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;	

public class UsingRequestAndResponseSpecBuilder {
	
	@Test
	public void usingRequestRespSpecBuilder()
	{
		File requestBody = new File("./src/test/resources/Location.json");
		
		RequestSpecBuilder spec =  new RequestSpecBuilder();
		RequestSpecification  requestSpecification  = spec.setBaseUri("https://rahulshettyacademy.com/maps/").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
	
		
		System.out.println("Request Specification "+requestSpecification);
		ResponseSpecBuilder  responseSpec = new ResponseSpecBuilder();
		ResponseSpecification respSpec = responseSpec.expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		given()
		.spec(requestSpecification)
		.body(requestBody)
		.log()
		.all()
		.when()
		.post("api/place/add/json")
		.then()
		.spec(respSpec)
		.log()
		.all();
		
	
	}

}
