package jday.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import jday.entities.dao.DBConnectionManager;
import jday.entities.dao.DBController;

public class Register {


	private int registerno;
	private String eventclass;
	private String memberid;
	private String availability;
	private String time;
	
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
	//
	public String getTime() {
		return time;
	}
	//
	public void setTime(String time) {
		this.time = time;
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
	
	public static ArrayList <Register> retrieveAll(){
		Register register = null;
		ResultSet rs = null;
		DBController db = new DBController();
		Connection con = db.getConnection();	
		Statement stmt = null;
		ArrayList<Register> registers = new ArrayList<Register>();
		
		try{
			stmt = con.createStatement();
			String dbQuery = "select * from register";
			rs = stmt.executeQuery(dbQuery);
		
			while(rs.next()){
				String memberid = rs.getString("memberid");
				int registerno = rs.getInt("registerno");
				String venue = rs.getString("eventclass");
				
				register = new Register();
				register.setMemberid(memberid);
				register.setRegisterno();
				register.setEventclass(venue);
				registers.add(register);
	
		}
				
		}catch (Exception e){
			e.printStackTrace();
		}
		return registers;
	}
	
}
