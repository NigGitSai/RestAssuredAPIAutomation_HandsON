package ExcludeJsonNodeAndSerialize;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonFilter("ExcludeNode")
public class BooksPOJO {
	
	private String isbn;
	private String edition;
	private String author;
	private double price;
	private String releaseEdition;

}
