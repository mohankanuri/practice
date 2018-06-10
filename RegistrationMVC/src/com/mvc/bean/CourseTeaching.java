package com.mvc.bean;

import java.util.ArrayList;

public class CourseTeaching {
	private ArrayList<Integer> cid;
	private ArrayList<Integer> stid;
	private ArrayList<String> status;
	
	public ArrayList<Integer> getCid() {
		return cid;
	}
	public ArrayList<Integer> setCid(ArrayList<Integer> cid) {
		return this.cid = cid;
	}
	public ArrayList<Integer> getStid() {
		return stid;
	}
	public void setStid(ArrayList<Integer> stid) {
		this.stid = stid;
	}
	public ArrayList<String> getStatus() {
		return status;
	}
	public void setStatus(ArrayList<String> status) {
		this.status = status;
	}
	
	
}
