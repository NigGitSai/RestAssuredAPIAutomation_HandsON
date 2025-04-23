package Annotations;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonvalueAnnotationTest {

	@Test
	public void jsonValueAnnotation() throws JsonProcessingException
	{
	JsonValueAnnotation jsonValueAnnotation = new JsonValueAnnotation();
	
	jsonValueAnnotation.setFirstName("John");
	

	jsonValueAnnotation.setLastname("Doe");
	
	jsonValueAnnotation.setTitle("Technical Architect");
	
	jsonValueAnnotation.setId(0);
	
	ObjectMapper mapper = new ObjectMapper();
	  String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonValueAnnotation);
	  
	  System.out.println("Result Json using Json Value annotation");
	  
	  System.out.println(json);
	
	}
}
