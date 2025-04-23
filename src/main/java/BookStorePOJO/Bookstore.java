package BookStorePOJO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bookstore {

	private List<Books> books;
	
	private String storeName;
	
	private String location;
	
	private Contact contact;
}
