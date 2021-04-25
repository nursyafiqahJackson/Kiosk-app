package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * This class to connect the data with the client
 * 
 * @author nursyafiqah jackson
 *
 */
public class DbConnect {
	
	private String databaseName = "kioskappdb_dev_editied";
	private String username = "root";
	private String password = "abc123";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException 
    {
		// Load the database content 
		
    	Class.forName("com.mysql.cj.jdbc.Driver");
		

		Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/kioskappdb_dev_edited?useTimezone=true&serverTimezone=UTC", 
				username, password);
		
		// Db connection made 
		return connection;
  
    }
	

}
