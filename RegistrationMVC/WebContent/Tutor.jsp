<%@page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import = "com.mvc.bean.CourseTeaching" %>
<%@ page import = "javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
    font-family: Lucida Console;
   
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: center;
    padding: 12px;
}

tr:nth-child(even) {
    background-color: cyan ;
}
th {
    text-align: center;
}

</style>
</head>
<script>
	function validate() {
		var timings = document.form.timings.value;
				
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date strDate = sdf.parse(timings);
		
		LocalDateTime now = LocalDateTime.now();
		Date date1 = sdf.parse("now");
		
		if(date1.compareTo(timings)>0){
			alert("You can't select the past date");
			return false;
		}
		
	}
</script>
<body>
	<body style="font-family: Comic Sans Ms; background: url('85.jpg') no-repeat center center fixed; 
-webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;">
	<form name="form" action="TutorServlet" method="post"
		onsubmit="return validate()">
		<table align="center">
			<%String name = (String)request.getAttribute("user"); %>
			<%if(name=="" || name==null){name = (String)request.getAttribute("user1");}%>
			<h1 align="center">Welcome <%out.print(name);%></h1>
			
			<%String name1=(String)request.getAttribute("user");%>
			<% request.setAttribute("user", name1);%>
			<h3>These are the courses you are teaching</h3>
			</table>
			
			<table>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<tr>
				<th>Course Name</th>
				<th>Student Name</th>
				<th>Status</th>
				</tr>
				
				<tr>
				<td><c:forEach var="CourseName" items="${CourseName}">
				<c:out value="${CourseName}" /><br/>
				</c:forEach></td>
				
				
				
				<td><c:forEach var="StudentName" items="${StudentName}">
        			<font color="#00CC00">${StudentName}<br></font>
   				</c:forEach></td>
   				
   				
   				
   				<td><c:forEach var="status" items="${status}">
        			<font color="#00CC00">${status}<br></font>
   				</c:forEach></td>
   				</tr>
			</table>
				
			<tr>
			</form>
			
			<form name="Tutorcourse" action="TutorCourseServlet" method="post" onsubmit="return validate()">
				<%String TutorName=(String)request.getAttribute("TutorName");%>
				<% request.setAttribute("TutorName", TutorName);%>
			
		
				<h2><td>Select Course you want to teach &emsp;</td></h2>
				<td><select name="course">
						<option>DSP</option>
						<option>JSP</option>
						<option>Java</option>
						<option>Spring</option>
						<option>Hibernate</option>
						<option>EJB</option>
						<option>J2EE</option>
						<option>Studs</option>
						<option>Multithreading</option>
						<option>Inheritance</option>
						<option>AWS</option>
						<option>Kubernetes</option>
						<option>Netflix Eureka</option>
						<option>Big data</option>
						<option>Hadoop</option>
						<option>HTML</option>
						<option>XML</option>
						<option>SOAP UI</option>
						<option>Restful API</option>
						<option>JavaScript</option>
						<option>Devops</option>
					</select></td>
			<tr>
				<td>Select Price for the course &emsp;</td>
				<td><select name="price">
						<option>50</option>
						<option>100</option>
						<option>150</option>
					</select></td>
			<tr>
				<td>Select Timings for the course</td>
				<td><input name="timings" type="datetime-local" /></td>
			</tr>
			<tr>
				<td><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register Course"></input><input
					type="reset" value="Reset"></input></td>
			</tr>
			
		</table>
	</form>
	
	</body>
</html>
