package PracticeAddressPojo_Deserialization;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class DeserializationUsing_JaywayjsonPath {

	@Test
	public void usingMethod1()
	{
		String line1 = JsonPath.read(returnResponseJson(), "$.address.line1");
		System.out.println("Address line "+line1);
	}
	
	@Test
	public void usingMethod2() throws InvalidJsonException, IOException
	{
		FileInputStream ip = new FileInputStream("./src/test/resources/AddressMainJson.json");
		Object parsedJson = Configuration.defaultConfiguration().jsonProvider().parse(ip.readAllBytes());
		String line1 = JsonPath.read(parsedJson, "$.address.line1");
		System.out.println("Address line using default configuration"+line1);
	}
	
	@Test
	public void usingFluentAPI()
	{
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
		
		DocumentContext context = JsonPath.using(config).parse(returnResponseJson());
		
		String line1 = context.read("$.address.line1");
		
		System.out.println("Address line using fluent API "+line1);
		
	}
	
	public String returnResponseJson()
	{
		return "{\r\n"
				+ "  \"customer_identifiers\" : [ {\r\n"
				+ "    \"id\" : \"100\",\r\n"
				+ "    \"type\" : \"Primary\"\r\n"
				+ "  } ],\r\n"
				+ "  \"addressTypeCode\" : \"P\",\r\n"
				+ "  \"addressTypeDesc\" : \"This is primary address\",\r\n"
				+ "  \"address\" : {\r\n"
				+ "    \"line1\" : \"11 cross street\",\r\n"
				+ "    \"city\" : \"Sea grit\",\r\n"
				+ "    \"state\" : \"New Jersey\",\r\n"
				+ "    \"zip\" : \"08004\"\r\n"
				+ "  },\r\n"
				+ "  \"user_type\" : \"Global\"\r\n"
				+ "}";
	}
}
