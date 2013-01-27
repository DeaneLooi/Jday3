package jday.entitites.dao;

import jday.entities.SportBooking;
import jday.entities.dao.SportBookingDAO;

import org.junit.Test;

public class SportBookingDAOTest {

	@Test
	public void testCreateBooking() {
		SportBooking sportBooking = new SportBooking();
		sportBooking.setMemberid("120923r");
		sportBooking.setDate("1-1-13");
		sportBooking.setTime("1400-1500");
	//	sportBooking.setSports("badminton");
		sportBooking.setCourt(1);
		SportBookingDAO.CreateSportBooking(sportBooking);
	}

}
