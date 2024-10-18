package Serialization;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class CreateBooking {

	
	HashMap<String,Object> booking = new HashMap<String,Object>();

	@JsonAnyGetter
	public HashMap<String, Object> getBooking() {
		return booking;
	}

	public void setBooking(HashMap<String, Object> booking) {
		this.booking = booking;
	}
	
	
}
