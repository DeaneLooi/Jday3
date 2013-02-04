/*******************************************************************************
 * Program Name: 			GolfingBookingDAO
 * Purpose:					create golf booking, retrieve golf booking
 * Name of Author:			Di Yuwen
 * Admin No. of Author:		120923R
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

public class GolfingBookingDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;
	
	public static void CreateBooking(GolfingBooking golfbooking) {
		
		Statement stmt = null;
		
		try {
			
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			
            // query for inserting into the table
            String query = "insert into golf(bookingno, memberid, time, date, greenfees, price) values(?,?,?,?,?,?)";
            pstmt = currentCon.prepareStatement(query);
            
            // inserting values
            pstmt.setInt(1,golfbooking.getBookingno());
            pstmt.setString(2,golfbooking.getMemberid());
            pstmt.setString(3,golfbooking.getTime());  
            pstmt.setString(4,golfbooking.getDate());
            pstmt.setString(5,golfbooking.getGreenfees());
            pstmt.setDouble(6,golfbooking.getPrice());
            pstmt.executeUpdate();
            
            String updateQuery = "UPDATE bookingno SET availability = 'not available' where bookingno ='"+golfbooking.getBookingno()+"';";
            pstmt1 = currentCon.prepareStatement (updateQuery);
            pstmt1.executeUpdate();
            
            //handle exception
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
	}
		
	public static ArrayList<GolfingBooking> retrieveAll() {
		
		GolfingBooking golfingBooking = null;
		Statement stmt = null;
		String searchQuery = "select * from golf";
		ArrayList<GolfingBooking> golfbookings = new ArrayList<GolfingBooking>();
		
		try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
            
            	 String GolfingBookingMemberid = rs.getString("memberid");
            	 int GolfingBookingBookingno = rs.getInt("bookingno");
                 String GolfingBookingTime = rs.getString("time");
                 String GolfingBookingDate = rs.getString("date");
                 String GolfingBookingGreenfee = rs.getString("greenfees");
                 Double GolfingBookingPrice = rs.getDouble("price");
                 
                 golfingBooking = new GolfingBooking();
                 golfingBooking.setMemberid(GolfingBookingMemberid);
                 golfingBooking.setBookingno(GolfingBookingBookingno);
                 golfingBooking.setTime(GolfingBookingTime);
                 golfingBooking.setDate(GolfingBookingDate);
                 golfingBooking.setGreenFees(GolfingBookingGreenfee);
                 golfingBooking.setPrice(GolfingBookingPrice);
                 golfbookings.add(golfingBooking);
                
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return golfbookings;
	}
	
/*public boolean deleteGolfBooking() throws SQLException{
		
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;	
		db.getConnection();
		
		
		dbQuery = "delete from golf where memberid = '" + memberid +"';";

		if (db.updateRequest(dbQuery) == 1){
			success = true;
		}

		db.terminate();
		return success;
	}
*/
}
