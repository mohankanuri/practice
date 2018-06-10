package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.CourseAvailBean;
import com.mvc.bean.CourseBean;
import com.mvc.bean.TutorBean;
import com.mvc.dao.CourseAvailDao;
import com.mvc.dao.CourseDao;
import com.mvc.dao.TutorDao;


public class TutorCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TutorCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("TutorName");
		if(user==""||user==null) {
			user = (String) session.getAttribute("user");
			}
		String userName = user;
		
		//Setting tutor name to tutor bean
		TutorBean tb = new TutorBean();
		tb.setTutor_username(user);
		
		//Getting tutor id from tutor Dao
		TutorDao tdao = new TutorDao();
		int tid = tdao.TuidFTnm(user);
		
		//Getting values from jsp
		String courseName = request.getParameter("course");
		int cost = Integer.parseInt(request.getParameter("price"));
		String timings = request.getParameter("timings");
		String status = "open";
		
		//Setting course name to course bean
		CourseBean obj = new CourseBean();
		obj.setCourseName(courseName);
		
		//Getting course id from course Dao
		CourseDao obj1= new CourseDao();
		int courseId = obj1.cIdFcN(obj);
		
		//Setting values to CourseAvailBean
		CourseAvailBean cab = new CourseAvailBean();
		cab.setCourse_id(courseId);
		cab.setTutor_id(tid);
		cab.setPrice(cost);
		cab.setTimings(timings);
		cab.setStatus(status);
						
		//Calling tutorDao to insert
		CourseAvailDao CAD = new CourseAvailDao(); 
		String dec = CAD.inCorAvailTable(courseName, user, cost, timings, status);
		
		if(dec.equalsIgnoreCase("Success"))
			{
				HttpSession session1 = request.getSession();
				session.setAttribute("user1", userName);
				request.setAttribute("errMessage", dec);
				request.getRequestDispatcher("/Tutor.jsp").forward(request, response);
		     }else
		     	{
		    	 	HttpSession session1 = request.getSession();
					session.setAttribute("user1", userName);
					request.setAttribute("errMessage", dec);
					request.getRequestDispatcher("/Tutor.jsp").forward(request, response);
				}				
			}

}
