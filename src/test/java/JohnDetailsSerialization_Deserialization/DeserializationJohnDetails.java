package JohnDetailsSerialization_Deserialization;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;


public class DeserializationJohnDetails {
	public static File johnDetailsJson;
	
	@BeforeClass
	public void initializeJsonFile()
	{
		johnDetailsJson = new File("src/test/resources/JohnDetails.json");
	}
	
	@Test
	public void deserializeUsingObjectMapper() throws StreamReadException, DatabindException, IOException
	{
	
		ObjectMapper mapper = new ObjectMapper();
		JohnDetails johnDetails =	mapper.readValue(johnDetailsJson, JohnDetails.class);
		
		Assert.assertEquals("Metropolis", johnDetails.getAddress().getCity());
		
		Assert.assertEquals("Beta", johnDetails.getProjects().get(1).getProjectName());
	}
	
	@Test
	public void deserializeUsingJaywayJsonPath() throws IOException
	{
		JacksonMappingProvider mappingProvider = new JacksonMappingProvider();
	    Configuration configuration =	Configuration.builder().mappingProvider(mappingProvider).build();
	    JohnDetails johnDetails =  JsonPath.using(configuration).parse(johnDetailsJson).read("$", JohnDetails.class);
	    Assert.assertEquals(johnDetails.getId(), 101);
	}
	
	@Test
	public void deserializationUsingRestAssuredJsonPath()
	{
		io.restassured.path.json.JsonPath jsonPath = io.restassured.path.json.JsonPath.from(johnDetailsJson);
		JohnDetails johnDetails =   jsonPath.getObject("$", JohnDetails.class);
		 Assert.assertEquals(johnDetails.getId(), 101);
	}
	
	

}
