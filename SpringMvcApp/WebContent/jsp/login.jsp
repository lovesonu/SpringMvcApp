<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>
<!-- <link rel="stylesheet" type="css/javascript" href=${pageContext.request.contextPath}/css/style1.css" > -->
</head>

<style type="text/css">
<%@include file="/resources/css/style.css"%>
</style>
<body>

	<form action="login.html" method="post" name="submitForm" onsubmit="return validateLoginForm()"
		class="container" id="myForm">
		<center>
			<h2>Welcome to Elegant Microweb</h2>
			<table>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" id="username"
						onblur="validateUsername()" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="password" /></td> <!-- onblur="validatePassword()" -->
				</tr>
				<!-- <tr>
					<td></td>
					<td align="left"><input type="button" value="AddUser" name="button">
					<td align="right"><input type="submit" value="Login"
						name="button" /></td>

				</tr> -->


				<!-- 	<tr>
					<td>
						<button class="button" type="button"
							onclick="javascript:window.location=register.jsp">Add
							Account</button>
					</td>
				</tr> -->

			</table>
			<table align="center">
				<tr>
					<td>
						<a class="button" href="${pageContext.request.contextPath}/login"><button>Login</button></a>
					</td>
				</tr>
			</table>
			<div style="color: red">${error}</div>

			<h2>

				<a href="${pageContext.request.contextPath}/addUser.html">Add
					new User</a>
			</h2>
			<%-- <h2>
				<a href="${pageContext.request.contextPath}/add.html">List of
					User</a>
			</h2> --%>
		</center>
	</form>
	<div align="center" class="fixed-footer">
		<div class="container">Copyright &copy; Your Company</div>
	</div>
	<script type="text/javascript" src="js/loginFormValidation.js"></script>
</body>
</html>
