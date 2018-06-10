package com.mohan.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnection {
	private Connection con = null;
	
	public DatabaseConnection() {con = this.initConnection();}
	public Connection getConnection() {return this.con;}

	public void createTable() 
	{
		java.sql.Statement stmt = null;
		try {
			Connection con = this.getConnection();stmt = con.createStatement();
			String sql = "CREATE TABLE REGISTRATION ";stmt.executeUpdate(sql);
			} 
		catch (Exception e) {System.out.println(e);} 
		
		finally {System.out.println("Function has been completed");}
	}
	
	// Method to add fields of users
	
	public String AddRegistration(String email, String first_name, String last_name, String password)  
	{
		PreparedStatement preparedStatement = null;
		try {
		String insertTableSQL = "INSERT INTO REGISTRATION"
				+ "(Email, FirstName, LastName, Password) VALUES"
				+ "(?,?,?,?)";
		
		preparedStatement = this.getConnection().prepareStatement(insertTableSQL);

		preparedStatement.setString(1, email);
		preparedStatement.setString(2, first_name);
		preparedStatement.setString(3, last_name);
		preparedStatement.setString(4, password);

		// execute insert SQL stetement
		preparedStatement.executeQuery();
		

		System.out.println("Record is inserted into Registration table!");
		} catch(Exception e) {
			
		}
		
		return null;
	} 
	
	public Connection initConnection() {

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
	
	public static void main(String []args){
		DatabaseConnection connection = new DatabaseConnection();	
		System.out.println(connection.getConnection());
	}
}
