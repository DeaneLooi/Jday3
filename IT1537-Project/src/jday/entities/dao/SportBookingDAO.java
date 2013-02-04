/*******************************************************************************
 * Program Name: 			SportBookingDAO
 * Purpose:					create sport and retrieve sports
 * Name of Author:			Di Yuwen
 * Admin No. of Author:		120923r
 * Module Group: 			IS1201
 * *****************************************************************************/
package jday.entities.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jday.entities.dao.DBConnectionManager;
import jday.entities.*;

import jday.entities.SportBooking;

public class SportBookingDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;
	
	public static SportBooking sportbooking(SportBooking sportbooking, Member m){
		
		Statement stmt = null;
		
		try{
		
		currentCon = DBConnectionManager.getConnection();
		stmt = currentCon.createStatement();
		
        // query for inserting into the table
        String query = "insert into sports(bookingno, memberid, time, date, court, sport) values(?,?,?,?,?,?)";
        pstmt = currentCon.prepareStatement(query);
        
        // inserting values
        pstmt.setInt(1,sportbooking.getBookingno());
        pstmt.setString(2,m.getMemberid());
        pstmt.setString(3,sportbooking.getTime());  
        pstmt.setString(4,sportbooking.getDate());
        pstmt.setInt(5,sportbooking.getCourt());
        pstmt.setString(6,sportbooking.getSport());
        pstmt.executeUpdate();
        
        String updateQuery = "UPDATE bookingno SET availability = 'not available' where bookingno ='"+sportbooking.getBookingno()+"';";
        pstmt1 = currentCon.prepareStatement (updateQuery);
        pstmt1.executeUpdate();
        
		} catch (Exception ex) {

			System.out.println("Book fail" + ex);
		}
		
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
		return sportbooking;
	
	}
	
	
	public static ArrayList <SportBooking> retrieveAll() {
		
		SportBooking sportBooking = null;
		Statement stmt = null;
		String searchQuery = "select * from sports";
		ArrayList<SportBooking> sportbookings = new ArrayList<SportBooking>();
		
		try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
            
            	 String SportBookingMemberid = rs.getString("memberid");
            	 int SportBookingBookingno = rs.getInt("bookingno");
                 String SportBookingTime = rs.getString("time");
                 String SportBookingDate = rs.getString("date");
                 int SportBookingCourt = rs.getInt("court");
                 String SportBookingSport = rs.getString("sport");
                 
                 sportBooking = new SportBooking();
                 sportBooking.setMemberid(SportBookingMemberid);
                 sportBooking.setBookingno(SportBookingBookingno);
                 sportBooking.setTime(SportBookingTime);
                 sportBooking.setDate(SportBookingDate);
                 sportBooking.setCourt(SportBookingCourt);
                 sportBooking.setSport(SportBookingSport);
                 sportbookings.add(sportBooking);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return sportbookings;
	}

}
