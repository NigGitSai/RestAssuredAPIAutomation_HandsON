package CustomerDetailsSerializationDeserialization;

import java.util.List;

import lombok.Data;

@Data
public class CustomerDetails {
	
	private String orderId;
	
	private Customer customer;
	private List<Addresses> addresses;
	
	private List<Items> items;
	
	private Payment payment;
	
	private String orderDate;
	
	private String status;
	
	private Shipping shipping;
	
	

}
