package CustomerDetailsSerializationDeserialization;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shipping {

	private String carrier;
	
	private String trackingNumber;
	private String estimatedDelivery;
}
