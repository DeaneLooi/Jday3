package jday.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import jday.entities.dao.DBController;

public class Register {


	private int registerno;
	private String eventclass;
	private String memberid;
	private String availability;
	
	
	public Register(Member m){
		memberid = m.getMemberid();

	}
	
	public Register() {
		super();
	
	}

	public int setRegisterno(){
		Random randomNumber = new Random();
		registerno = (int)randomNumber.nextInt(99999);
		return registerno;
	}
	public int getRegisterno() {
		return registerno;
	}
	public String getEventclass() {
		return eventclass;
	}
	public void setEventclass(String eventclass) {
		this.eventclass = eventclass;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	
	public String getAvailability() {
		return availability;
	}
	public String getDefaultAvailability(){
		availability = "available";
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	public Register register(Register r) throws SQLException{

		DBController db = new DBController();
		String dbQuery;	
		String updateQuery;
		Connection con = db.getConnection();	
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		dbQuery = "INSERT INTO Register(registerno,eventclass,memberid) values(?,?,?)";
		
		
		try{
			pstmt = con.prepareStatement(dbQuery);
			pstmt.setInt(1,registerNumber());
			pstmt.setString(2,r.getEventclass());
			pstmt.setString(3, r.getMemberid());
			pstmt.executeUpdate();
			updateQuery = "UPDATE Registerno SET availability ='not available' where registerno ='"+registerno+"';";
			pstmt1 = con.prepareStatement(updateQuery);
			pstmt1.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	    
		db.terminate();
		return r;
	}
	
	public int registerNumber(){
		DBController db = new DBController();
		String dbQuery;	
		Connection con = db.getConnection();	
		PreparedStatement pstmt = null;
		
		dbQuery = "INSERT INTO Registerno(registerno,availability) values(?,?)";
		
		registerno = setRegisterno();
		try{
			pstmt = con.prepareStatement(dbQuery);
			pstmt.setInt(1,registerno);
			pstmt.setString(2, getDefaultAvailability());
			pstmt.executeUpdate();
		
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		db.terminate();
		return registerno;
	}
}
