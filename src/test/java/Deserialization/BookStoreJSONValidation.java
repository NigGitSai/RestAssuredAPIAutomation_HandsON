package Deserialization;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.github.fge.jsonschema.messages.JsonSchemaValidationBundle;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import io.restassured.module.jsv.JsonSchemaValidator;

public class BookStoreJSONValidation {
	
	
	@Test
	public void bookStoreJSONVerification() throws IOException
	{
		File jsonBookStore = new File("src/test/resources/JSONBookStore.json");
		
		JsonSchemaValidator.matchesJsonSchemaInClasspath("BookStoreJSONSchema.json");
		
		DocumentContext context =      JsonPath.parse(jsonBookStore);
		
		//1)How would you retrieve all the book titles from the store?
		
		List<String> bookTitle =    context.read("$.store.book[*].title");
		
		System.out.println("Book Title : "+bookTitle);
		
		
		//Extract the price of the magazine titled "National Geographic
		
		List<Double> nationalGeographicPrice = context.read("$.store.magazine[?(@.title=='National Geographic')].price");
		
		System.out.println("National Geographic magazine price : "+nationalGeographicPrice);
		
		//Get the author of the second book in the list
		
		String authorOfSecondBook = context.read("$.store.book[1].author");
		
		System.out.println("Author of second book :"+authorOfSecondBook);
		
		//4)Fetch all the titles of articles from the magazine with the issue "August 2023
		
		
		List<String> articlesTitleAug2023 =    context.read("$.store.magazine[?(@.issue=='August 2023')].articles[0:].title");
	
		System.out.println("Articles Title Aug 2023 : "+articlesTitleAug2023);
		
		//	5) Retrieve the store owner's email address

		
		String ownerEmail = context.read("$.storeOwner.contact.email");
		
		System.out.println("Owner email : "+ownerEmail);
		
		//6)  List all books that are available.
		 List<Map<String,Object>> booksAvailable =  context.read("$.store.book[?(@.available==true)].title");
		 
		 System.out.println("Books available : "+booksAvailable);
		 
		 
		 //Get the total number of pages in all articles from the "Time" magazine
		 
	List<Integer> pages = 	 context.read("$.store.magazine[?(@.title=='Time')].articles[*].pages");
	
	int totalNoOfPages = 0;
	
	for(Integer page:pages)
	{
		totalNoOfPages+=page;
	}
	System.out.println("total pages : "+totalNoOfPages);
		

		//Extract all prices of items (books and magazines) in the store
	
	 	List<Double> prices = context.read("$..price");
	 	
	 	
	 		Double totalPrice = 0.00;
	 	for(Double price : prices)
	 	{
	 		totalPrice += price;
	 	}
	 	
	 	System.out.println("Total price : "+totalPrice);
	 	
	 	
	}

}

