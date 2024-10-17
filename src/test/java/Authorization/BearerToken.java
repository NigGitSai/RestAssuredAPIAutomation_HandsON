package Authorization;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BearerToken {
	
	@Test
	public void bearerToken()
	{
		String token = "";
		RequestSpecification spec = given().header("Authorization", "Bearer "+token).baseUri("https://api.github.com/");
		
		given()
		.spec(spec)
		.log()
		.all()
		.when()
		.get()
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
		
		
	}

}
