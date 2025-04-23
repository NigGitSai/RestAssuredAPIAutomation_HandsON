package RequestResSpecification;

import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import static io.restassured.RestAssured.*;

public class QueryReqSpecification {

	@Test
	public void test1() {
		RequestSpecification reqSpec = given().baseUri("").header("Content-Type", "application/json");
		
		QueryableRequestSpecification querable = SpecificationQuerier.query(reqSpec);
		
		System.out.println(querable.getBasePath());
		System.out.println(querable.getHeaders());
		Headers headers = querable.getHeaders();
		
		headers.getValue("");
	}
}
