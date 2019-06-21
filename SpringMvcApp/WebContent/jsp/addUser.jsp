<!-- List of data showing after registration form submit -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All User</title>
</head>
<body>
	<h2>
		<a href="${pageContext.request.contextPath}/addUser.html">Add new
			User</a>
	</h2>
	<h1>list Admin</h1>

	<c:if test="${!empty admins}">
		<table align="left" border="1">
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
				<th>Action</th>
			</tr>

			<c:forEach items="${admins}" var="admin">
				<tr>
					<td><c:out value="${admin.id}" /></td>
					<td><c:out value="${admin.name}" /></td>
					<td><c:out value="${admin.email}" /></td>
					<td><c:out value="${admin.phone}" /></td>
					<td><c:out value="${admin.username}" /></td>
					<td><c:out value="${admin.password}" /></td>
					<td><c:out value="${admin.country}" /></td>
					<td><c:out value="${admin.state}" /></td>
					<td><c:out value="${admin.city}" /></td>
					<td><c:out value="${admin.area}" /></td>
					<td><c:out value="${admin.pincode}" /></td>

					<td align="center"><a href="edit.html?id=${admin.id}">Edit</a>
						| <a href="delete.html?id=${admin.id}">Delete</a></td>
					</tr>
			</c:forEach>

		</table>
	</c:if>

</body>
</html>