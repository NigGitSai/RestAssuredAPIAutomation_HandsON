package Authorization;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class APIKeyAuthorization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RequestSpecBuilder specBulider = new RequestSpecBuilder();
		
		
		RequestSpecification reqSpec = specBulider.setBaseUri("https://newsapi.org").addQueryParam("apiKey", "e4d0fd0dd0ad4218af1f95a886194de2").
				addQueryParam("country", "us").addQueryParam("category", "business").build();
		
		Response response = given(reqSpec).log().all().when().get("v2/top-headlines").then().log().all().extract().response();
		
		System.out.println(response.asPrettyString());
	}

}
