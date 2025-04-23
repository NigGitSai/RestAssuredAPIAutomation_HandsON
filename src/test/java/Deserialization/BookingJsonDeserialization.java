package Deserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class BookingJsonDeserialization {

	@Test(enabled = false)
	public void usingMethod1() throws IOException
	{
		File file = new File("./src/test/resources/booking.json");
		
		List<String> customerEmails= JsonPath.read(file,"$.bookings[*].customer.email");
		System.out.println("Customer Emails "+customerEmails);
	}
	

	@Test(enabled = false)
	public void usingMethod2() throws IOException
	{
		File file = new File("./src/test/resources/booking.json");
		FileInputStream fis = new FileInputStream(file);
		
		Object parsedJson = Configuration.defaultConfiguration().jsonProvider().parse(fis.readAllBytes());
		
		List<String> customerEmails= JsonPath.read(parsedJson,"$.bookings[*].customer.email");
		System.out.println("Customer Emails "+customerEmails);
	}
	
	@Test
	public void usingMethod3() throws IOException
	{
		File file = new File("./src/test/resources/booking.json");
		FileInputStream fis = new FileInputStream(file);
		
		Configuration config = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
		
		DocumentContext context = JsonPath.using(config).parse(file);
		List<String> customerEmails= context.read("$.bookings[*].customer.email");
		System.out.println("Customer Emails "+customerEmails);
		
		List<String> roomNumber = context.read("$.bookings[?(@.id==101)].room.number");
		System.out.println("Room Number :"+roomNumber);
		
		List<String> checkInDateList =  context.read("$.bookings[*].checkInDate");
		System.out.println("Check In Date :"+checkInDateList);
		
		List<String> bookingStatusPendingCustomers = context.read("$.bookings[?(@.status=='Pending')].customer.name");
		
		System.out.println("Pending booking Status Customer "+bookingStatusPendingCustomers);
		
		List<String> bookingIdForRoomTypeAsSuite = context.read("$.bookings[?(@.room.type=='Suite')].id");
		System.out.println("Room Type as Suite Booking ID "+bookingIdForRoomTypeAsSuite);
		
		
		List<Double> bookingsPrice = context.read("$.bookings[*].price");
		double total=0.0;
		for(Double price : bookingsPrice)
		{
			total=total+price;
		}
		System.out.println("Booking total price "+total);
		
		List<String> customersName = context.read("$.bookings[*].price$.bookings[?(@.price>300)].customer.name");
		
		System.out.println("Customers Name "+ customersName);
		
		List<String> bookingStatusOfJane = context.read("$.bookings[?(@.customer.email=='jane.smith@example.com')].status");
		
		System.out.println("Booking Status of Jane "+bookingStatusOfJane);
	}

}
