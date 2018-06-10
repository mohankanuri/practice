package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		createTable();

	}

	public static void createTable() throws Exception {
		java.sql.Statement stmt = null;
		try {
			Connection con = getConnection();
			stmt = con.createStatement();
		      
		      String sql = "CREATE TABLE REGISTRATION " +
		                   "(id INTEGER not NULL, " +
		                   " first VARCHAR(255), " + 
		                   " last VARCHAR(255), " + 
		                   " age INTEGER, " + 
		                   " PRIMARY KEY ( id ))"; 

		      stmt.executeUpdate(sql);			
			
			} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Function has been completed");
		}
		;
	}

	public static Connection getConnection() throws Exception {

		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/testdb";
			String username = "root";
			String password = "Mohan2636$";
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return con;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

}
