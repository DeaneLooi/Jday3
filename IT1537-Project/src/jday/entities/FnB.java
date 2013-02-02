package jday.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jday.entities.dao.DBController;

public class FnB {

	int bookingno;
	String fnborder;
	int quantity;
	String venue;
	double price;

	public FnB(int bookingno, String fnborder, int quantity, String venue, double price) {
		super();
		this.bookingno = bookingno;
		this.fnborder = fnborder;
		this.quantity = quantity;
		this.venue = venue;
		this.price = price;
	}

	public FnB() {
		super();
	}

	public int getBookingno() {
		return bookingno;
	}

	public void setBookingno(int bookingno) {
		this.bookingno = bookingno;
	}

	public String getFnborder() {
		return fnborder;
	}

	public void setFnborder(String fnborder) {
		this.fnborder = fnborder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public FnB createOrder(FnB fnb, Member m) {
		boolean success = false;
		DBController db = new DBController();
		Connection currentCon = db.getConnection();
		ResultSet rs1;
		Statement stmt = null;
		String memberid;
		boolean check;
		try {

			stmt = currentCon.createStatement();
			String getMax = "select Max(BOOKINGNO) from FNB";
			rs1 = stmt.executeQuery(getMax);
			rs1.next();
			int maxId = rs1.getInt(1);
			int bookingno = maxId;
			fnb.setBookingno(bookingno);

			String dbquery = "select memberid from fnb where bookingno ="+ maxId;
			rs1 = stmt.executeQuery(dbquery);
			rs1.next();
			memberid = rs1.getString(1);
			if (m.getMemberid().equals(memberid))
				check = true;

			else {
				check = false;

				if (maxId == 0 || check == false) {
					maxId = maxId + 1;
					bookingno = maxId;
					fnb.setBookingno(bookingno);
					System.out.println("Booking no = " + bookingno);
				}
			}
			System.out.println(maxId + " " + memberid);
			// query for inserting into the table

			String query = "insert into fnb(bookingno,fnborder,quantity,venue,price,memberid) values(?,?,?,?,?,?)";
			PreparedStatement pstmt = currentCon.prepareStatement(query);
			// inserting values
			pstmt.setInt(1, fnb.getBookingno());
			pstmt.setString(2, fnb.getFnborder());
			pstmt.setInt(3, fnb.getQuantity());
			pstmt.setString(4, fnb.getVenue());
			pstmt.setDouble(5, fnb.getPrice());
			pstmt.setString(6, m.getMemberid());
			pstmt.executeUpdate();
		}

		catch (Exception ex) {

			System.out.println("Booking failed: An Exception has occurred! "+ ex);
		}

		// exception handling
		finally {

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
		return fnb;

	}

	public static ArrayList<FnB> searchFnbOrder(String phrase) {
		// declare local variables
		ArrayList<FnB> fnbList = new ArrayList<FnB>();
		ResultSet rs = null;
		DBController db = new DBController();
		String dbQuery;

		// Step 1 connect to database
		db.getConnection();

		// The symbol % is used as the wildcard.
		if (phrase == null || phrase == "")
			dbQuery = "SELECT * FROM FNB;";
		else
			dbQuery = "SELECT * FROM FNB WHERE MEMBERID LIKE '%" + phrase + "%'";

		// step 2 of using DBController, use updateRequest method
		rs = db.readRequest(dbQuery);
		try {
			while (rs.next()) {
				int bookingno = rs.getInt("BOOKINGNO");
				String fnborder = rs.getString("FNBORDER");
				int quantity = rs.getInt("QUANTITY");
				String venue = rs.getString("VENUE");
				double price = rs.getDouble("PRICE");
				FnB fnb = new FnB(bookingno, fnborder, quantity, venue, price);
				fnbList.add(fnb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// step 3 of using dbcontroller
		db.terminate();
		return fnbList;
	}

	public boolean deleteOrder() throws SQLException {
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;
		db.getConnection();

		dbQuery = "DELETE FROM FnB where bookingno = '" + bookingno + "';";

		if (db.updateRequest(dbQuery) == 1) {
			success = true;
		}

		db.terminate();
		return success;
	}
}
