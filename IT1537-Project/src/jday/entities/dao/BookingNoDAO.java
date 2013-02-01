package jday.entities.dao;

import jday.entities.dao.DBConnectionManager;
import jday.entities.BookingNo;
import jday.entities.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BookingNoDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;
	
	public static BookingNo createBookNo(){
		
		Statement stmt = null;
		BookingNo bookingno = new BookingNo();
		int bookingNo = bookingno.setBookingNo();
		 
		 try {
			 	DBController db = new DBController();
				currentCon = db.getConnection();
				stmt = currentCon.createStatement();
				
	            // query for inserting into the table
	            String query = "insert into bookingno(bookingno, availability) values(?,?)";
	            pstmt = currentCon.prepareStatement(query);
	            
	            // inserting values
	            pstmt.setInt(1, bookingNo);
	            pstmt.setString(2, bookingno.getDefaultAvailability());
	           
	            pstmt.executeUpdate();
	            
	            
			} catch (Exception ex) {

				System.out.println("Failed " + ex);
			}
		 
		// exception handling
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
		
		return bookingno;
	} 
	

	public static ArrayList<BookingNo> retrieveAll() {
		 
		BookingNo bookingNo = null;
		Statement stmt = null;
	    String searchQuery = "select * from bookingno";
	    ArrayList<BookingNo> bookingList = new ArrayList<BookingNo>();
		
	    try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
            
                 int bookingNumber= rs.getInt("bookingno");
                 String bookingNoAvailability = rs.getString("availability");
                 bookingNo.setBookingNo();
                 bookingNo.setAvailability(bookingNoAvailability);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		 return bookingList;
	 }
	
	public static void main (String [] args){
		BookingNo bookNo = BookingNoDAO.createBookNo();
		System.out.println(bookNo.getBookingNo());
	}
	
	}


