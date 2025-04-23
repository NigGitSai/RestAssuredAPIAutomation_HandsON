package Annotations;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeEmployeePojo {
	
	@Test
	public void employeePojoSerialization() throws JsonProcessingException
	{
		EmployeePojo employee = new EmployeePojo();
		
		employee.setFirstName("John");
		

		employee.setLastname("Doe");
		
		employee.setTitle("Technical Architect");
		
		employee.setId(0);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		
		System.out.println("Using json serializer");
		
		System.out.println(json);
	}

}
