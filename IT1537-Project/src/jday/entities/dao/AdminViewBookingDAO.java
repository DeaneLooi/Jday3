/*******************************************************************************
 * Program Name: 			AdminViewBookingDAO
 * Purpose:					call all the 'retrieveAll()' in different DAO
 * Name of Author:			Di Yuwen
 * Admin No. of Author:		120923r
 * Module Group: 			IS1201
 * *****************************************************************************/
package jday.entities.dao;

import jday.entities.dao.DBConnectionManager;
import jday.entities.Booking;
import jday.entities.BookingNo;
import jday.entities.CourseBooking;
import jday.entities.GolfingBooking;
import jday.entities.KaraokeBookingEntities;
import jday.entities.Member;
import jday.entities.Register;
import jday.entities.SpaBookingDetails;
import jday.entities.SportBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminViewBookingDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;

	// no common field in the database, try to get all the tables return
	// bookingno, memberid, time, venue
	public static ArrayList<Booking> retrieveAll() {

		// retrieveAll method in

		ArrayList<GolfingBooking> golfbookings = GolfingBookingDAO
				.retrieveAll();
		ArrayList<SportBooking> sportbookings = SportBookingDAO.retrieveAll();
		ArrayList<SpaBookingDetails> spaBookingDetailsList = SpaBookingDetailsDAO
				.retrieveAll();
		ArrayList<Register> registers = Register.retrieveAll();
		ArrayList<CourseBooking> courseBookings = CourseBooking.retrieveAll();

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

		for (SportBooking sportbooking : sportbookings) {
			Booking booking = new Booking();

			BookingNo bookno = new BookingNo();
			bookno.setBookingNo();
			booking.setBookingno(sportbooking.getBookingno());
			booking.setMemberid(sportbooking.getMemberid());
			booking.setTime(sportbooking.getTime());
			booking.setVenue(sportbooking.getSport());
			bookings.add(booking);
		}

		for (SpaBookingDetails spabooking : spaBookingDetailsList) {
			Booking booking = new Booking();
			BookingNo bookno = new BookingNo();
			bookno.setBookingNo();

			booking.setBookingno(spabooking.getBookingNo());
			booking.setMemberid(spabooking.getMemberId());

			booking.setVenue(spabooking.getSession());
			booking.setTime(spabooking.getTime());
			bookings.add(booking);
		}

		for (Register re : registers) {
			Booking booking = new Booking();
			Register registerno = new Register();
			registerno.setRegisterno();
			booking.setBookingno(re.getRegisterno());
			booking.setMemberid(re.getMemberid());
			booking.setVenue(re.getEventclass());
			//for (CourseBooking cb : courseBookings) {
			//	Booking b = new Booking();
			//	b.setTime(cb.getTiming());
			//	bookings.add(b);
			//}
			booking.setTime("For members to decide");
			bookings.add(booking);
		}

		return bookings;

	}
	
}
