package Serialization;

import com.fasterxml.jackson.annotation.JsonGetter;

public class JSONGetterPOJO {
	
	private String firstname;
	
	private String lastname;
	
	private int totalPrice;
	
	private boolean depositpaid;
	
	private String additionalneeds;
	
	private BookingDates bookingdates;
	
	public BookingDates getBookingdates() {
		return bookingdates;
	}

	public void setBookingdates(BookingDates bookingdates) {
		this.bookingdates = bookingdates;
	}

	public void setfirstname(String firstname)
	{
		this.firstname = firstname;
	}
	
	@JsonGetter(value ="FirstNameAs")
	public String getfirstname()
	{
		return this.firstname;
	}

	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@JsonGetter(value ="TotalValue")
	public int getTotalPrice() {
		return totalPrice;
	}
	
	@JsonGetter(value ="TotalValue1")
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
	
}
