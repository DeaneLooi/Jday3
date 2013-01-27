package jday.entities.dao;

import jday.entities.dao.DBConnectionManager;
import jday.entities.Booking;
import jday.entities.CourseBooking;
import jday.entities.Event;
import jday.entities.GolfingBooking;
import jday.entities.SpaBookingDetails;
import jday.entities.SportBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminViewBookingDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;

	 public static ArrayList<Booking> retrieveAll() {
		 
		 	//ArrayList <CourseBooking> coursebookings = CourseBooking.retrieveAll();
		 	ArrayList <GolfingBooking> golfbookings = GolfingBookingDAO.retrieveAll();
		 	ArrayList<SportBooking> sportbookings = SportBookingDAO.retrieveAll();
		 	ArrayList<SpaBookingDetails> spabookings = SpaBookingDetailsDAO.retrieveAll();
		 	//ArrayList<Event> eventbookings = EventDAO.retrieveAll();
		 		
		    ArrayList<Booking> bookings = new ArrayList<Booking>();
		    
		    for (GolfingBooking golfbooking : golfbookings) {
		    	Booking booking = new Booking();
		    	booking.setBookingno(134321);
		    	booking.setBookingno(golfbooking.getBookingno());
		    	booking.setVenue("Golf course");
		    	booking.setTime(golfbooking.getTime());
		    	booking.setMemberid(golfbooking.getMemberid());
		    	bookings.add(booking);
		    }
		    
		    for (SportBooking sportbooking : sportbookings){
		    	Booking booking = new Booking();
		    	booking.setBookingno(sportbooking.getBookingno());
		    	booking.setMemberid(sportbooking.getMemberid());
		    	booking.setTime(sportbooking.getTime());
		    	booking.setVenue("Sports hall");
		    	bookings.add(booking);
		    }
		    
		  /*  for (SpaBookingDetails spabooking : spabookings) {
		    	Booking booking = new Booking();
		    	booking.setBookingno(spabooking.getBookingno());
		    	booking.setMemberid(spabooking.getMemberid());
		    	if (spabooking.getSession()==null) {
		    		// then this is a karaoke booking
		    		booking.setVenue("Karaoke room");
		    	} 
		    	else {
		    		booking.setVenue("Spa");
		    	}
		    	booking.setTime(spabooking.getTime());
		    	bookings.add(booking);
		    }
		    
		   
		    for (CourseBooking coursebooking : coursebooking){
		    	Booking booking = new Booking();
		    	booking.setBookingno(coursebooking.getBookingno());
		    	booking.setMemberid(coursebooking.getMemberid());
		    	booking.setVenue(coursebooking.getVenue());
		    	booking.setTime(coursebooking.getDate());
		    }
		   */
		    return bookings;
		    
		
		}
}
