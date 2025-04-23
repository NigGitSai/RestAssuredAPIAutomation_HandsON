package CustomerDetailsSerializationDeserialization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class SerializeCutomerDetailsPOJO {

	/**
	 * @throws JsonProcessingException 
	 * 
	 */
	@Test
	public void serializationForCustomerDetails() throws JsonProcessingException
	{

		try
		{
			// Customer JSON details
			Customer customer = new Customer();
			customer.setCustomerId("CUST789");
			customer.setName("Jammie Max");

			//Contact Details JSON details
			ContactDetails contactDetails = new ContactDetails();
			contactDetails.setEmail("jamie.max@example.com");
			contactDetails.setPhone("+1-555-0123");


			customer.setContactDetails(contactDetails);



			//Addresses JSON Array Details 

			Addresses addresses1 = new Addresses(); 

			addresses1.setType("home");

			//Address JSON Details
			Address address = new Address();

			address.setStreet("123 Maple St");
			address.setCountry("Springfield");
			address.setZipcode("62704");
			address.setCountry("USA");

			addresses1.setAddress(address);

			Addresses addresses2 = new Addresses(); 

			addresses2.setType("office");

			Address address1 = new Address();

			address1.setStreet("456 Elm St");
			address1.setCountry("Springfield");
			address1.setZipcode("62701");
			address1.setCountry("USA");

			addresses2.setAddress(address1);

			// Attributes JSON details
			Attributes attributes = new Attributes();
			attributes.setColor("black");
			attributes.setConnectivity("wireless");

			Attributes attributes1 = new Attributes();

			attributes1.setColor("white");
			attributes1.setConnectivity("mechanical");

			// Items JSON Array details
			Items items1 = new Items();
			items1.setProductId("PROD001");
			items1.setProductName("Wireless Mouse");
			items1.setQuantity(2);
			items1.setPrice(25.99);
			items1.setAttributes(attributes1);

			Items items2 = new Items();

			items2.setProductId("PROD002");
			items2.setProductName("Mechanical Keyboard");
			items2.setQuantity(1);
			items2.setPrice(89.99);
			items2.setAttributes(attributes1);

			//Payment JSON details
			Payment payment = new Payment();

			payment.setPaymentId("PAY98765");
			payment.setMethod("Credit Card");	

			payment.setAmount(141.99);
			payment.setCurrency("USD");
			payment.setStatus("completed");

			// Shipping JSON details
			Shipping shipping = new Shipping();

			shipping.setCarrier("UPS");
			shipping.setTrackingNumber("1Z9999999999999999");
			shipping.setEstimatedDelivery("2024-11-08T18:00:00Z");

			CustomerDetails customerDetails = new CustomerDetails();

			customerDetails.setOrderId("ORD1234");
			customerDetails.setCustomer(customer);

			customerDetails.setAddresses(Arrays.asList(addresses1,addresses2));

			customerDetails.setItems(Arrays.asList(items1,items2));

			customerDetails.setPayment(payment);
			customerDetails.setOrderDate("2024-11-03T10:30:00Z");

			customerDetails.setStatus("shipped");

			customerDetails.setShipping(shipping);

			ObjectMapper mapper = new ObjectMapper();

			String customerDetialsPOJO = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerDetails);

			System.out.println(customerDetialsPOJO);
			
			DocumentContext context = JsonPath.parse(customerDetialsPOJO);
			
			List<HashMap<String,Object>> addressList =    context.read("$.addresses[?(@.type=='home')]");
		
			System.out.println("Address with type as \"home\". "+addressList);
			
			List<HashMap<String,Object>> productList =    context.read("$.items[?(@.productName=='Wireless Mouse')]");
			
			System.out.println("Find the Item with a product Name of \"Wireless Mouse\" : "+productList);
			
			productList =    context.read("$.items[?(@.price>50)]");
			
			System.out.println("Get the Attributes of Items with a Price Above $50.00 : "+productList);
			
			addressList = context.read("$.addresses[?(@.address.zipCode=='62701')]");
			
			System.out.println("Retrieve the Address where the zipcode is \"62701\". "+addressList);
			
			productList = context.read("$.items[?(@.quantity>1)]");
			
			System.out.println("Products with Quantity greater than 1 "+productList);
			
			List<HashMap<String,Object>> paymentList = context.read("$.payment[?(@.status=='completed')]");
			
			System.out.println("Get Payment Details Only if the Status is \"completed\"."+paymentList);
			
			List<HashMap<String,Object>> shippingDetails = context.read("$.shipping[?(@.carrier=='UPS')]");
			
			System.out.println("Extract Shipping Information with carrier set to UPS "+shippingDetails);
			
			addressList =    context.read("$.addresses[?(@.address.country=='USA')]");
			
			System.out.println("Retrieve the Address(es) Located in \"USA\"  "+addressList);
			
			//$.items[?(@.attributes.connectivity=='Mechanical Keyboard')]
			
			productList = context.read("$.items[?(@.quantity<2 && @.price>20)]");
			System.out.println(" Get All Items with quantity Less Than 2 and price Greater Than $20. "+productList);
			
			
			
		}
		catch(JsonProcessingException e)
		{
			System.out.println("Error in serializing Customer Details: "+e.getMessage());
		}
		
		
	}
}
