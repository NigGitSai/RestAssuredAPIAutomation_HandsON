package LibraryAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

public class SerializeBookPojo {
	
	public static void main(String[] args) throws JsonProcessingException {
		
		Book book = new Book();
		
		book.setBook_name("Learn Appium Automation with Java");
		book.setIsbn("yuuio");
		
		book.setAisle("875678");
		book.setAuthor("John foer");
		
	
		
		MainBookPojo bookPojo = new MainBookPojo();
		
		bookPojo.setBook(Arrays.asList(book));
		
		ObjectMapper mapper = new ObjectMapper();
		  List<Book> books = Collections.singletonList(book); 
		
		String bookJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(books);
		
		System.out.println(bookJson);
		
		String bookName = JsonPath.read(bookJson, "$.[0].book_name");
		
		List<Book> books1 = mapper.readValue(bookJson, new TypeReference<List<Book>>() {});
        for (Book ele : books1) {
            System.out.println(book);
        }
        System.out.println(books1.get(0).getAisle());
		
		/*MainBookPojo book2 = mapper.readValue(bookJson, MainBookPojo.class);
		
		System.out.println("Retreive Isbn using Object Mapper : "+book2.getBook().get(0).getIsbn());
		
		JacksonMappingProvider mappingProvider = new JacksonMappingProvider();
		
		Configuration configuration = Configuration.builder().mappingProvider(mappingProvider).build();
		
		MainBookPojo book3 = JsonPath.using(configuration).parse(bookJson).read("$",MainBookPojo.class);
		
		System.out.println("Retreive Aisle using Jackson Mapping Provider : "+book3.getBook().get(0).getAisle());
		
		io.restassured.path.json.JsonPath js = new io.restassured.path.json.JsonPath(bookJson);
		MainBookPojo book4 =  js.getObject("$", MainBookPojo.class);
		
		System.out.println("Retreive author using Rest Assured Json path : "+book4.getBook().get(0).getAuthor());
			*/
	}
	

}
