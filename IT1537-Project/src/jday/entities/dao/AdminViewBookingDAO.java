package jday.entities.dao;

import jday.entities.dao.DBConnectionManager;
import jday.entities.Booking;
import jday.entities.BookingNo;
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
		 
		 	//ArrayList <RegisterBooking> Registerbookings = RegisterBooking.retrieveCourses();
		 	ArrayList <GolfingBooking> golfbookings = GolfingBookingDAO.retrieveAll();
		 	ArrayList<SportBooking> sportbookings = SportBookingDAO.retrieveAll();
		 	ArrayList<SpaBookingDetails> spabookings = SpaBookingDetailsDAO.retrieveAll();
		 	
		 		
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
		    	booking.setVenue(sportbooking.getSport());
		    	bookings.add(booking);
		    }
		    
		   for (SpaBookingDetails spabooking : spabookings) {
			    BookingNo bookno= new BookingNo();
			    bookno.setBookingNo();
			    
		    	Booking booking = new Booking();
		    	booking.setBookingno(spabooking.getBookingNo());
		    	booking.setMemberid(spabooking.getMemberId());
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
		    
		   /*
		    
		    for (CourseBooking coursebooking : coursebookings){
		    	Booking booking = new Booking();
		    	BookingNo bookno= new BookingNo();
				bookno.setBookingNo();
				
		    	booking.setBookingno(coursebooking.getRNo());
		    	booking.setMemberid(coursebooking.getMemberId());
		    	booking.setVenue(coursebooking.getVenue());
		    	booking.setTime(coursebooking.getDate());
		    }
		   */
		    return bookings;
		    
		
		}
}
