<!-- //this is springMVCAPp project -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registraion form</title>
</head>
<style type="text/css">
</style>
<body>

	<jsp:forward page="jsp/login.jsp"></jsp:forward>
	<%-- <center>

		<h2>Welcome to Elegant Microweb</h2>
		<!--<a href="hello.html">Click Here Hello link</a>   for testing per  -->

		<form>
			<br />Username:<input type="text" name="username"> <br />Password:<input
				type="password" name="password"> <br /> <input
				type="submit" value="Submit">
		</form>
		<h2>
			<a href="${pageContext.request.contextPath}/addUser.html">Add new
				Admin</a>
		</h2>
		<h2>
			<a href="${pageContext.request.contextPath}/add.html">List of
				Admin</a>
		</h2>
		<h2>
			<a href="${pageContext.request.contextPath}/login.html">Account
				login</a>
		</h2>

	</center> --%>
</body>
</html>