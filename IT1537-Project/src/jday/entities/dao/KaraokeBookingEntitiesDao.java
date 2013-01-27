package jday.entities.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import jday.entities.BookingNo;
import jday.entities.Member;
import jday.entities.KaraokeBookingEntities;
import jday.entities.KaraokeBookingEntities;
import jday.ui.user.KaraokeBooking;

public class KaraokeBookingEntitiesDao {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;
	

	public static KaraokeBookingEntities karaokeBooking(KaraokeBookingEntities kBooking, Member m) {
		DBController db = new DBController();
		Connection currentCon = db.getConnection();
		
		Statement stmt = null;
		
		
		try {
	
            // query for inserting into the table
            String query = "insert into spakaraoke(bookingno, memberid, time, date, sessionORroomtype) values(?,?,?,?,?)";
            pstmt = currentCon.prepareStatement(query);
            BookingNo bookNo = BookingNoDAO.createBookNo();
            kBooking.setBookingNo(bookNo.getBookingNo());
            
            // inserting values
            pstmt.setInt(1, bookNo.getBookingNo());
            pstmt.setString(2, m.getMemberid());
            pstmt.setString(3, kBooking.getTime());  
            pstmt.setString(4, kBooking.getDate());
            pstmt.setString(5, kBooking.getRooms());

            
            pstmt.executeUpdate();
            String updateQuery = "UPDATE bookingno SET availability = 'not available' where bookingno ='"+bookNo.getBookingNo()+"';";
            pstmt1 = currentCon.prepareStatement (updateQuery);
            pstmt1.executeUpdate();
            
		} catch (Exception ex) {

			System.out.println("Booking failed!" + ex);
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
		return kBooking;

	}
	
	public static ArrayList<KaraokeBookingEntities> retrieveAll() {
		KaraokeBookingEntities kBookings = null;
		Statement stmt = null;
        String searchQuery = "select * from spakaraoke";
        ArrayList<KaraokeBookingEntities> karaokeBookingEntitiesList = new ArrayList<KaraokeBookingEntities>();
        try {
            // connect to DB
        	DBController db = new DBController();
            currentCon = db.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
                String bookingNo = rs.getString("bookingNo");
                String memberId = rs.getString("memberId");
                String time = rs.getString("time");
                String date = rs.getString("date");
                String rooms = rs.getString("room");
                
                kBookings = new KaraokeBookingEntities();
                kBookings.setMemberId(memberId);
                kBookings.setTime(time);
                kBookings.setDate(date);
                kBookings.setRooms(rooms);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return  karaokeBookingEntitiesList;
	}

	
}


