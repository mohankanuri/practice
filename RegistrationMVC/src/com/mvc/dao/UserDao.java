package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.UserBean;
import com.mvc.util.DBConnection;


public class UserDao {
	int i=0;
	DBConnection obj = new DBConnection();
	Connection con = DBConnection.createConnection();
	
	public String inUser(UserBean ub) {
		String sql = "insert into user_table values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ub.getId());
			ps.setString(2, ub.getUsername());
			ps.setString(3, ub.getPassword());
			ps.setString(4, ub.getEmail());
			ps.setString(5, ub.getRole());
			ps.setString(6, ub.getGender());
			ps.setString(7, ub.getDob());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i!=0) return "User Registartion Successfull";
		else return "Registration failed";
	}
		
	public int idFun(UserBean ub) {
		int id=0;
		String un = ub.getUsername();
		String sql ="select id from user_table where username = "+un;
		try {
			PreparedStatement ps1 = con.prepareStatement(sql);
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				id= rs.getInt("id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public String lastRowid(UserBean ub) {
		int id=0,i=0;
		String uname =null;
		String role =null;
		float gpa=0,rating=0;
		String skills=null;
		String sear = "SELECT * FROM user_table WHERE id = (SELECT MAX(id) FROM user_table)";
		String inStud = "insert into student_table values(?,?,?,?)";
		String inTut = "insert into tutor_table values(?,?,?)";
		 try {
			PreparedStatement ps = con.prepareStatement(sear);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				role = rs.getString("role");
				
				if(role.equals("Student")) {id = rs.getInt("id");uname = rs.getString("username");
				ps = con.prepareStatement(inStud); ps.setInt(1, id); ps.setString(2, uname); ps.setFloat(3, gpa);
				ps.setString(4, skills); i=ps.executeUpdate();}
				
				else if(role.equals("Tutor")) {id=rs.getInt("id");uname =rs.getString("username");
				ps = con.prepareStatement(inTut); ps.setInt(1, id); ps.setString(2, uname);ps.setFloat(3, rating);
				i=ps.executeUpdate();}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i!=0)return "Success";
		else return "Failed";
	}
	
	public String validateUser(String un,String pwd) {
		String dbUn=null;
		String dbPwd=null;
		String rol = null;
		Connection con = DBConnection.createConnection();
		String sql = "Select * from user_table where username=" + "'" + un + "'";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dbUn = rs.getString("username");
				dbPwd = rs.getString("password");
				rol =rs.getString("role");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dbUn.equals(un)&&dbPwd.equals(pwd)) {return rol;} 
		else {return "User doesn't exist";}
	}
	
}