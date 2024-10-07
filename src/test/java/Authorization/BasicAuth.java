package Authorization;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;
import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicAuth {

	@Test
	public void testBasicAuth()
	{
		 RequestSpecification spec =  given().baseUri("https://postman-echo.com/basic-auth").auth().basic("postman", "password");
	
		 given().spec(spec).log().all().when().get().then().log().all().assertThat().statusCode(200).body("authenticated", equalTo(true));
	}
}
