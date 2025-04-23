package JohnDetailsSerialization_Deserialization;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializaJohnDetailsPojo {

	@Test
	public void serializeJohnDetailsJson() throws IOException
	{
		Address address = new Address();
		address.setStreet("123 Main St");
		address.setCity("Metropolis");
		address.setZip("12345");
		
		Projects project1 = new Projects();
		project1.setProjectId(1);
		project1.setProjectName("Alpha");
		
		Projects project2 = new Projects();
		project2.setProjectId(2);
		project2.setProjectName("Beta");
		
		JohnDetails johnDetails = new JohnDetails();
		johnDetails.setId(100);
		johnDetails.setName("John Doe");
		
		johnDetails.setAddress(address);
		
		johnDetails.setProjects(Arrays.asList(project1,project2));
		
		ObjectMapper mapper = new ObjectMapper();
		String johnDetailsJson =   mapper.writerWithDefaultPrettyPrinter().writeValueAsString(johnDetails);
		System.out.println(johnDetailsJson);
		File file = new File("src/test/resources/JohnDetailsJsonSerialized.json");
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(johnDetailsJson);
		
		bw.close();
		fw.close();
	}
}
