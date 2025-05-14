package ExcludeJsonNodeAndSerialize;

import java.util.Arrays;
import java.util.HashSet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class ExcludeJsonNodeAndSerialize {

	
	public static void main(String[] args) throws JsonProcessingException {
		
		BooksPOJO books = new BooksPOJO();
		
		books.setAuthor("Michael Newton");
		books.setEdition("LV2");
		books.setIsbn("100998");
		books.setPrice(100.00);
		books.setReleaseEdition("latestV2");
		
		
		HashSet<String> excludes = new HashSet<>(Arrays.asList("releaseEdition"));
		
		ObjectMapper mapper = new ObjectMapper();
		
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		
		filterProvider.addFilter("ExcludeNode", SimpleBeanPropertyFilter.serializeAllExcept(excludes));
		mapper.setFilterProvider(filterProvider);
		String newJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(books);
		
		System.out.println("After Excluding the desired node");
		System.out.println(newJson);
	}
}
