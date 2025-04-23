package Authorization;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class OAuthClientAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI= "https://rahulshettyacademy.com/";
		
		String response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "zz")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.log()
		.all()
		.when()
		.post("oauthapi/oauth2/resourceOwner/token")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.extract()
		.response()
		.asPrettyString();
		
		JsonPath js = new JsonPath(response);
		String accessToken  = js.getString("access_token");
		
		response = given().queryParam("access_token", accessToken).log().all().when().get("oauthapi/getCourseDetails")
		.then()
		.log()
		.all()
		.extract()
		.asPrettyString();
		System.out.println(response);
	}

}
