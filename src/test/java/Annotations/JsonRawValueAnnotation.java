package Annotations;

import com.fasterxml.jackson.annotation.JsonRawValue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonRawValueAnnotation {
	
	private String firstName;
	
	@JsonRawValue
	private String lastname;
	
	private String title;
	
	private int id;

}
