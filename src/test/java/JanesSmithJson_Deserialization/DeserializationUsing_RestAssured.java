package JanesSmithJson_Deserialization;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class DeserializationUsing_RestAssured {

	@Test
	public void usingRestAssuredJsonPath()
	{
		File janesSmithJson = new File("src/test/resources/JaneSmithDetails.json");
		JsonPath js = JsonPath.from(janesSmithJson);
	   String projectName = 	js.getString("projects.find{it.status=='completed'}.projectName");
	   System.out.println("Project Name is "+projectName);
	   
	   int projectID =  js.getInt("projects.find{it.projectName=='Gamma'}.projectId");
	   
	   System.out.println("Project Gamma Project ID is :"+projectID);
	   
	  String street = js.getString("address.street");
	  System.out.println("Street address :"+street);
	  
	  
	 String projNameNotCompletedStatus = js.getString("projects.find{it.status!='completed'}.projectName");
	 System.out.println("Project name status not completed : "+projNameNotCompletedStatus);
	 
	  String mobileNO = js.getString("contact.phone.mobile");
	  System.out.println("Mobile number : "+mobileNO);
	  
	  String projectNameForIDGT3 = js.getString("projects.find{it.projectId>3}.projectName");
	  System.out.println("Project name of ID which is greater than 3 "+projectNameForIDGT3);
	}
}
