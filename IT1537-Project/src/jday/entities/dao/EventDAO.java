package jday.entities.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import jday.entities.Event;

public class EventDAO {

	public static String dateToString(Date date){
		@SuppressWarnings("deprecation")
		String date2 = date.toGMTString();
		return date2 = date2.substring(0, 11);
	}
	
	public static Event getEventByDate(Date date) throws SQLException {
		// do the coding to connect to actual db;
		@SuppressWarnings("deprecation")
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
	
	public static void setEvent (String title2, String date2, String venue2, String info2) throws SQLException {
		String title = title2;
		String date = date2;
		String venue = venue2;
		String info = info2;
		
		DBController db = new DBController ();
		db.getConnection();
		//overwrite entry with new entry
		//confirm message
		String sql = "";
		int rs = db.updateRequest(sql);
		db.terminate();
		
	}
}
