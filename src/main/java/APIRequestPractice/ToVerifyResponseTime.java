package APIRequestPractice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ToVerifyResponseTime {
	
	@Test
	public void assertResponseTime()
	{
		given().baseUri("").headers("Content-Type","application/json").when().get("").then().assertThat()
		.statusCode(200).statusLine("").time(lessThan(5000L));
	}

}
