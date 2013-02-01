package jday.entities.dao;

//To connect to a database you need a Connection object. 
//The Connection object uses a DriverManager. 
//The DriverManager passes in your database username, 
//your password, and the location of the database

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	static Connection con;
    static String url;
    public static Connection getConnection() {
     
        try {
            String url = "jdbc:mysql://localhost:3306/jdaydatabase";
            // assuming "DataSource" is your DataSource name

            Class.forName("com.mysql.jdbc.Driver");
            
            //to handle exception and run-time error
            try {
            	//To set up a connection to a database
                con = DriverManager.getConnection(url, "myuser", "jday");
            }

            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        catch (ClassNotFoundException e) {// "logger" prints in to a file;
           
            System.out.println(e);
        }

        return con;
    }
}
