package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.TutorBean;
import com.mvc.util.DBConnection;

public class TutorDao {
	int i=0;
	Connection con = DBConnection.createConnection();
	
	public String inTud(TutorBean tb) {
		String sql = "insert into tutor_table values(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, tb.getUserid());
			ps.setString(2, tb.getTutor_username());
			ps.setFloat(3, tb.getRating());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i!=0) return "Tutor registration success";
		else return "Tutor registration failed";
	}
	
	public int TuidFTnm(String tutorUsername) {
		int tid=0;
		String sql ="select userid from tutor_table where tutor_username=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tutorUsername);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				tid = rs.getInt("userid");				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(tid);
		return tid;
	}

		
}
