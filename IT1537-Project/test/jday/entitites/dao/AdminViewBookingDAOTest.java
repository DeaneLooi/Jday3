package jday.entitites.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import jday.entities.Booking;
import jday.entities.dao.AdminViewBookingDAO;

import org.junit.Test;

public class AdminViewBookingDAOTest {

	@Test
	public void testRetrieveAll() {
		ArrayList<Booking> bookings = AdminViewBookingDAO.retrieveAll();
		for (Booking booking:bookings) {
			System.out.println(booking.getMemberid());
			System.out.println(booking.getVenue());
			System.out.println(booking.getTime());
			System.out.println(booking.getBookingno());
			
			
		}
	}

}
