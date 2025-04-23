package Deserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import BookStorePOJO.BookStoreWrapper;
import BookStorePOJO.Bookstore;

public class DeserializationMethods {
	
	@Test(enabled=false)
	public void usingObjectMapper() throws IOException
	{
		//File bookstoreJson = new File("./src/test/resources/NewBook.json");
		File file = new File("./src/test/resources/NewBook.json");
		ObjectMapper mapper = new ObjectMapper();
		
		BookStoreWrapper bookstore = mapper.readValue(file, BookStoreWrapper.class);
		String secondBookAuthor  = bookstore.getBookstore().getBooks().get(1).getAuthor();
				
		System.out.println("secondBookAuthor "+secondBookAuthor);
		
		String location = bookstore.getBookstore().getLocation();
		System.out.println("Location "+location);
		
		String phone =bookstore.getBookstore().getContact().getPhone();
		System.out.println("Phone :"+phone);
		
	}
	
	@Test(enabled=false)
	public void usingJaywayJsonPath() throws IOException
	{
		File file = new File("./src/test/resources/NewBook.json");
		JacksonMappingProvider mappingProvider = new JacksonMappingProvider();
		
		Configuration config = Configuration.builder().mappingProvider(mappingProvider).build();
		
		DocumentContext context = JsonPath.using(config).parse(file);
		BookStoreWrapper bookstore = context.read("$", BookStoreWrapper.class);
		
		String thirdBookAuthor  = bookstore.getBookstore().getBooks().get(2).getAuthor();
		
		System.out.println("thirdBookAuthor "+thirdBookAuthor);
		
		String location = bookstore.getBookstore().getLocation();
		System.out.println("Location "+location);
		
	}
	
	
	@Test(enabled=true)
	public void usingRestAssuredJsonPath()
	{
		File file = new File("./src/test/resources/NewBook.json");
		io.restassured.path.json.JsonPath js = new io.restassured.path.json.JsonPath(file);
		
		BookStoreWrapper bookstore =	js.getObject("$",  BookStoreWrapper.class);
		String firstBookAuthor  = bookstore.getBookstore().getBooks().get(0).getAuthor();
		
		System.out.println("firstBookAuthor "+firstBookAuthor);
		
		String location = bookstore.getBookstore().getLocation();
		System.out.println("Location "+location);
	}

}
