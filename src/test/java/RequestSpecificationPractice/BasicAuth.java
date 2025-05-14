package RequestSpecificationPractice;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class BasicAuth {
	
	@Test
	public void usingRequestSpecification()
	{
		RequestSpecification spec =  given().baseUri("https://postman-echo.com/basic-auth/").auth().basic("postman", "password");
	
	 String response =	given().spec(spec).log().all().when().get().then().log().all().assertThat().header("Server", containsString("nginx")).extract().response().asPrettyString();
	 System.out.println("====================================================");
	}
	@Test
	public void usingStaticRequestSpecification()
	{
		RequestSpecification spec =  given().baseUri("https://postman-echo.com/basic-auth/").auth().basic("postman", "password");
		
		System.out.println("using Static Request Specification ");
		RestAssured.requestSpecification = spec;
		String response2 = given().log().all().when().get().then().log().all().assertThat().body("authenticated", equalTo(true)).extract().response().asString();
		System.out.println(response2);
	}
	
	@Test
	public void usingRequestSpecBuilder()
	{
		RequestSpecBuilder specBuilder = new RequestSpecBuilder();
	  RequestSpecification rs = 	specBuilder.setBaseUri("https://postman-echo.com/basic-auth/").setAuth(RestAssured.basic("postman", "password")).build();
	  System.out.println("============================================================================");
	  System.out.println("using request spec builder");
	  String response3 =  given(rs).log().all().when().get().then().log().all().assertThat().header("Server", equalTo("nginx")).extract().response().asPrettyString();
	  System.out.println(response3);
	}
	
}
