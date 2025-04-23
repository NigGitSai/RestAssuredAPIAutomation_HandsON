package Annotations;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRawValueTest {
	
	
	@Test
	public void jsonRawValue() throws JsonProcessingException
	{
		JsonRawValueAnnotation jsonRawValueAnnotation = new JsonRawValueAnnotation();
		
		//jsonRawValueAnnotation.setFirstName("John");
		

		jsonRawValueAnnotation.setLastname("Doe");
		
		jsonRawValueAnnotation.setTitle("Technical Architect");
		
		jsonRawValueAnnotation.setId(0);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonRawValueAnnotation);
		
		System.out.println("Output  json ");
		
		System.out.println(json);
	}

}
