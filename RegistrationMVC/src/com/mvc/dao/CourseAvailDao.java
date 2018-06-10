package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mvc.util.DBConnection;

public class CourseAvailDao {
	
	public ArrayList<Integer> CourseIDFromTuID(int tUiD) {
		ArrayList<Integer> list = new ArrayList<>();
		Connection con = DBConnection.createConnection();
		String sql = "Select course_id from course_availability where tutor_id='"+tUiD+"'";
		PreparedStatement ps;
		int id=0;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("course_id");
				list.add(id);
			}
			System.out.println("Course Id should come");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
 
	}

	public ArrayList<Integer> StudentIDFromTuID(int tid){
		ArrayList<Integer> list = new ArrayList<>();
		Connection con = DBConnection.createConnection();
		String sql = "Select student_id from course_availability where tutor_id= ?";
		
		//course_availability_id, course_id, tutor_id, student_id, price, timings, status
		PreparedStatement ps;
		int stid =0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				stid = rs.getInt("student_id");
				list.add(stid);
			}
		System.out.println("Student ID should come");	
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> StatusFromTuID(int tid){
		ArrayList<String> list = new ArrayList<>();
		Connection con = DBConnection.createConnection();
		String sql = "Select status from course_availability where tutor_id= ?";
		String status;
		//course_availability_id, course_id, tutor_id, student_id, price, timings, status
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				status = rs.getString("status");
				list.add(status);
			}
		System.out.println("Status should come");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public String inCorAvailTable(String courseName,String tName,int price, String time,String status) {
		Connection con = DBConnection.createConnection();
		int i=0;
		int cid = 0;
		int tid=0;
		
		
		String getTid = "Select * from tutor_table where tutor_username=?";
		String getCid = "Select * from course_table where course_name=?";
		
		String insert = "insert into course_availability(course_id,tutor_id,price,timings,status) values(?,?,?,?,?)";
		
		PreparedStatement ps;
		PreparedStatement ttd;
		PreparedStatement in;
		try {
			ps = con.prepareStatement(getCid);
			ps.setString(1, courseName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cid = rs.getInt("course_id");
				}
			
			if(cid!=0) {
				ttd= con.prepareStatement(getTid);
				ttd.setString(1, tName);
				ResultSet rs1 = ttd.executeQuery();
				while(rs1.next()) {
					tid=rs1.getInt("tutor_username");				
				}
								
				if(tid!=0) {
					in = con.prepareStatement(insert);
					in.setInt(1, cid);
					in.setInt(2, tid);
					in.setInt(3, price);
					in.setString(4, time);
					in.setString(5, status);
					i=in.executeUpdate();
					
				}else {
					return "Searching tutorid failed";
				}
				
				
			}else {
				return "Searching course Id failed";
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i!=0) {
			return "Success";
		}
		else {
			return "Fail";
			
		}
	}
}
