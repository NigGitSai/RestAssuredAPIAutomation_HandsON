package AddressPojoPractice;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressMainPojo {

	private List<Customer_Identifiers> customer_identifiers;
	
	private String addressTypeCode;
	
	private String addressTypeDesc;
	
	private Address address;
	
	private String user_type;
}
