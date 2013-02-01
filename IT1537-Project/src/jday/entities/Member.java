package jday.entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jday.entities.dao.DBController;



public class Member{
	private int count = 0;
	private String memberid;
	private String pin;
	private String membertype;
	private String name;
	private String birthdate;
	private int contactnoH;
	private int contactnoM;
	private String email;
	private String address;



	public int getCount() {
		DBController db = new DBController();
		Connection con = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
			
		try{
			stmt = con.createStatement();
			String query = "select * from user_aes where user_name = '"+memberid+"';";
			rs = stmt.executeQuery(query);
			while(rs.next())
				count = rs.getInt(4);
			
		}catch(Exception e){
				e.printStackTrace();
			}
			
			db.terminate();
			return count;
		}
	

	public void setCount() {
		count += 1;
		DBController db = new DBController();
		Connection con = db.getConnection();
		Statement stmt = null;
		
		try{
			stmt = con.createStatement();
			String query = "update user_aes set count ='"+count+"' where user_name ='"+memberid+"';";
			System.out.println(query);
			stmt.execute(query);
		}catch(Exception e){
			e.printStackTrace();
		}
		db.terminate();
	}

	public Member() {
		super();
	}
	
	public Member(String memberid){
		
		this.memberid = memberid;
	}


	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public int getContactnoH() {
		return contactnoH;
	}

	public void setContactnoH(int contactnoH) {
		this.contactnoH = contactnoH;
	}

	public int getContactnoM() {
		return contactnoM;
	}

	public void setContactnoM(int contactnoM) {
		this.contactnoM = contactnoM;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public void setMembertype(String membertype){
		this.membertype = membertype;
	}
	
	public String getMembertype() throws SQLException{
		DBController db = new DBController();
		db.getConnection();
		String dbQuery = "select membertype from user_aes where user_name ='"+memberid+"';";
		ResultSet rs = db.readRequest(dbQuery);
		while(rs.next()){
			membertype = rs.getString(1);
		}
		return membertype;
	}

	
	public boolean createMember() throws SQLException{
		//why 'boolean success = false;'
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;	
		db.getConnection();		

		dbQuery = "INSERT INTO user_aes";
	    dbQuery = dbQuery + " VALUES ('" + memberid + "',aes_encrypt('"+pin+"','keytoencrypt')"+",'"+membertype+"'"+",'"+count+"');";
	    System.out.println(dbQuery);


	    if (db.updateRequest(dbQuery) == 1){
	        success = true;
	    }
		db.terminate();
		return success;
	}
	
	public boolean changePin(String pin) throws SQLException {
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;	
		db.getConnection();	

		dbQuery = "UPDATE USER_AES SET pin = AES_ENCRYPT('" + pin+"','keytoencrypt') "; 
		dbQuery = dbQuery + " WHERE user_name = '" + memberid+"';"; 

		if (db.updateRequest(dbQuery) == 1){
		        success = true;
		        
		      
		} 
		db.terminate();
		return success;
	}
	
	public boolean deleteMember() throws SQLException{
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;	
		db.getConnection();

		dbQuery = "DELETE FROM USER_AES WHERE USER_NAME = '" + memberid +"';";

		if (db.updateRequest(dbQuery) == 1){
			success = true;
		}

		db.terminate();
		return success;
	}
	
	public boolean retrieveMember(){
		boolean success = false;
		ResultSet rs = null;
		DBController db = new DBController();
		
		db.getConnection();

		String sql = "select * from user_aes where user_name= '"+memberid +"' and pin = aes_encrypt('"+pin+"','keytoencrypt');";
	
	
		rs = db.readRequest(sql);


		try{
			while(rs.next()){
				String username= rs.getString("user_name");
				
				//sql = "select aes_decrypt(pin,'keytoencrypt') as unencrypted from user_aes;";
				
				if(memberid.equalsIgnoreCase(username) && this.pin.equals(pin)){
				success= true;
				return success;
				}
				
				else 
					success = false;
				
				System.out.println(success);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		db.terminate();
		return success;
	}
	
	
	public boolean createMemberInfo() throws SQLException{
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;	
		db.getConnection();		

		dbQuery = "INSERT INTO memberinfo";
	    dbQuery = dbQuery + " VALUES ('" + memberid + "','" + name + "','" + birthdate + "','" + contactnoH + "','" + contactnoM + "','" + email + "','" + address + "');";


	    if (db.updateRequest(dbQuery) == 1){
	        success = true;
	    }
		db.terminate();
		return success;
	}
	
	public boolean retrieveMemberInfo(){
		boolean success = false;
		ResultSet rs = null;
		DBController db = new DBController();
		
		db.getConnection();

		String sql = "select * from memberinfo where memberid = '"+memberid +"'";

	
		rs = db.readRequest(sql);


		try{
			while(rs.next()){
				memberid= rs.getString("memberid");
				name = rs.getString("name");
				birthdate = rs.getString("birthdate");
				contactnoH = rs.getInt("contactnoH");
				contactnoM = rs.getInt("contactnoM");
				email = rs.getString("email");
				address = rs.getString("address");


			}
		}catch(Exception e){
			e.printStackTrace();
		}
		db.terminate();
		return success;
	}
	
	public boolean updateMemberInfo() throws SQLException {
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;	
		db.getConnection();	

		dbQuery = "UPDATE MEMBERINFO SET Name = '" + name; 
		dbQuery = dbQuery + "', Birthdate = '" + birthdate + "',contactnoH ='"+contactnoH+
				"',contactnoM ='"+contactnoM+"',email ='"+email+"', address = '" + address+
		"' WHERE memberid = '" + memberid+"';";
		System.out.println(dbQuery);
		if (db.updateRequest(dbQuery) == 1){
		        success = true;
		} 
		db.terminate();
		return success;
	}
	
	public boolean deleteMemberInfo() throws SQLException{
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;	
		db.getConnection();

		dbQuery = "DELETE FROM MEMBERINFO WHERE MEMBERID = '" + memberid +"';";

		if (db.updateRequest(dbQuery) == 1){
			success = true;
		}

		db.terminate();
		return success;
	}
}
