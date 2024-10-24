package SendAttachment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import java.io.File;	

public class MutipartNdPathParam {

	@Test
	public void toSendAttachment()
	{
		RestAssured.baseURI = "http://localhost:8080";
		
		String response = given()
				.header("X-Atlassian-Token", "no-check")
				.header("content-type", "multipart/form-data")
				.pathParam("key", "10000")
		.multiPart("file",new File("./src/test/resources/Data.json"))
		.log()
		.all()
		.when()
		.post("/rest/api/2/issue/{key}/attachments")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.extract()
		.response()
		.asPrettyString();
		
	}
}
