package Deserialization;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPOJOWithGettersSetterAnotation {

	private int id;
	private String name;
	private double price;
	private boolean available;
}
