package Serialization;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class LibraryRootPojo {
	private LibraryPojo library;
	
	@JsonAnyGetter
	public LibraryPojo getLibraryPojo() {
		return library;
	}

	public void setLibraryPojo(LibraryPojo library) {
		this.library = library;
	}

	

}
