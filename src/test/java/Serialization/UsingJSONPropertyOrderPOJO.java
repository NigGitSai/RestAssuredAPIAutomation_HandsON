package Serialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UsingJSONPropertyOrderPOJO {
	
	@Test
	public void toPracticeJSONPropertyOrder() throws JsonProcessingException
	{
		JSONPropertyOrderExPOJO jsonPropertyOrderExPojo = new JSONPropertyOrderExPOJO();
		
		jsonPropertyOrderExPojo.setEmail("jamie.doe@example.com");
		
		jsonPropertyOrderExPojo.setFirstName("Jamie");
		
		jsonPropertyOrderExPojo.setLastName("Doe");
		jsonPropertyOrderExPojo.setId(15);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json =   mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonPropertyOrderExPojo);
		
		System.out.println(json);
	}

}
