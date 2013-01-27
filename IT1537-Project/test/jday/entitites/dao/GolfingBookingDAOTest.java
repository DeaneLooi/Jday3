package jday.entitites.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import jday.entities.GolfingBooking;
import jday.entities.Member;
import jday.entities.dao.GolfingBookingDAO;

import org.junit.Test;

public class GolfingBookingDAOTest {

	@Test
	public void testCreateBooking() {
		GolfingBooking golfingBooking =new GolfingBooking();
		golfingBooking.setMemberid("yuwen");
		golfingBooking.setDate("yuwen");
		golfingBooking.setTime("1400-1500");
		golfingBooking.setGreenFees("100.00");
		golfingBooking.setBookingno(656733);
		GolfingBookingDAO.CreateBooking(golfingBooking);
	}

	@Test
	public void testRetrieveAll() {
		
		//ArrayList<GolfingBooking> golfbookings = GolfingBooking.retrieveAll();
		//for (GolfingBooking golgbookings: golfbookings)
		//System.out.println(golfbookings.getBookingno()+"," + golfbookings.getMemberid()+ ","+ golfbookings.getVenue() + "," +golfbookings.getTime() + ",");
		
	}

}
