package jday.entities.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBController {
	private Connection con;
	private String dbSource="//localhost:3306/jdaydatabase";
	private String user="myuser";	  // the username of the sql user
	private String password="jday";  // your password of the sql user
	
	/********************************************************
	 * Method Name : testDriver
	 * Input Parameter : nil 
	 * Purpose : To test if the driver is properly installed
	 * Return :nil
	 *******************************************************/
	public static void testDriver() throws Exception { 
		System.out.println("Initializing Server... "); 
	try { 
		Class.forName("com.mysql.jdbc.Driver"); 
		System.out.println(" Driver Found."); 
	} 
	catch (ClassNotFoundException e) { 
		System.out.println(" Driver Not Found, exiting.."); 
		throw (e); 
		} 
	} 

	public Connection getConnection(){ 
		String url = ""; 
		try { 
			url = "jdbc:mysql:"+dbSource; 
			con=DriverManager.getConnection(url,user,password);
			System.out.println("Successfully connected to " + dbSource+ "."); 
		} 
		catch (java.sql.SQLException e) { 
			System.out.println("Connection failed ->"+ dbSource); 
			System.out.println(e); 
		} 
		
		return con;
	} 
	
	/************************************************************
	 * Method Name : readRequest 
	 * Input Parameter : String (database query) 
	 * Purpose : Obtain the result set from the db query 
	 * Return : resultSet (records from the query)
	 ************************************************************/
	public ResultSet readRequest(String dbQuery) {
		ResultSet rs = null;
		System.out.println("DB Query: " + dbQuery);
		try {
			// create a statement object
			Statement stmt = con.createStatement();
			// execute an SQL query and get the result
			rs = stmt.executeQuery(dbQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	
	/***********************************************************
	 * Method Name : terminate 
	 * Input Parameter : nil 
	 * Purpose : Close db conection 
	 * Return :nil
	 **********************************************************/
	public void terminate() {
		// close connection
		try {
			con.close();
			System.out.println("Connection is closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public int updateRequest(String dbQuery) throws SQLException {
		
		Connection con=null;
		Statement stmt=null;
		int returnCode=1;
		try {
			// step 1
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdaydatabase","myuser","jday");
					
			// step 2
			stmt=con.createStatement();
			
			
			// step 3
			//System.out.println(dbQuery);
			returnCode=stmt.executeUpdate(dbQuery);
			
			// step 4
			System.out.println(returnCode+" row(s) inserted/modified");
			
		} catch (SQLException ex){
			ex.printStackTrace();
			returnCode = 0;
		} finally {
			// step 5
			if (stmt!=null) stmt.close();
			if (con!=null) con.close();
		}
		return returnCode;
	}
}