package com.mvc.bean;

public class CourseAvailBean {
	private int course_availability_id;
	private int course_id;
	private int tutor_id;
	private int student_id;
	private int price;
	private String timings;
	private String status;
	public int getCourse_availability_id() {
		return course_availability_id;
	}
	public void setCourse_availability_id(int course_availability_id) {
		this.course_availability_id = course_availability_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getTutor_id() {
		return tutor_id;
	}
	public void setTutor_id(int tutor_id) {
		this.tutor_id = tutor_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
