package Deserialization;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class UsingFilterCriteria {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("./src/test/resources/NewBook.json");
		
		Configuration config=Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
		
		DocumentContext context = JsonPath.using(config).parse(file);
		
		Filter filter = Filter.filter(Criteria.where("author").is("J.D. Salinger").and("price").gt(10.00));
		
		List<String> bookTitle = context.read("$.bookstore.books[?].title",filter);
		System.out.println("Book title : "+bookTitle);
	}

}
