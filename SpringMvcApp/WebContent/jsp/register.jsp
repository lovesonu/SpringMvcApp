<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Application</title>
<link type="text/css" rel="stylesheet" href=/resources/css/style.css" >
</head>
<body>
	<div align="center">
		<h1>Registration page</h1>
		<form:form method="post" action="save.html"
			onsubmit="return validateForm()" modelAttribute="registerModel"
			id="regF" name="regF">
			<table border="1" bordercolor="red" bgcolor="pink" align="center">
				<tr>
					<th colspan="3" align="center">Registration page for User</th>
				</tr>

				<tr>
					<td><label>Name</label></td>
					<td><form:input path="name" onclick="" id="name" /></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><form:input path="email" id="email" /></td>

				</tr>
				<tr>
					<td><label>Phone</label></td>
					<td><form:input path="phone" maxlength="10" id="phone"
							onkeypress="return isNumberKey(event)" /></td>
				</tr>
				<tr>
					<td><label>UserName</label></td>
					<td><form:input id="username" path="username"
							onblur="doAjaxPost()()" /></td>
				<tr>
					<td><label>Password</label></td>
					<td><form:password path="password" /></td>
				</tr>
				<%-- <tr>
					<td><label>Country</label></td>
					<td><form:input path="country" /></td>
				</tr> --%>

				<tr>
					<td><label>Country</label></td>
					<td><form:select path="country" onchange="state_change()">
							<form:option value="USA">USA</form:option>
							<form:option selected="selected" value="IND">IND</form:option>
							<form:option value="AUS">AUS</form:option>
							<form:option value="UK">UK</form:option>
						</form:select></td>
				</tr>

				<%-- <tr>
					<td>Country :</td>
					<td><form:select path="country" multiple="true">
							<form:option value="none" label="---select---"></form:option>
							<form:options items="$countryList" />
						</form:select></td>
					<form:errors path="country" cssClass="error"></form:errors>
				</tr> --%>

				<tr>
					<td><label>State</label></td>
					<td><form:select path="state" onchange="city_change()">
							<form:option value="BIH">BIH</form:option>
							<form:option value="GUJ">GUJ</form:option>
							<%-- <form:option value="UP">UP</form:option>
							<form:option value="MH">MH</form:option> --%>
						</form:select></td>
				</tr>

				<tr>
					<td><label>City</label></td>
					<td><form:select path="city">
							<form:option value="patna">PATNA</form:option>
							<form:option value="gaya">GAYA</form:option>
							<form:option value="ahm">AHM</form:option>
							<form:option value="brd">BRD</form:option>
						</form:select></td>
				</tr>

				<tr>
					<td><label>Area</label></td>
					<td><form:select path="area">
							<form:option value="Maninagar">Maningar</form:option>
							<form:option value="ABCD">ABCD</form:option>
							<form:option value="ZXY">ZXY</form:option>
						</form:select></td>
				</tr>

				<tr>
					<td><label>Pincode</label></td>
					<td><form:input path="pincode" maxlength="6"
							onkeypress="return isNumberKey(event)" /></td>
					<!-- onblur="validatePincode()" -->
				</tr>

				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Register" /> <input
						type="reset" value="Reset" /></td>
				</tr>
			</table>
		</form:form>

	</div>
	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="js/validate.js"></script>
</body>
</html>
