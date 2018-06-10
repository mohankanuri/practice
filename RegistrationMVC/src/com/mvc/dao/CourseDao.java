package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.CourseBean;
import com.mvc.util.DBConnection;

public class CourseDao {
	
	public String cNFcId(CourseBean cb) { //Course Name from Course Id
		int cId = cb.getCourseId();
		String cNm=null;
		Connection con = DBConnection.createConnection();
		
		String sql = "Select course_name from course_table where course_id='"+cId+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cNm = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cNm;
	}
	
	public int cIdFcN(CourseBean cb) {
		String cNm = cb.getCourseName();
		int cId=0;
		Connection con = DBConnection.createConnection();
		//course_id, course_name course_table
		String sql = "Select course_id from course_table where course_name=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cNm);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cId = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cId;
	}

}
