package CustomerDetailsSerializationDeserialization;

import lombok.Data;

@Data
public class Payment {
	
	private String paymentId;
	
	private String method;
	
	private double amount;
	private String currency;
	
	private String status;

}
