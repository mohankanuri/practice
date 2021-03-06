<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css"></style>
</head>
<body style="font-family: Comic Sans Ms; background: url(./bgImg.jpg);">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<script>
	function validate() {
		var username = document.form.username.value;
		var password = document.form.password.value;
		var email = document.form.email.value;
		var role = document.form.role.value;
		var gender = document.form.gender.value;
		var dateofbirth = document.form.dateofbirth.value;
		
		if (username == null || username == "") {
			alert("Username can't be blank");
			return false;
		} else if (password == null || password == "") {
			alert("password can't be blank");
			return false;
		} else if (email == null || email == "") {
			alert("Email can't be blank");
			return false;
		} else if (password.length < 6) {
			alert("Password must be at least 6 characters long.");
			return false;
		} else if (role == null || role == "") {
			alert("Role can't be blank");
			return false;
		}
		else if (gender == null || gender == "") {
			alert("gender can't be blank");
			return false;
		}
		else if (dateOfBirth == null || dateOfBirth == "") {
			alert("Date of birth is required");
			return false;
		}
	}
</script>

</head>
<body>
	<center>
		<h2>Learn for Life</h2>
	</center>
	<form name="form" action="RegisterServlet" method="post"
		onsubmit="return validate()">
		<table align="center">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Role &emsp;</td>
				<td><select name="role">
						<option>Student</option>
						<option>Tutor</option>

				</select></td>
			<tr>
				<td>Gender &emsp;</td>
				<td><input type="radio" name="gender" value="male" checked>
					Male <br> <input type="radio" name="gender" value="female">
					Female <br> <input type="radio" name="gender" value="other">
					Other</td>
			<tr>
				<td>Date of birth</td>
				<td><input name="dateOfBirth" type="date" /></td>
			</tr>
			<tr>
				<td><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></input><input
					type="reset" value="Reset"></input></td>
			</tr>
		</table>

	</form>
</body>
</html>
