<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
     <link rel="stylesheet" href='<x:url value="/resources/css/bootstrap.min.css"></x:url>' />
  <script src='<x:url value="/resources/js/jquery.min.js"></x:url>'></script>
  <script src='<x:url value="/resources/js/bootstrap.min.js"></x:url>'></script>
  <script src='<x:url value="/resources/js/angular.min.js"></x:url>'></script>
   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   
</head>
   <body>
   <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
    </div>
    <ul class="nav navbar-nav">
            <li><a href="cont">Contact us</a></li>
      <li><a href="logout">Logout</a></li>
          </ul>
  </div>
</nav>
<h1>Hello... <%=session.getAttribute("loggedInUser")%></h1>
      <div class="container">
            <table class="table table-hover table-bordered">
            <tr><td>${login.id}</td></tr>
            <tr><td>${login.name}</td></tr>
            <tr><td>${login.Role}</td></tr>
            <tr><td>${login.Status}</td></tr>
            
            <sec:authorize access="hasRole('ROLE_USER')">
            <tr><td></td><td><a href="viewcart?id=${login.id}" class="btn btn-primary">Add Cart</a>
              </td></tr></sec:authorize>               
            </table>
      </div>
   </body>
</html>