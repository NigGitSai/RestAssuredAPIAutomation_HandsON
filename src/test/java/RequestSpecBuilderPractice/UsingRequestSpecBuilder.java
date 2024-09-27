package RequestSpecBuilderPractice;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class UsingRequestSpecBuilder {
	
	
	@Test
	public void usingRequestSpecBuilder()
	{
		RequestSpecBuilder builder = new RequestSpecBuilder();
		RequestSpecification rs =   builder.setBaseUri("https://reqres.in/api/users").setBasePath("/3").build();
		 
		
		
		RestAssured.given().spec(rs).when().get().then().log().all().assertThat().statusCode(200);
	}

}
