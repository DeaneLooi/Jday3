package jday.entities.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import jday.entities.Member;
import jday.entities.SpaBookingDetails;
import jday.ui.user.SpaBooking;

public class SpaBookingDetailsDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;
	


	
	public static SpaBookingDetails spaBooking(SpaBookingDetails sBooking, Member m) {
		DBController db = new DBController();
		Connection currentCon = db.getConnection();
		Statement stmt = null;
		
		try {
	
            // query for inserting into the table
            String query = "insert into spakaraoke(bookingno, memberid, time, date, sessionORroomtype) values(?,?,?,?,?)";
            pstmt = currentCon.prepareStatement(query);
            
            // inserting values
            pstmt.setInt(1, BookingNoDAO.createBookNo());
            pstmt.setString(2, m.getMemberid());
            pstmt.setString(3, sBooking.getTime());  
            pstmt.setString(4, sBooking.getDate());
            pstmt.setString(5, sBooking.getSession());
            
            pstmt.executeUpdate();
            
		} catch (Exception ex) {

			System.out.println("Booking failed! " + ex);
		}

		// exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
		return sBooking;

	}
	
	public static ArrayList<SpaBookingDetails> retrieveAll() {
		SpaBookingDetails spaBookings = null;
		Statement stmt = null;
        String searchQuery = "select * from spakaraoke";
        ArrayList<SpaBookingDetails> spaBookingDetailsList = new ArrayList<SpaBookingDetails>();
        try {
            // connect to DB
        	DBController db = new DBController();
            currentCon = db.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
            
                int bookingNo = rs.getInt("bookingNo");
                String memberId = rs.getString("memberId");
                String time = rs.getString("time");
                String date = rs.getString("date");
                String session = rs.getString("session");
                
                spaBookings = new SpaBookingDetails();
                spaBookings.setBookingNo(bookingNo);
                spaBookings.setMemberId(memberId);
                spaBookings.setTime(time);
                spaBookings.setDate(date);
                spaBookings.setSession(session);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return  spaBookingDetailsList;
	}

}
