package Authorization;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class BearerToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RequestSpecification rs = given().baseUri("https://api.github.com").header("Autorization", "xxx");
		
		Response response = given().spec(rs).log().all().when().get("/user").then().log().all().extract().response();
		
		System.out.println(response.asString());
	}

}
