package Annotations;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

@JsonSerialize(using=CustomSerializer.class)
@Getter
@Setter
public class EmployeePojo {

	private String firstName;
	
	
	private String lastname;
	
	private String title;
	
	private int id;
}
