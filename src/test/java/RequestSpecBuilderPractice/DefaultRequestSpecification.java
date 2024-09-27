package RequestSpecBuilderPractice;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class DefaultRequestSpecification {
	
	 RequestSpecification rs;
	@BeforeClass
	public void setUpRequestSpecification()
	{
		rs = given().baseUri("https://petstore.swagger.io/v2/").header("Content-Type", "application/json");
		RestAssured.requestSpecification = rs;
	}
	
	@Test
	public void retrievePetForID1()
	{
		given()
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
	public void retrievePetForID2()
	{
		given()
		.log()
		.all()
		.when()
		.get("pet/58323")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
	}
	
	
}
