package Deserialization;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import static com.jayway.jsonpath.Filter.*;
import static com.jayway.jsonpath.Criteria.where;

public class JaywayJsonpathFilterExp {
	
	@Test
	public void filterCriteriaPractice() throws IOException
	{
		File storeJson = new File("./src/test/resources/BookStore.json");
		
		DocumentContext context = JsonPath.parse(storeJson);
		
		Filter filterCriteria = Filter.filter(Criteria.where("price").gt(10).and("author").is("Michelle Obama"));
		
		List<String> bookTitle = context.read("$.store.book[?].title",filterCriteria);
		
		System.out.println(bookTitle);
		
	}

}
