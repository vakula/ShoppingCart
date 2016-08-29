
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <style type="text/css">
.errStyle {
	color: red;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header"></div>
		<ul class="nav navbar-nav">
		<li><a href="hai">Home</a></li>
		<li class="active"><a href="display">Logout</a></li>
		</ul>
	</div>

         
</body>
</head>
<body>
<div class="container">
<c:if test="${error=='true'}">
  <div class="errorblock">
   Enter Your UserName and Password....
 
  </div>
 </c:if>
 <c:if test="${not empty logoutmsg }">
   <div class="logoutblock">
   <c:out value="${logoutmsg}" />
   </div>
 </c:if>
<form role="form" action="j_spring_security_check" method="post" commandName="Login" >
  <div class="form-group">
    <label for="username">User Name:</label>
    <input type="text"  name="username"  class="form-control" placeholder="Enter UserName" />
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" name="password" placeholder="Enter Password" /> 
  </div>
  
  <button type="submit"  class="btn btn-default" >Submit</button>
</form>
<h4>Not A User ? <a href="register">Sign Up Here</a></h4>
</div>
</body>
</html>