package AddressPojoPractice;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeAddressPojo {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		
		Address address = new Address();
		
		address.setCity("Sea grit");
		
		address.setLine1("11 cross street");
		address.setState("New Jersey");
		
		address.setZip("08004");
		
		Customer_Identifiers customer_identifiers = new Customer_Identifiers();
		
		customer_identifiers.setId("100");
		customer_identifiers.setType("Primary");
		
		AddressMainPojo addressMainPojo = new AddressMainPojo();
		
		addressMainPojo.setCustomer_identifiers(Arrays.asList(customer_identifiers));
		
		
		addressMainPojo.setAddress(address);
		
		addressMainPojo.setAddressTypeCode("P");
		
		addressMainPojo.setAddressTypeDesc("This is primary address");
		
		addressMainPojo.setUser_type("Global");
		
		ObjectMapper mapper = new ObjectMapper();
		String addressPojo = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(addressMainPojo);
		System.out.println(addressPojo);
		
	}

}
