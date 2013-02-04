/*******************************************************************************
 * Program Name: 			SpaBookingDAO
 * Purpose:					
 * Name of Author:			
 * Admin No. of Author:		
 * Module Group: 			IS1201
 * *****************************************************************************/
package jday.entities.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import jday.entities.BookingNo;
import jday.entities.Member;
import jday.entities.SpaBookingDetails;

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
            String query = "insert into spakaraoke(bookingno, memberid, time, date, session) values(?,?,?,?,?)";
            pstmt = currentCon.prepareStatement(query);
            BookingNo bookNo = BookingNoDAO.createBookNo();
            sBooking.setBookingNo(bookNo.getBookingNo());
            
            // inserting values
            pstmt.setInt(1, bookNo.getBookingNo());
            pstmt.setString(2, m.getMemberid());
            pstmt.setString(3, sBooking.getTime());  
            pstmt.setString(4, sBooking.getDate());
            pstmt.setString(5, sBooking.getSession());
            
            pstmt.executeUpdate();
            String updateQuery = "UPDATE bookingno SET availability = 'not available' where bookingno ='"+bookNo.getBookingNo()+"';";
            pstmt1 = currentCon.prepareStatement (updateQuery);
            pstmt1.executeUpdate();
            
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
                spaBookingDetailsList.add(spaBookings);
            }
      
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return  spaBookingDetailsList;
	}

}
