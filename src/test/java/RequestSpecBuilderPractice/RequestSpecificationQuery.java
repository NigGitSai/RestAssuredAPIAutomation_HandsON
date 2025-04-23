package RequestSpecBuilderPractice;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertThat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class RequestSpecificationQuery {

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
		.all();
		
		

		
		
		QueryableRequestSpecification querableReqSpec= SpecificationQuerier.query(requestSpecification);
		
		System.out.println("Base URI "+querableReqSpec.getBaseUri());
		
		System.out.println(" content type "+querableReqSpec.getContentType());
	}
	
}
