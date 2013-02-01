//randomly generated booking no
package jday.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import jday.entities.dao.DBController;

public class BookingNo {

	private int bookingNo;
	private String availability;

	public BookingNo() {
		super();
	}

	public int setBookingNo() {
		Random randomNumber = new Random();
		bookingNo = (int) randomNumber.nextInt(99999);
		return bookingNo;
	}

	public int getBookingNo() {
		return bookingNo;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	//by default, the availability is available
	public String getDefaultAvailability() {
		availability = "available";
		return availability;
	}

}
