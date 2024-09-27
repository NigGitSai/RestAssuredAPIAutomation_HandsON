package RequestSpecBuilderPractice;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;

public class PassingSpecInGivenOverloadedMethod {

	
	@Test
	public void passSpecInGivenFunction()
	{
		File file = new File("./src/test/resources/Data.json");
		RequestSpecBuilder builder = new RequestSpecBuilder();
		
		RequestSpecification  spec = builder.setBaseUri("https://petstore.swagger.io/v2/").setContentType("application/json").build();
		
		
		given(spec).body(file).log().all().when().post("pet").then().log().all().assertThat().statusCode(200);
	}
}
