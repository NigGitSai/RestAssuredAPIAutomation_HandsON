package APIRequestPractice;


import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ToPassSamePathParam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="";
		
		Response response = given().log().all().contentType("application/json").when().get("").then().log().all().extract().response();
	
		JsonPath js = new JsonPath(response.asString());
	String issueId=	js.getString("issueId");
	
		given().log().all().contentType("application/json").pathParam("issueID", 10000).body("").post("/rest/api/2/issue/{issueID}/comment").then().log().all();
	}

}
