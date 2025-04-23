package Serialization;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibraryPojo {
	
	private String libraryName;
	private String location;
	private List<BooksPojo> books;
	
	
	

}
