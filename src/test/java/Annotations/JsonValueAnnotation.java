package Annotations;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonValueAnnotation {
	@JsonValue
private String firstName;
	
	
	private String lastname;
	@JsonValue
	private String title;
	
	private int id;
	
	
	public String usethis()
	{
		return this.title;
	}
	

}
