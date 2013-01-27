package jday.entities.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import jday.entities.Event;

public class EventDAO {

	public static void main (String args[]) throws SQLException{
		@SuppressWarnings("deprecation")
		Date date = new Date(113, 1, 29);
		EventDAO.setEvent("titleTes234234t", date, "testVenue34234234" , "TestInfo2342342");
		
	}
	
	
	
	public static String dateToString(Date date){
		@SuppressWarnings("deprecation")
		String date2 = date.toGMTString();
		return date2 = date2.substring(0, 11);
	}
	
	public static Event getEventByDate(Date date) throws SQLException {
		// do the coding to connect to actual db;

		String date2 = dateToString(date);

		DBController db = new DBController();
		db.getConnection();
		String sql = "select * from event where date = '" + date2 + "';";
		
		ResultSet rs = db.readRequest(sql);

		Event event = new Event();
		
		try {
			
			while(rs.next()){
			event.setInfo(rs.getString("info"));
			event.setTitle(rs.getString("title"));
			event.setVenue(rs.getString("venue"));
			event.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.terminate();
		return event;
	}
	
	public static void setEvent (String title2, Date date2, String venue2, String info2) throws SQLException {
		String title = title2;
		String date = dateToString(date2);
		String venue = venue2;
		String info = info2;
		String date3 = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DBController db = new DBController ();
		con = db.getConnection();
		//overwrite entry with new entry
		String sql = "select * from event where date = '" + date + "';";
		ResultSet rs = db.readRequest(sql);
		if(rs.next()){
			String date1 = rs.getString("date");
			date3 = date1;
		}
		
		if(date3 != null){
			sql = "delete from event where date = '" + date + "';";
			db.updateRequest(sql);
			sql = "insert into event (info, title, date, venue) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info);
			pstmt.setString(2, title);
			pstmt.setString(3, date);
			pstmt.setString(4, venue);
			pstmt.executeUpdate();
		}
		
		else {
			sql = "insert into event (info, title, date, venue) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info);
			pstmt.setString(2, title);
			pstmt.setString(3, date);
			pstmt.setString(4, venue);
			pstmt.executeUpdate();
		}
		
		//delete
		//insert (create)
		//update (overwrite)
		//confirm message
		
		
		db.terminate();
		
	}
}
