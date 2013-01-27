package jday.entities.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import jday.entities.Event;

public class EventDAO {

	public static Event getEventByDate(Date date) throws SQLException {
		// do the coding to connect to actual db;
		@SuppressWarnings("deprecation")
		String date2 = date.toGMTString();
		date2 = date2.substring(0, 11);

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
		return event;

	}
}
