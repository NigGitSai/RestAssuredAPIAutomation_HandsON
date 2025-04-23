package Serialization;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LibraryPojoSerialization {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		
		BooksPojo books1 = new BooksPojo();
		books1.setTitle("To Kill a Mockingbird");
		books1.setAuthor("Harper Lee");
		books1.setIsbn("978-0061120084");
		books1.setPublishedYear(1960);
		
		BooksPojo books2 = new BooksPojo();
		books2.setTitle("1984");
		books2.setAuthor("George Orwell");
		books2.setIsbn("978-0451524935");
		books2.setPublishedYear(1949);
		
		BooksPojo books3 = new BooksPojo();
		books3.setTitle("The Great Gatsby");
		books3.setAuthor("F. Scott Fitzgerald");
		books3.setIsbn("978-0743273565");
		books3.setPublishedYear(1925);
		
		LibraryPojo library = new LibraryPojo();
		library.setLibraryName("City Library");
		library.setLocation("Downtown");
		library.setBooks(Arrays.asList(books1,books2,books3));
		
		LibraryRootPojo libraryRoot = new LibraryRootPojo();
		libraryRoot.setLibraryPojo(library);
		
		ObjectMapper mapper = new ObjectMapper();
		
	String requestLibraryPayload = 	mapper.writerWithDefaultPrettyPrinter().writeValueAsString(library);
		
	System.out.println(requestLibraryPayload);
	
	
		
		
		

	}

}
