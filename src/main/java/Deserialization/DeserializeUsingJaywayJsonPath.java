package Deserialization;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class DeserializeUsingJaywayJsonPath {

	@Test(enabled = true)
	public void usingFluentAPI() throws IOException
	{
		File file = new File("./src/test/resources/NewBook.json");
		
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
		
		DocumentContext context = JsonPath.using(config).parse(file);
		
		List<String> title = context.read("$.bookstore.books[*].title");
		System.out.println(title);
		System.out.println(title.size());
		
		title = context.read("$.bookstore.books[0:].title");
		System.out.println(title);
		
		title = context.read("$..title");
		System.out.println(title);
		
		String secondBookTitle = context.read("$.bookstore.books[1].title");
		System.out.println(secondBookTitle);
		
		String bookStoreName = context.read("$.bookstore.storeName");
		System.out.println(bookStoreName);
		
		List<Map<String,Object>> booksOfFictionGenre =    context.read("$.bookstore.books[?(@.genre=='Fiction')]");
		
		System.out.println(booksOfFictionGenre);
		
		List<String> booksPublishedBefore1960=    context.read("$.bookstore.books[?(@.publishedYear<1960)].title");
		
		System.out.println(booksPublishedBefore1960);
		
		List<String> booksHavingPriceGreaterThan10 = context.read("$.bookstore.books[?(@.price>10)].title");
		
		System.out.println(booksHavingPriceGreaterThan10);
		
	    List<String> booksWithTitle_The = 	context.read("$.bookstore.books[?(@.title=~/.*The.*/i)].title");
		System.out.println(booksWithTitle_The);
		
		String email = context.read("$.bookstore.contact.email");
		System.out.println(email);
		
		List<Map<String,Object>> bookTitlePrice =context.read("$.bookstore.books[*].['title','price']");
		
		System.out.println(bookTitlePrice);
		
		io.restassured.path.json.JsonPath js = new io.restassured.path.json.JsonPath(file);
		
		String bookStoreLocation = js.getString("bookstore.location");
		System.out.println(bookStoreLocation);
		
		List<Float> prices = js.getList("bookstore.books.price");
		for(Float price : prices)
		{
			assertTrue(price<20.0);
		}
		
		String title1 = js.getString("bookstore.books.find{it.genre=='Fiction'}.title");
		System.out.println(title1);
		
		List<String> title2 =   js.getList("bookstore.books.findAll{it.price>10}.title");
		System.out.println(title2);
	}
	
	@Test(enabled = false)
	public void usingMethod2() throws InvalidJsonException, IOException
	{
		File file = new File("./src/test/resources/NewBook.json");
		FileInputStream fis = new FileInputStream(file);
		
	    Object parsedJson =   Configuration.defaultConfiguration().jsonProvider().parse(fis.readAllBytes());
	    
	  String firstBookTitle =   JsonPath.read(parsedJson, "$.bookstore.books[1].title");
	  System.out.println(firstBookTitle);
	}
	
	@Test(enabled = false)
	public void usingMethod3() throws InvalidJsonException, IOException
	{
		File file = new File("./src/test/resources/NewBook.json");
		
	  String firstBookTitle =   JsonPath.read(file,"$.bookstore.books[1].title");
	  System.out.println(firstBookTitle);
	}
}
