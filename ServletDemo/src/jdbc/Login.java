package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final static String DB_URL = "jdbc:mysql://localhost:3306/testdb";
	private final static String DB_username = "root";
	private final static String DB_password = "Mohan2636$";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// redirect to register if method is get
		response.sendRedirect("login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String em = request.getParameter("Email");
		String p =request.getParameter("Password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URL,DB_username, DB_password);
			 String sql = "select * from user_register where Email='" + em + "'";
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 String Email = null;
			 String Password = null;
			 String name =null;
			 response.setContentType("text/html");
			 PrintWriter out = response.getWriter();
			 while(rs.next()) 
			 {
				 Email =rs.getString(3);
				 Password = rs.getString(2);
				 name = rs.getString(1);
			 }

			 if(em.equals(Email)&&p.equals(Password)) {
				 out.print("Welcome " + name);
				 }
			 else {
				 out.println("Email id or password is incorrect");
				 out.println("Or Account doesn't exist, Please try again");
				 RequestDispatcher rd = request.getRequestDispatcher("/login.html");
				 rd.include(request, response);
			 }
			 
			
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
