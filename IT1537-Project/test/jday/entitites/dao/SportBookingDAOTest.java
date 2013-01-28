package jday.entitites.dao;

import jday.entities.BookingNo;
import jday.entities.Member;
import jday.entities.SportBooking;
import jday.entities.dao.SportBookingDAO;

import org.junit.Test;

public class SportBookingDAOTest {

	@Test
	public void testCreateBooking() {
		BookingNo bookno = new BookingNo();
		//bookno.setBookingNo();
		Member m= new Member();
		SportBooking sportBooking = new SportBooking();
		sportBooking.setMemberid("12");
		sportBooking.setDate("1-1-13");
		sportBooking.setTime("1400-1500");
		sportBooking.setSport("badminton");
		sportBooking.setCourt(2);
		sportBooking.setBookingno(4);
		SportBookingDAO.sportbooking(sportBooking, m);
	}

}
