package jday.entities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jday.entities.dao.DBController;


public class CourseBooking{

	private String memberid;
	private  String coursetype;
	private String fees;
	private String timing;
	private String venue;
	private String description;
	
	public CourseBooking() {
		super();
	}
	
	public CourseBooking(String coursetype){
		this.coursetype = coursetype;
	}
	
	public CourseBooking(String coursetype,String fees, String timing, String venue,String description){
		this.coursetype = coursetype;
		this.fees = fees;
		this.timing = timing;
		this.venue = venue;
		this.description = description;
	}




	public String getCoursetype() {
		return coursetype;
	}


	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}


	public String getFees() {
		return fees;
	}

	public void setTiming(String timing){
		this.timing=timing;
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

	public boolean deleteCourse() throws SQLException{
		
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;	
		db.getConnection();

		dbQuery = "DELETE FROM CLASS WHERE class = '" + coursetype +"';";

		if (db.updateRequest(dbQuery) == 1){
			success = true;
		}

		db.terminate();
		return success;
	}
	
	public CourseBooking createClass(CourseBooking c){
		DBController db = new DBController();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;

		String query = "insert into class(class,fees,timing,venue,description) values(?,?,?,?,?)";
		try{
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, c.getCoursetype());
		pstmt.setString(2, c.getFees());
		pstmt.setString(3, c.getTiming());
		pstmt.setString(4, c.getVenue());
		pstmt.setString(5,c.getDescription());
		pstmt.executeUpdate();
		
		}catch (Exception ex) {

			System.out.println("Creating Course failed: An Exception has occurred! "
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
	public static ArrayList<CourseBooking> retrieveCourses(){
		ResultSet rs = null;
		DBController db = new DBController();
		Connection con =db.getConnection();
		ArrayList<CourseBooking> classList = new ArrayList<CourseBooking>();
		Statement stmt = null;
		
		try{
		stmt = con.createStatement();
		String retrieve = "select class from class;";
		rs = stmt.executeQuery(retrieve);
	

	while(rs.next()){
			    String coursetype = rs.getString("class"); 
			    CourseBooking c = new CourseBooking();
			    c.setCoursetype(coursetype);
			    classList.add(c);
	}
		   
		}catch(Exception e){
			e.printStackTrace();
		}
		db.terminate();
		return classList;
	}

	public boolean retrieveCourse(){
		boolean success = true;
		ResultSet rs = null;
		DBController db = new DBController();
		Connection con = db.getConnection();
		Statement stmt = null;
		
		try{
			stmt = con.createStatement();
			String retrieve = "select * from class where class ='"+coursetype+"';";
			rs = stmt.executeQuery(retrieve);
			
			while(rs.next()){
				coursetype = rs.getString(1);
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
	//////////
	public static ArrayList <CourseBooking> retrieveAll(){
		CourseBooking courseBooking = null;
		ResultSet rs = null;
		DBController db = new DBController();
		Connection con = db.getConnection();	
		Statement stmt = null;
		ArrayList<CourseBooking> courseBookings = new ArrayList<CourseBooking>();
		
		try{
			stmt = con.createStatement();
			String dbQuery = "select * from class";
			rs = stmt.executeQuery(dbQuery);
		
			while(rs.next()){
				String timing = rs.getString("timing");
				
				courseBooking = new CourseBooking();
				courseBooking.setTiming(timing);
				courseBookings.add(courseBooking);
	
		}
				
		}catch (Exception e){
			e.printStackTrace();
		}
		return courseBookings;
	}
}
