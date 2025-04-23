package LibraryAPI;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class GetBook {

	@Test(enabled=false)
	public void method1UsingReqSpecification() {
		// TODO Auto-generated method stub
		RequestSpecification   spec = given().baseUri("https://rahulshettyacademy.com/Library/").queryParams("ID", "yuuio875678");
			
		String response = given().spec(spec).log().all().when().get("GetBook.php").then().log().all().extract().response().asPrettyString();
	
		System.out.println("Book response for id yuuio875678 "+response);
	}
	
	@Test(enabled = false)
	public void method2UsingGivenMethodOverloadedFunc()
	{
		RequestSpecification   spec = given().baseUri("https://rahulshettyacademy.com/Library/").queryParam("ID", "yuuio875678");
	
		String bookResponse2 = given(spec).log().all().when().get("GetBook.php").then().log().all().extract().response().asPrettyString();
		
		System.out.println("Book response : "+bookResponse2);
	}

	@Test(enabled = false)
	public void usingStaticReqSpec()
	{
	    RestAssured.requestSpecification = given().baseUri("https://rahulshettyacademy.com/Library/").queryParam("ID", "yuuio875678");
	
	  String response3 =  given().log().all().when().get("GetBook.php").then().log().all().extract().response().asPrettyString();
	  System.out.println("Book response 3 :"+response3);
	}
	
	@Test
	public void usingRequestSpecBuilder()
	{
		RequestSpecBuilder builder = new RequestSpecBuilder();
		RequestSpecification spec=	builder.setBaseUri("https://rahulshettyacademy.com/Library/").addQueryParam("ID", "yuuio875678").build();
		
		String response4 = given().spec(spec).log().all().when().get("GetBook.php").then().log().all().extract().response().asString();
		System.out.println("Book response 4 :"+response4);
	}
}
