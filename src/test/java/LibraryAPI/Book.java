package LibraryAPI;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Book {
	
	private String book_name;
	private String isbn;
	
	private String aisle;
	private String author;

	 @Override
	    public String toString() {
	        return "Book{" +
	                "bookName='" + book_name + '\'' +
	                ", isbn='" + isbn + '\'' +
	                ", aisle='" + aisle + '\'' +
	                ", author='" + author + '\'' +
	                '}';
	    }
}
