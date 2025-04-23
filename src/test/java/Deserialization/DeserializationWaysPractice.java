package Deserialization;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import Serialization.LibraryPojo;
import Serialization.LibraryRootPojo;
import io.restassured.common.mapper.TypeRef;
import io.restassured.specification.RequestSpecification;

public class DeserializationWaysPractice {
	String responseJson="";
	
RequestSpecification requestSpec;
	
	@BeforeClass
	public void test1()
	{
		requestSpec = given().baseUri("https://rahulshettyacademy.com/").contentType("application/json").queryParam("key", "qaclick123");
		
	}
	@Test
	public void usingObjectMapper() throws JsonMappingException, JsonProcessingException
	{
		
		ObjectMapper mapper = new ObjectMapper();
		
	   LibraryRootPojo libraryRoot =	mapper.readValue(responseJson, LibraryRootPojo.class);
	   
	   
	}
	
	@Test
	public void usingJaywayJsonPath()
	{
		JacksonMappingProvider mappingProvider = new JacksonMappingProvider();
		Configuration configuration = Configuration.builder().mappingProvider(mappingProvider).build();
		
		 LibraryRootPojo libraryRoot = JsonPath.using(configuration).parse(responseJson).read("$", LibraryRootPojo.class);
	}
	
	@Test
	public void usingRestAssuredJsonPath()
	{
		io.restassured.path.json.JsonPath jsonPath = io.restassured.path.json.JsonPath.from(responseJson);
		LibraryRootPojo libraryRootPojo =    jsonPath.getObject("",LibraryRootPojo.class);
		libraryRootPojo =    jsonPath.getObject("$",LibraryRootPojo.class);
	}
	
	@Test
	public void usingRestAssuredAsFunction()
	{
		Map<String,Object> response = given()
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -328500,\r\n"
				+ "    \"lng\": 31.927365\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 89,\r\n"
				+ "  \"name\": \"Wedfaf house\",\r\n"
				+ "  \"phone_number\": \"(+91) 232 232 3937\",\r\n"
				+ "  \"address\": \"29, side lane, asff 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"ENGLISH-IN\"\r\n"
				+ "}\r\n"
				+ "")
		.log()
		.all()
		.spec(requestSpec)
		.when()
		.post("maps/api/place/add/json")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.extract()
		.response()
		.as(new TypeRef<Map<String,Object>>(){});
	}
}
