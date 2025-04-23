package PracticeAddressPojo_Deserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import AddressPojoPractice.AddressMainPojo;

public class DeserializeUsingPojoClass {

	@Test(enabled = false)
	public void usingJacksonDatabiind() throws JsonMappingException, JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		AddressMainPojo addressMainPojo = mapper.readValue(returnResponseJson(), AddressMainPojo.class);
		
		String customerID = addressMainPojo.getCustomer_identifiers().get(0).getId();
		
		System.out.println("Customer ID "+customerID);
		
		String city = addressMainPojo.getAddress().getCity();
		
		System.out.println("City "+city);
		
		String addressTypeCode = addressMainPojo.getAddressTypeCode();
		System.out.println("Address type code "+addressTypeCode);
		
		
	}
	
	@Test(enabled = true)
	public void usingJaywayjsonpathJacksonMappingProvider() throws JsonMappingException, JsonProcessingException
	{
		
		JacksonMappingProvider jacksonMappingProvider = new JacksonMappingProvider();
		
		Configuration configuration = Configuration.builder().mappingProvider(jacksonMappingProvider).build();
		
		AddressMainPojo addressMainPojo =     JsonPath.using(configuration).parse(returnResponseJson()).read("$",AddressMainPojo.class);
		
		
		
		
		
		String customerID = addressMainPojo.getCustomer_identifiers().get(0).getId();
		
		System.out.println("Customer ID "+customerID);
		
		String city = addressMainPojo.getAddress().getCity();
		
		System.out.println("City "+city);
		
		String addressTypeCode = addressMainPojo.getAddressTypeCode();
		System.out.println("Address type code "+addressTypeCode);
		
		
	}
	
	@Test(enabled = true)
	public void usingRestAssuredJsonPath()
	{
		io.restassured.path.json.JsonPath is = new io.restassured.path.json.JsonPath(returnResponseJson());
		
		AddressMainPojo addressMainPojo =   is.getObject("$", AddressMainPojo.class);
		
		String customerID = addressMainPojo.getCustomer_identifiers().get(0).getId();
		
		System.out.println("Customer ID "+customerID);
		
		String city = addressMainPojo.getAddress().getCity();
		
		System.out.println("City "+city);
		
		String addressTypeCode = addressMainPojo.getAddressTypeCode();
		System.out.println("Address type code "+addressTypeCode);
		
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
