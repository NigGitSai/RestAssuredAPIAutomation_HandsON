package Deserialization;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class DeserUsingJaywayJsonPath {
	
	@Test
	public void deserUsingJaywayJsonPath() throws IOException
	
	{
		File file = new File("./src/test/resources/BookStore.json");
		DocumentContext context = JsonPath.parse(file);
		
		List<String> bookTitle = context.read("$.store.book[*].title");
		System.out.println("All Book Titles "+bookTitle);
		
		bookTitle =  context.read("$.store.book[?(@.price>10)].title");
		System.out.println("Book title price which is greater than 10 "+bookTitle);
		
		bookTitle =  context.read("$.store.book[?(@.author=='Yuval Noah Harari')].title");
		System.out.println("Book title written by Yuval Noah Harari "+bookTitle);
		
		int count = context.read("$.store.book.length()");
		System.out.println("No of books "+count);
		
		//List<String> keysFirstBook = context.read("$.store.book[0].keys()");
		//System.out.println("First key book "+keysFirstBook);
		
		List<Double> prices = context.read("$.store.book[*].price");
		double totalPrice= 0.00;
		for(Double price: prices)
		{
			totalPrice = totalPrice+price;
		}
		
		System.out.println("Total Price "+totalPrice);
		
		List<String> michelleObamaBoook = context.read("$.store.book[?(@.price>10 && @.author=='Michelle Obama')].title");
		System.out.println("Michelle Obama Book "+michelleObamaBoook);
		
		String bookJson = "{\r\n"
				+ "  \"store\": {\r\n"
				+ "    \"books\": [\r\n"
				+ "      {\r\n"
				+ "        \"title\": \"The Alchemist\",\r\n"
				+ "        \"author\": { \"name\": \"Paulo Coelho\", \"country\": \"Brazil\" },\r\n"
				+ "        \"price\": 9.99\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}\r\n"
				+ "";
		context = JsonPath.parse(bookJson);
		List<String> authorName = context.read("$.store.books[*].author.name");
		
		System.out.println("Author Name is "+authorName);
		
		String bookJson2 = "{\r\n"
				+ "  \"store\": {\r\n"
				+ "    \"books\": [\r\n"
				+ "      {\r\n"
				+ "        \"type\": \"EBook\",\r\n"
				+ "        \"title\": \"Digital Minimalism\",\r\n"
				+ "        \"author\": \"Cal Newport\",\r\n"
				+ "        \"fileSizeMB\": 2.5\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"type\": \"HardCover\",\r\n"
				+ "        \"title\": \"Atomic Habits\",\r\n"
				+ "        \"author\": \"James Clear\",\r\n"
				+ "        \"weightKG\": 1.2\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}\r\n"
				+ "";
		
		context = JsonPath.parse(bookJson2);
		
	   List<Map<String,Object>> ebookTypeEntry =	 context.read("$.store.books[?(@.type=='EBook')]");
	   
	   System.out.println("Ebook Entry tile "+ebookTypeEntry.get(0).get("title"));
		
	   String jsonBook3 = "{\r\n"
	   		+ "  \"store\": {\r\n"
	   		+ "    \"books\": [\r\n"
	   		+ "      {\r\n"
	   		+ "        \"title\": \"The Alchemist\",\r\n"
	   		+ "        \"price\": 9.99\r\n"
	   		+ "      },\r\n"
	   		+ "      {\r\n"
	   		+ "        \"title\": \"Unnamed Book\"\r\n"
	   		+ "      }\r\n"
	   		+ "    ]\r\n"
	   		+ "  }\r\n"
	   		+ "}\r\n"
	   		+ "";
	  
	    context =  JsonPath.parse(jsonBook3);
	    List<Map<String,Object>> booksPriceNotNull = context.read("$.store.books[*]");
	    booksPriceNotNull.stream()
        .filter(book -> book.containsKey("price") && book.get("price") != null)
        .forEach(System.out::println);
	    
		
	}

}
