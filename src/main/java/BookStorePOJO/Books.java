package BookStorePOJO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Books {
	
	private int id;
	private String title;
	private String author;
	private String genre;
	private float price;
	private String publishedYear;

}
