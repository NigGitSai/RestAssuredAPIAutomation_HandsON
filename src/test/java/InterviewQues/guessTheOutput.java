package InterviewQues;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.lessThan;

import static org.hamcrest.Matchers.*;

public class guessTheOutput {
	
	//output will be java.net connection refused exception , by default it will take localhost url http://localhost:8080
	@Test(enabled = false)
	public void test1()
	{
		RestAssured.given()
			.log()
			.all()
			.when()
			.get();
	}
	
	@Test
	public void postmanBasicAuth()
	{
		String response = RestAssured.given()
		.log()
		.all()
		.auth()
		.basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth/")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.time(lessThan(5000L))
		.header("Content-Type", equalTo("application/json; charset=utf-8"))
		.extract()
		.response()
		.asPrettyString();
		
		System.out.println("Basic Auth "+response);
	}
}
