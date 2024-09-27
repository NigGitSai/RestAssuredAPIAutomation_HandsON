package RequestSpecBuilderPractice;


import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class RequestSpecificationExample {
	RequestSpecification requestSpecification;
	
	@BeforeClass
	public void setRequestSpec()
	{
		 requestSpecification = given()
		.baseUri("https://petstore.swagger.io/v2/")
		.header("Content-Type", "application/json");
		
	}
	
	
	@Test
	public void getPetStoreWithID1()
	{
		given()
		.spec(requestSpecification)
		.log()
		.all()
		.when()
		.get("pet/927091944101")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
	}
	
	@Test
	public void getPetStoreWithID2()
	{
		given()
		.spec(requestSpecification)
		.when()
		.get("pet/58323")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
	}
	
}
