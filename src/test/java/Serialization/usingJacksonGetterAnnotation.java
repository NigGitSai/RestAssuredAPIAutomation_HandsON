package Serialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class usingJacksonGetterAnnotation {
	
	@Test
	public void usingJacksonGetterAnnotation() throws JsonProcessingException
	{
		JSONGetterPOJO jsonGetterPOJO = new JSONGetterPOJO();
		
		jsonGetterPOJO.setfirstname("Jammie");
		jsonGetterPOJO.setLastname("Doe");
		jsonGetterPOJO.setTotalPrice(123);
		jsonGetterPOJO.setAdditionalneeds("Dinner");
		
		BookingDates bookingDates = new BookingDates();
		
		bookingDates.setCheckin("2018-01-01");
		
		bookingDates.setCheckout("2018-05-01");
		
		jsonGetterPOJO.setBookingdates(bookingDates);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonReq = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonGetterPOJO);
		
		System.out.println(jsonReq);
	}

}
