//yw's booking number
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
	
	public static BookingNo saveBookNo(BookingNo bookingNo){
		
		 Statement stmt = null;
		BookingNo bookingno = new BookingNo();
		 
		 try {
				///////////////////////////////////////////
				currentCon = DBConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				
	            // query for inserting into the table
	            String query = "insert into bookinno(bookingno, availability) values(?,?)";
	            pstmt = currentCon.prepareStatement(query);
	            // inserting values
	            
	            pstmt.setInt(1, bookingNo.getBookingno());
	            pstmt.setString(2, bookingNo.getDefaultAvailability());
	            pstmt.executeUpdate();
	            //String updateQuery = "UPDATE bookingno SET availability ='not available' where bookingno ='"+bookingNo+"';";
	            //pstmt1 = currentCon.prepareStatement(updateQuery);
				//pstmt1.executeUpdate();
	            
			} catch (Exception ex) {

				System.out.println("Fail" + ex);
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
		
		return bookingNo;
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
            
                 int bookingNobookingno = rs.getInt("bookingno");
                 String bookingNoAvailability = rs.getString("availability");
                 //problem: should be 'bookingNo.setBookingno(bookingNobookingno);'
                 bookingNo.setBookingno();
                 bookingNo.setAvailability(bookingNoAvailability);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		 return bookingList;
	 }
	
	}


