package CustomerDetailsSerializationDeserialization;

import lombok.Data;

@Data
public class Items {
	
	private String productId;
	private String productName;
	private int quantity;
	private double price;
	
	private Attributes attributes;
	
	private Payment payment;

}
