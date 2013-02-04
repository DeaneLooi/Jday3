/*******************************************************************************
 * Program Name: 			MemberDAO
 * Purpose:					register member, search member by name ,retrieve member
 * Name of Author:			Di Yuwen
 * Admin No. of Author:		120923r
 * Module Group: 			IS1201
 * *****************************************************************************/
package jday.entities.dao;

import jday.entities.dao.DBConnectionManager;
import jday.entities.CourseBooking;
import jday.entities.Member;
import jday.util.ClassTableModel;
import jday.util.ProfileTableModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MemberDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;

	   public static Member register(Member member) {
		   
		   Statement stmt = null;
			
			// get the last member ID 
			try {
				
				currentCon = DBConnectionManager.getConnection();
				stmt = currentCon.createStatement();
				
	            // query for inserting into the table
	            String query = "insert into Memberinfo(memberid, name, birthdate,contactnoH,contactnoM,email,address) values(?,?,?,?,?,?,?)";
	            pstmt = currentCon.prepareStatement(query);
	            // inserting values
	            pstmt.setString(1,member.getMemberid());
	            pstmt.setString(2,member.getName());
	            pstmt.setString(3, member.getBirthdate());  
	            pstmt.setInt(4,member.getContactnoH());
	            pstmt.setInt(5,member.getContactnoM());
	            pstmt.setString(6, member.getEmail());
	            pstmt.setString(7 ,member.getAddress());
	            pstmt.executeUpdate();
	            
			} catch (Exception ex) {

				System.out.println("Registration failed: An Exception has occurred! "
						+ ex);
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
			return member;

		}
	   
	   public static ArrayList<Member> searchByName(String name) {
			ArrayList<Member> mlist = new ArrayList<Member>();
			Member member = null;
			Statement stmt = null;
	        String searchQuery = "select * from memberinfo where name ='"
	                + name + "' ";

	        try {
	            // connect to DB
	            currentCon = DBConnectionManager.getConnection();
	            stmt = currentCon.createStatement();
	            rs = stmt.executeQuery(searchQuery);
	            boolean more = rs.next();

	            // if user does not exist set the isValid variable to false
	            if (!more) {
	              System.out.println("member with the name = " + name + " does not exst");
	            }

	            // if user exists set the isValid variable to true
	            else if (more) {
	            	 String memberId = rs.getString("memberid");
	                 String memberName = rs.getString("name");
	                 String memberBirthdate = rs.getString("birthdate");
	                 int memberContactnoH = rs.getInt("contactnoH");
	                 int memberContactnoM = rs.getInt("contactnoM");
	                 String memberEmail = rs.getString("email");
	                 String memberAddress = rs.getString("address");
	                 
	                 member = new Member();
	                 member.setMemberid(memberId);
	                 member.setName(memberName);
	                 member.setBirthdate(memberBirthdate);
	                 member.setContactnoH(memberContactnoH);
	                 member.setContactnoM(memberContactnoM);
	                 member.setEmail(memberEmail);
	                 member.setAddress(memberAddress);
	                 mlist.add(member);
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }

			return  
					mlist;
	        
		}
	   
	   public static ArrayList<Member> retrieveAll() {
			Member member = null;
			Statement stmt = null;
	        String searchQuery = "select * from memberinfo";
	        ArrayList<Member> memberList = new ArrayList<Member>();
	        try {
	            // connect to DB
	            currentCon = DBConnectionManager.getConnection();
	            stmt = currentCon.createStatement();
	            rs = stmt.executeQuery(searchQuery);
	            while (rs.next()) {
	            
	            	String memberId = rs.getString("memberid");
	                 String memberName = rs.getString("name");
	                 String memberBirthdate = rs.getString("birthdate");
	                 int memberContactnoH = rs.getInt("contactnoH");
	                 int memberContactnoM = rs.getInt("contactnoM");
	                 String memberEmail = rs.getString("email");
	                 String memberAddress = rs.getString("address");
	                 
	                 member = new Member();
	                 member.setMemberid(memberId);
	                 member.setName(memberName);
	                 member.setBirthdate(memberBirthdate);
	                 member.setContactnoH(memberContactnoH);
	                 member.setContactnoM(memberContactnoM);
	                 member.setEmail(memberEmail);
	                 member.setAddress(memberAddress);
	                 memberList.add(member);
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }

			return  memberList;
		}
	   
	   }

