package Serialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeBookingJson {
	
	@Test
	public void serializeBooking() throws JsonProcessingException
	{
		String[] strArr = new String[]{"firstName\",\"lastName\",\"email\",\"id"};
		String[] str1 = {"a","b"};
		Booking booking = new Booking();
		booking.setFirstname("Lin");
		booking.setLastname("asfa");
		booking.setTotalprice("411");
		booking.setAdditionalneeds("Breakfast");
		booking.setDepositPaid(false);
		
		BookingDates bookingDates = new BookingDates();
		bookingDates.setCheckin("2023-01-01");
		bookingDates.setCheckout("2023-02-01");
		
		booking.setBookingDates(bookingDates);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String bookingJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
		System.out.println(bookingJson);
		
	}

}
