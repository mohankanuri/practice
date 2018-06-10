<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("username");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "record";
String userId = "root";
String password = "Mohan2636$";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h1 align="center"><font><strong>Hi <%=request.getAttribute("userName") %></strong></font></h1>
<h2 align="center"><font><strong>Displaying Courses available</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor=#cccccc>

<td><b>Course id</b></td>
<td><b>Course Name</b></td>
<td><b>Select</b></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM course";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#ffffff">
<td><%=resultSet.getString("courseid") %></td>
<td><%=resultSet.getString("coursename") %></td>
<td><input TYPE=checkbox name=select/></td>
</tr>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>


