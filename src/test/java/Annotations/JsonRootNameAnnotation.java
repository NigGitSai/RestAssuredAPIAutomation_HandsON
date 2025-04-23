package Annotations;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;

@JsonRootName(value="employee")
@Getter
@Setter
public class JsonRootNameAnnotation {
	
private String firstName;
	
	
	private String lastname;
	
	private String title;
	
	private int id;

}
