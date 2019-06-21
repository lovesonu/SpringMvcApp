<%@page import="com.webmodule.springmvc.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%-- <base
	href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" /> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Success page</title>
</head>
<style type="text/css">
<%@include file="/resources/css/style.css"%></style>
<style type="text/css">
</style>
<body>
<div align="center">


<h3>Welcome to home page ${admin.username}</h3>
	<form  method="get" id="myForm" class="container"
		onsubmit="return validateLoginForm()">
		<table border="1" bordercolor="red" bgcolor="pink" align="center">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>UserName</th>
					<th>Password</th>
					<th>Country</th>
					<th>State</th>
					<th>City</th>
					<th>Area</th>
					<th>Pincode</th>
				</tr>
			
			<tbody>
				<tr>
					<td>${admin.id}</td>
					<td>${admin.name}</td>
					<td>${admin.email}</td>
					<td>${admin.phone}</td>
					<td>${admin.username}</td>
					<td>${admin.password}</td>
					<td>${admin.country}</td>
					<td>${admin.state}</td>
					<td>${admin.city}</td>
					<td>${admin.area}</td>
					<td>${admin.pincode}</td>
					
					<td align="center"><a href="edit.html?id=${admin.id}">Edit</a>
						| <a href="delete.html?id=${admin.id}">Delete</a></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>

</body>
</html>

