package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.CourseBean;
import com.mvc.dao.CourseAvailDao;
import com.mvc.dao.CourseDao;
import com.mvc.dao.StudentDao;
import com.mvc.dao.TutorDao;
import com.mvc.dao.UserDao;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("Username");
		String pwd = request.getParameter("Password");
		
		UserDao obj= new UserDao();
		String validate = obj.validateUser(user, pwd);
		
		if(validate.equalsIgnoreCase("Student")) {
								
			// Get courses enrolled by student with student id
			request.getRequestDispatcher("/Student.jsp").forward(request, response);			
		}
		
		else if(validate.equalsIgnoreCase("Tutor")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
									
			//Getting tutor ID from TutorDao
			TutorDao tdao = new TutorDao();
			int tid = tdao.TuidFTnm(user);
			
			// Getting courses taught by tutor with tutor id
			
						
			CourseAvailDao courseTaught =  new CourseAvailDao();
			
			ArrayList<Integer> cid = courseTaught.CourseIDFromTuID(tid);
			ArrayList<Integer> stid = courseTaught.StudentIDFromTuID(tid);
			ArrayList<String> status = courseTaught.StatusFromTuID(tid);
			
			ArrayList<String> cName = new ArrayList<>();
			ArrayList<String> sName = new ArrayList<>();
			
			CourseBean cb = new CourseBean();
			CourseDao cdao = new CourseDao();
			for(int i=0;i<cid.size();i++) {
				int id=cid.get(i);
				cb.setCourseId(id);
				String courseName =  cdao.cNFcId(cb);
				cName.add(courseName);
			}
			StudentDao sdao = new StudentDao();
			for(int i=0;i<stid.size();i++) {
				int sid =stid.get(i);
				String studentName = sdao.SName(sid);
				sName.add(studentName);
			}
						
			session.setAttribute("CourseName", cName);
			session.setAttribute("StudentName", sName);
			session.setAttribute("status", status);
			request.getRequestDispatcher("/Tutor.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errMessage", validate);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
		
	}

}
