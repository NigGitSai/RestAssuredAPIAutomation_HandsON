package Serialization;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class usingJacksonAnyGetterAnnotation {
	
	@Test
	public void JacksonAnyGetter() throws JsonProcessingException
	{
		CreateBooking createBooking = new CreateBooking();
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("firstname", "Jammie");
		map.put("lastname", "Dow");
		map.put("totalprice", 141);
		map.put("depositpaid", true);
		
		HashMap<String,Object> bookingdates = new HashMap<String,Object>();
		
		bookingdates.put("checkin", "2023-01-01");
		
		bookingdates.put("checkout", "2023-02-01");
		
		map.put("bookingdates", bookingdates);
		
		map.put("additionalneeds", "Dinner");
		
		createBooking.setBooking(map);
		
		ObjectMapper mapper = new ObjectMapper();
		String ipJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(createBooking);
		
		System.out.println("Input JSON request ");
		System.out.println(ipJson);
	}

}
