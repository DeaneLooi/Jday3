package jday.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import jday.entities.dao.DBController;


public class BookingNo {
	
	private int bookingno;
	private String availability;
	
	public BookingNo() {
		super();
	
	}

	public int setBookingno(){
		Random randomNumber = new Random();
		bookingno = (int)randomNumber.nextInt(99999);
		return bookingno;
	}
	public int getBookingno() {
		return bookingno;
	}
	public String getAvailability() {
		return availability;
	}
	public String getDefaultAvailability(){
		availability = "available";
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}

}
