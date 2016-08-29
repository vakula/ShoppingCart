<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style type="text/css">
.errStyle {
	color: red;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
<%@ include file="nav.jsp" %>

	<div class="container">
		<c:url var="register" value="register"></c:url>
		<form:form commandName="Register" method="post" action="storeuser">
			<form:errors path="*" cssClass="errStyle" element="div" />
			<div class="form-group">
				<form:label path="username">
					<spring:message text="UserName" />
				</form:label>
				<form:input class="form-control" path="username" />
				<form:errors path="username">
				

				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="email">
					<spring:message text="Email ID" />
				</form:label>
				<form:input class="form-control" path="email" />
				<form:errors path="email">
					<p class="errStyle">* Invalid email</p>

				</form:errors>

			</div>
			<div class="form-group">
				<form:label path="mobile">
					<spring:message text="Phone Number" />
				</form:label>
				<form:input class="form-control" path="mobile" />
				<form:errors path="mobile">
					<p class="errStyle">* Invalid Phone</p>
				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="address">
					<spring:message text="Address" />
				</form:label>
				<form:input class="form-control" path="address" />
				<form:errors path="address">
					<p class="errStyle">* Invalid Address.</p>
				</form:errors>
			</div>

			<div class="form-group">
				<form:label path="password">
					<spring:message text="Password" />
				</form:label>
				<form:input class="form-control" path="password" />
				<form:errors path="password">
					<p class="errStyle">* Invalid password</p>
				</form:errors>
			</div>

			<div class="form-group">
				<form:label path="confirmpassword">
					<spring:message text="Confirm Password" />
				</form:label>
				<form:input class="form-control" path="confirmpassword" />
				<form:errors path="confirmpassword">
					<p class="errStyle">* Invalid Confirm Password</p>
				</form:errors>
			</div>

			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
	</div>

</body>
</html>