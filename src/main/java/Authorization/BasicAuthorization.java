package Authorization;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers.*;

public class BasicAuthorization {
	
	
	public static void main(String[] args) {
		
		RequestSpecification spec = given().baseUri("https://postman-echo.com/").auth().basic("postman", "password");
		
		Response response =given().spec(spec).log().all().when().get("basic-auth/").then().log().all().assertThat().body("authenticated",equalTo(true)).
				extract().response();
				
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
	}

}
