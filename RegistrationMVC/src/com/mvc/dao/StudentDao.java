package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.util.DBConnection;

public class StudentDao {
	int i=0;
	DBConnection obj = new DBConnection();
	Connection con = DBConnection.createConnection();
	public String SName(int stid) {
		String sql = "select student_username from student_table where userid = ?";
		String sName=null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, stid);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				sName = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sName!=null) {
			return sName;
		}
		else {
			return "None";
		}
	}
	
	}
