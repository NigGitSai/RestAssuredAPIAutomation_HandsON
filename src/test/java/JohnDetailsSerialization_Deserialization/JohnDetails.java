package JohnDetailsSerialization_Deserialization;

import java.util.List;

import lombok.Data;

@Data

public class JohnDetails {
	
	private int id;
	private String name;
	private Address address;
	private List<Projects> projects;
	

}
