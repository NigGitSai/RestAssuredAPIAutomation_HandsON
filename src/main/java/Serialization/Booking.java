package Serialization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;


@JsonPropertyOrder({"totalprice","bookingDates","additionalneeds"})
public class Booking {
	
	private String firstname;
	private String lastname;
	@JsonAlias({"TotalPrice","totalprice"})
	private String totalprice;
	private boolean depositPaid;
	private BookingDates bookingDates;
	
	private String additionalneeds;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public boolean isDepositPaid() {
		return depositPaid;
	}

	public void setDepositPaid(boolean depositPaid) {
		this.depositPaid = depositPaid;
	}

	public BookingDates getBookingDates() {
		return bookingDates;
	}

	public void setBookingDates(BookingDates bookingDates) {
		this.bookingDates = bookingDates;
	}

	@JsonGetter(value="needs")
	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
	
	

}
