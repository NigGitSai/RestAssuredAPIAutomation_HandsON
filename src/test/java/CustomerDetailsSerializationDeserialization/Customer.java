package CustomerDetailsSerializationDeserialization;

import lombok.Data;

@Data
public class Customer {

	private String customerId;
	
	private String name;
	private ContactDetails contactDetails;
}
