<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css"></style>
</head>
<body style="font-family: Comic Sans Ms; background: url(./bgImg.jpg);">
<head>
<title>Home Page after logging in</title>
</head>
<body>
	<center>
		<h2>Home Page after logging in</h2>
	</center>
	Welcome, You have Successfully Logged in!
	<br> Start browsing,
	<%=request.getAttribute("userName")%>
	<!-- Refer to the video to understand how this works -->
	<div style="text-align: right">
		<a href="LogoutServlet">Logout</a>
	</div>
	
	<b>Please <a href ="Student.jsp">click here </a> to view available courses </b>
	
	
</body>
</html>