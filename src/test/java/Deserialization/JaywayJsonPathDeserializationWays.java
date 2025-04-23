package Deserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class JaywayJsonPathDeserializationWays {
	
 File file ;
	String title="";
	@BeforeClass
	public void fetchInpJson()
	{
		file = new File("./src/test/resources/BookStore.json");
	}
	
	@Test
	public void usingReadFunction() throws IOException
	{
		 title = JsonPath.read(file, "$.store.book[0].title");
		 System.out.println("Using Standard Read function title is "+title);
	}
	

	@Test
	public void usingDefaultConfiguration()throws IOException
	{
		FileInputStream ip = new FileInputStream(file);
		Object parsedJson =  Configuration.defaultConfiguration().jsonProvider().parse(ip.readAllBytes());
		title = JsonPath.read(parsedJson, "$.store.book[0].title");
		String responseJson = "";
				
		System.out.println("Using default configuration "+title);
	}
	
    @Test
    public void usingFluentAPI() throws IOException
    {
    	DocumentContext context = JsonPath.parse(file);
    	
    	title = context.read("$.store.book[0].title");
    	System.out.println("Using Fluent API "+title);
    }
    
    @Test
    public void usingDefaultConfigAndFluentAPI() throws IOException
    {
    	Configuration configuration = Configuration.defaultConfiguration().addOptions(Option.REQUIRE_PROPERTIES);
    	
    	DocumentContext context = JsonPath.using(configuration).parse(file);
    	title = context.read("$.store.book[0].title");
    	System.out.println("Using default Configuration "+title);
    }

}
