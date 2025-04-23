package JohnDetailsSerialization_Deserialization;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.Option;

import io.restassured.path.json.JsonPath;

public class Deserialization_UsingJaywayJsonPath {

	@Test
	public void deserializeJanesSmithJson() throws IOException
	{
		File janesSmithJson = new File("src/test/resources/JaneSmithDetails.json");

		Configuration config =	Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
		DocumentContext context =  com.jayway.jsonpath.JsonPath.using(config).parse(janesSmithJson);
		//$.projects[?(@.status=='completed')].projectName
		List<String> projectName = context.read("$.projects[?(@.status=='completed')].projectName");
		Assert.assertEquals("Delta", projectName.get(0));

		 List<String> projectID =  context.read("$.projects[?(@.projectName=='Gamma')].projectId");
		Assert.assertEquals(3, projectID.get(0));


		List<String> street = context.read("$.address[?(@.city=='Gotham')].street");
		Assert.assertEquals("456 Oak Ave", street.get(0));
		
	List<Object> projects =	context.read("$.projects[?(@.status!='completed')]");
	System.out.println("Projects not completed : "+projects);
	
	
	    String mobileNO = context.read("$.contact.phone.mobile");
	    System.out.println("Mobile no is "+mobileNO);
	    
	  List<String> projectNameWhereIDGT3 =   context.read("$.projects[?(@.projectId>3)].projectName");
	  System.out.println("Project name for Project ID greater than 3 :"+projectNameWhereIDGT3.get(0));
	  
	List<Object> projectsStartWD =  context.read("$.projects[?(@.projectName =~/.*D.*/i)]");
	System.out.println("Projects starting with D : "+projectsStartWD);
	 
	List<String>  email = context.read("$.contact[?(@.phone.mobile=~/.*5678.*/)].email");
	Assert.assertEquals("jane.smith@example.com", email.get(0));
	
	//Logical AND Operators
	List<String> projectNameStatusOngoing =   context.read("$.projects[?(@.projectId=='3' && @.status=='ongoing')].projectName"	);
	System.out.println("Project name with status on going "+projectNameStatusOngoing);
	
	//Logical OR Operators
		List<String> projectNameID4StatusCompleted =   context.read("$.projects[?(@.projectId=='4' || @.status=='ongoing')].projectName"	);
		System.out.println("Project name with status on going or with id as 4 "+projectNameID4StatusCompleted);
		
		//Logical NOT Operators
				List<String> projectNameStatusNotCompleted =   context.read("$.projects[?(!(@.status=='completed'))].projectName");
				System.out.println("Project name with status not completed "+projectNameStatusNotCompleted);
	
	 
	}
}
