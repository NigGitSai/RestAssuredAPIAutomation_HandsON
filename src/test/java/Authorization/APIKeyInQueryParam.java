package Authorization;

import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class APIKeyInQueryParam {
	
	
	@Test
	public void getNewsHeadlinesRequest()
	{
		RequestSpecification spec =    given().baseUri("https://newsapi.org/v2/").queryParam("country", "us").queryParam("category", "business")
		.queryParam("apiKey", "e4d0fd0dd0ad4218af1f95a886194de2");
		
		
		String response =given()
		.spec(spec)
		.log()
		.all()
		.when()
		.get("top-headlines")
		.then()
		
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.header("Server", equalTo("cloudflare"))
		.extract()
		.response()
		.asPrettyString();
		
		DocumentContext context =    JsonPath.parse(response);
		
		String statusAct = context.read("$.status");
		
		Integer totalResAct = context.read("$.totalResults");
		int intTotalRes = totalResAct.intValue();
		
		
		
		Assert.assertEquals(statusAct, "ok","Status verification in response");
		
		Assert.assertEquals(intTotalRes, 55,"Total Resuls verification in response");
		
	
		
	}

}
