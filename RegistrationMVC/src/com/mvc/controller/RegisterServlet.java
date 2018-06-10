package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.UserBean;
import com.mvc.dao.UserDao;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String unm = request.getParameter("username");
		String pwd = request.getParameter("password");
		String em = request.getParameter("email");
		String rl = request.getParameter("role");
		String gdr = request.getParameter("gender");
		String dob = request.getParameter("dateOfBirth");

		// Copying data to user bean
		UserBean ub = new UserBean();
		ub.setUsername(unm);
		ub.setPassword(pwd);
		ub.setEmail(em);
		ub.setRole(rl);
		ub.setGender(gdr);
		ub.setDob(dob);

		// Copying data to userDao
		UserDao obj = new UserDao();
		String userReg = obj.inUser(ub);
		
		if(userReg.equals("User Registartion Successfull")) {
			String childClass = obj.lastRowid(ub);
			if(childClass.equals("Success")){
				request.getRequestDispatcher("/Home.jsp").forward(request, response);
			}else {
				request.setAttribute("errMessage", childClass);
				request.getRequestDispatcher("/Register.jsp").forward(request, response);
			}			
		}else {
			request.setAttribute("errMessage", userReg);
			request.getRequestDispatcher("/Register.jsp").forward(request, response);;		
		}

		
		
	}

}
