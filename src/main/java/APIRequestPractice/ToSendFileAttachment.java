package APIRequestPractice;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ToSendFileAttachment {

	@Test
	public void fileTest()
	{
		Response response = given().header("Content-Type", "multipart/form-data").multiPart("file",new File("")).pathParam("key", 1000)
		.when().post("/rest/api/2/issue/{key}/attachments").then().log().all().extract().response();
	}
}
