package Serialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeJsonPropertyOrder2 {
	
	@Test
	public void serializeJsonPropertyOrder() throws JsonProcessingException
	{
		JsonPropertyOrderEx2 propertyOrderPojo = new JsonPropertyOrderEx2();
		propertyOrderPojo.setEmail("John.doe@gm.com");
		
		propertyOrderPojo.setFirstName("John");
		
		propertyOrderPojo.setId(4);
		propertyOrderPojo.setLastName("doe");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(propertyOrderPojo);
		
		System.out.println("Json payload : "+ json);
	}

}
