package numbers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class assign1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/mydb"; //MySQL URL followed by the database name
		String username = "root"; //MySQL username
		String password = "Mohan2636$"; //MySQL password

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);		

		// run the query and populate the list
		String sql = "SELECT * FROM course_table";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			for(;rs.next();) {
				int id = rs.getInt("course_id");
				String cnm = rs.getString("course_name");
				System.out.print(id);
				System.out.print("  "+cnm);
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
