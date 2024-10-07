package Deserialization;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import io.restassured.module.jsv.JsonSchemaValidator;

public class OrdersJSONVerification {

	@Test
	public void ordersJSONVerification() throws IOException
	{
		File ordersJSON = new File("src/test/resources/Orders.json");
		
		JsonSchemaValidator.matchesJsonSchemaInClasspath("OrdersJSONSchema.json");

		DocumentContext context =   JsonPath.parse(ordersJSON);

		//What are the names of all customers who have placed an order?

		List<String> cusName = context.read("$.orders[*].customer.name");

		System.out.println("Customer Name : "+cusName);

		//Retrieve the total amount of the order with orderId 1002.

		List<Double> totalAmount =   context.read("$.orders[?(@.orderId==1002)].totalAmount");

		//List the names of products purchased by Bob Smith.

		List<String> items = context.read("$.orders[?(@.customer.name=='Bob Smith')].items[*].name");

		System.out.println("Items purchased by Bob Smith  : "+items);

		//4) Find all the product IDs for items under the "Electronics" category.

		List<String> productID =  context.read("$.orders[*].items[?(@.category=='Electronics')].productId");

		System.out.println("Product ID : "+productID);


		//Retrieve all orders where the status is "Delivered."

		List<String> orderId =    context.read("$.orders[?(@.status=='Delivered')].orderId");

		System.out.println("Order ID : "+orderId);

		//How many orders contain the product "Laptop"?

		List<String> orderID =  context.read("$.orders[?(@.items[?(@.name=='Laptop')])].orderId");


		System.out.println("Order ID having Product Laptop :"+orderID);


		//Extract the email addresses of all customers who ordered more than one item in their order.


		List<String> email =  context.read("$.orders[?(@.items.length()>1)].customer.email");

		System.out.println("Customer email : "+email);

		//Retrieve the quantity of the "Book" purchased in any order.

		List<Integer> booksQuantity =	context.read("$.orders[*].items[?(@.name=='Book')].quantity");

		// Find the total price of all products in the category "Electronics" across all orders.

		List<Double> prices =	context.read("$.orders[*].items[?(@.category=='Electronics')].price");

		double totalPrice = 0;		

		for(Double price : prices)
		{
			totalPrice += price;
		}

		System.out.println(" Total price is : "+totalPrice);

		// Identify orders where the totalAmount is greater than 1000.

		List<String> ordersWTotalAmountGEThousand =	context.read("$.orders[?(@.totalAmount>1000)].orderId");

		System.out.println("Order having total amount greater than 1000 : "+ordersWTotalAmountGEThousand);
	}
}
