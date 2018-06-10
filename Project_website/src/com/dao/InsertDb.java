package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.RegisterBean;

public class InsertDb {
	public String insertDB(RegisterBean rb) throws ClassNotFoundException, SQLException, Exception {
		RegisterBean ben = new RegisterBean();
		String username = ben.getUsername();
		String password = ben.getPassword();
		String email = ben.getEmail();
		String role = ben.getRole();
		String gender = ben.getGender();
		String dob = ben.getDob();
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "Mohan2636$");
			String query = "insert into user_register(username, password, email, role, gender, dob) values (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, role);
			ps.setString(5, gender);
			ps.setString(6, dob);
		}catch(Exception ClassNotFoundException) {
			System.out.println("Driver not initialized");
		}
		
		
		/*
		
		
		preparedStatement.setString(1, fullName);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, userName);
		preparedStatement.setString(4, password);
		preparedStatement.setString(5, role);
		preparedStatement.setString(6, gender);
		int i= preparedStatement.executeUpdate();
		if (i!=0)  //Just to ensure data has been inserted into the database
		return "SUCCESS"; 
*/
		
		
		return null;
	}

}
