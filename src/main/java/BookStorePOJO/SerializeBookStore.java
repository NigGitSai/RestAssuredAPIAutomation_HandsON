package BookStorePOJO;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeBookStore {
	
	@Test
	public void serializeBookStore() throws JsonProcessingException
	{
		Contact contact = new Contact();
		contact.setEmail("info@grandbookstore.com");
		contact.setPhone("123-456-7890");
		
		Books book1 = new Books();
		book1.setId(4);
		book1.setTitle("The Journey of souls");
		book1.setAuthor("Michael Newton");
		book1.setGenre("non-fiction");
		book1.setPrice(20.9f);
		book1.setPublishedYear("1994");
		
		Books book2 = new Books();
		book2.setId(3);
		book2.setTitle("1984");
		book2.setAuthor("George Orwell");
		book2.setGenre("Dystopian");
		book2.setPrice(8.99f);
		book1.setPublishedYear("2011");
		
		Bookstore bookstore = new Bookstore();
		bookstore.setBooks(Arrays.asList(book1,book2));
		bookstore.setStoreName("The Grand Bookstore");
		bookstore.setLocation("Downtown City");
		bookstore.setContact(contact);
		BookStoreWrapper bookstoreWrapper = new BookStoreWrapper();
		bookstoreWrapper.setBookstore(bookstore);
		
		ObjectMapper mapper = new ObjectMapper();
		String bookstoreJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookstoreWrapper);
		System.out.println(bookstoreJson);
	}

}
