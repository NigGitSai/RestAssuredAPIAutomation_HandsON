package RequestSpecBuilderPractice;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class LogRequestAndResponse {

	@Test
	public void toLogRequestResponse() throws FileNotFoundException
	{
		File requestBody = new File("./src/test/resources/Location.json");
		
		PrintStream stream = new PrintStream(new FileOutputStream("./Logs/Log.txt"));
		
		RequestSpecBuilder spec =  new RequestSpecBuilder();
		RequestSpecification  requestSpecification  = 
				spec.setBaseUri("https://rahulshettyacademy.com/maps/").addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(stream))
				.addFilter(ResponseLoggingFilter.logResponseTo(stream))
				
				.setContentType(ContentType.JSON).build();
	
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

