package Serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserialization {
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		String bookingJson ="{\r\n"
				+ "  \"TotalPrice\" : \"411\",\r\n"
				+ "  \"bookingDates\" : {\r\n"
				+ "    \"checkin\" : \"2023-01-01\",\r\n"
				+ "    \"checkout\" : \"2023-02-01\"\r\n"
				+ "  },\r\n"
				+ "  \"needs\" : \"Breakfast\",\r\n"
				+ "  \"firstname\" : \"Lin\",\r\n"
				+ "  \"lastname\" : \"asfa\",\r\n"
				+ "  \"depositPaid\" : false\r\n"
				+ "}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		Booking booking = mapper.readValue(bookingJson, Booking.class);
		
		System.out.println(booking.getTotalprice());
	}

}
