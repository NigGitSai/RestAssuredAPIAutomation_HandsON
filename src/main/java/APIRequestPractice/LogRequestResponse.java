package APIRequestPractice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import static io.restassured.RestAssured.*;

public class LogRequestResponse {
	
	@Test
	public void logRequestResponse() throws FileNotFoundException
	{
		PrintStream stream = new PrintStream(new FileOutputStream("./Logs/log.txt"));
		
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		
		reqBuilder.setBaseUri("").addHeader("Content_Type", "application/json")
		.addFilter(RequestLoggingFilter.logRequestTo(stream))
		.addFilter(ResponseLoggingFilter.logResponseTo(stream)).build();
		
	}

}
