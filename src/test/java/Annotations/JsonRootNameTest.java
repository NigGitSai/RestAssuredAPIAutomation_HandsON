package Annotations;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonRootNameTest {

	@Test
	public void employeePojoTest() throws JsonProcessingException
	{
		JsonRootNameAnnotation employee = new JsonRootNameAnnotation();
		
		employee.setFirstName("John");
		

		employee.setLastname("Doe");
		
		employee.setTitle("Technical Architect");
		
		employee.setId(0);
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		
		String resultJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		
		System.out.println("Using Json root name");
		
		System.out.println(resultJson);
	}
}
