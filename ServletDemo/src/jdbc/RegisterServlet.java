package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final static String DB_URL = "jdbc:mysql://localhost:3306/testdb";
	private final static String DB_username = "root";
	private final static String DB_password = "Mohan2636$";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// redirect to register if method is get
		response.sendRedirect("register.html");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String n = request.getParameter("Name");
			String p = request.getParameter("Password");
			String em = request.getParameter("Email");
			String r = request.getParameter("Role");

			String sql = "insert into user_register(Name,Password,Email,Role) values(?,?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URL, DB_username, DB_password);

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			boolean error = false;
			if (n.isEmpty() || p.isEmpty() || em.isEmpty() || r.isEmpty()) {
				error = true;
				out.print("All fields are required");
				RequestDispatcher rd = request.getRequestDispatcher("/register.html");
				rd.include(request, response);
			} else {
				String search = "select * from user_register where Email='" + em + "'";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(search);
				String Email = null;
				while (rs.next()) {
					Email = rs.getString(3);
				}
				if (Email != null) {
					error = true;
					out.print("This email has already been registered, try to login here");
					RequestDispatcher rd = request.getRequestDispatcher("/login.html");
					rd.include(request, response);
				} else {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, n);
					ps.setString(2, p);
					ps.setString(3, em);
					ps.setString(4, r);
					ps.executeUpdate();
				}
			}

			if (!error) {
				out.print("Successfully registered, you can login now");
				RequestDispatcher rd = request.getRequestDispatcher("/login.html");
				rd.include(request, response);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
