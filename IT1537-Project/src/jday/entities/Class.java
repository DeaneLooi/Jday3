package jday.entities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import jday.entities.dao.DBController;


public class Class{

	private String memberid;
	private  String classtype;
	private String fees;
	private String timing;
	private String venue;
	private String description;
	
	public Class() {
		super();
	}
	
	public Class(String memberid, String classtype){
		this.memberid = memberid;
		this.classtype = classtype;
	}
	
	public Class(String classtype,String fees, String timing, String venue,String description){
		this.classtype = classtype;
		this.fees = fees;
		this.timing = timing;
		this.venue = venue;
		this.description = description;
	}


	public String getMemberid() {
		return memberid;
	}


	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}


	public String getClasstype() {
		return classtype;
	}


	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}


	public String getFees() {
		return fees;
	}



	public String getTiming() {
		return timing;
	}



	public String getVenue() {
		return venue;
	}
	
	public String getDescription(){
		return description;
	}

	
	public Class createClass(Class c){
		DBController db = new DBController();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;

		String query = "insert into class(class,fees,timing,venue,description) values(?,?,?,?,?)";
		try{
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, c.getClasstype());
		pstmt.setString(2, c.getFees());
		pstmt.setString(3, c.getTiming());
		pstmt.setString(4, c.getVenue());
		pstmt.setString(5,c.getDescription());
		pstmt.executeUpdate();
		
		}catch (Exception ex) {

			System.out.println("Creating Class failed: An Exception has occurred! "
					+ ex);
		}

		// exception handling
		finally {


			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
				pstmt = null;
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}

				con = null;
			}
		}
		return c;
	}
	public static ArrayList<Class> retrieveClasses(){
		ResultSet rs = null;
		DBController db = new DBController();
		Connection con =db.getConnection();
		ArrayList<Class> classList = new ArrayList<Class>();
		Statement stmt = null;
		
		try{
		stmt = con.createStatement();
		String retrieve = "select class from class;";
		rs = stmt.executeQuery(retrieve);
	

	while(rs.next()){
			    String classtype = rs.getString("class"); 
			    Class c = new Class();
			    c.setClasstype(classtype);
			    classList.add(c);
	}
		   
		}catch(Exception e){
			e.printStackTrace();
		}
		db.terminate();
		return classList;
	}

	public boolean retrieveClass(){
		boolean success = true;
		ResultSet rs = null;
		DBController db = new DBController();
		Connection con = db.getConnection();
		Statement stmt = null;
		
		try{
			stmt = con.createStatement();
			String retrieve = "select * from class where class ='"+classtype+"';";
			rs = stmt.executeQuery(retrieve);
			
			while(rs.next()){
				classtype = rs.getString(1);
				fees = rs.getString(2);
				timing = rs.getString(3);
				venue = rs.getString(4);
				description = rs.getString(5);
			}
		}	catch(Exception e ){
			e.printStackTrace();
			success = false;
		}
		db.terminate();
		return success;
	}
}
