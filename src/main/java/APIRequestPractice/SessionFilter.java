package APIRequestPractice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class SessionFilter {

	@Test
	public void sessionEx()
	{
		SessionFilter session = new SessionFilter();
		RestAssured.baseURI = "http://localhost:8080";
		given().log().all().header("content-type", "application/json").body("{ \"username\": \"Nigtest\", \"password\": \"Jiranig@1992\" }").filter(session).
		when().post("/rest/auth/1/session").then().log().all().statusCode(200);
		
	}
}
