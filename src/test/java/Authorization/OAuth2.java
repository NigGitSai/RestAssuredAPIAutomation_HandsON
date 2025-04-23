package Authorization;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class OAuth2 {

	@Test
	public void OAuth2Test()
	{
		
		String token = "";
		
		RequestSpecification spec = given().auth().oauth2(token).baseUri("https://api.github.com/");

		given()
		.spec(spec)
		.log()
		.all()
		.when()
		.get("user")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
		
	}
}



