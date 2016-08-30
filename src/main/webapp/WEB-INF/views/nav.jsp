<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
    
<nav class="navbar navbar-default">
  <div class="container-fluid" ng-controller="mainController">
    <div class="navbar-header">
      
    </div>
    
    <ul class="nav navbar-nav">
          <li><a href="hai">Home</a></li>
	<% if(session.getAttribute("userRole") == "ROLE_ADMIN") { %>
          <li><a href="display">Manage Products</a></li>
           <li><a href="displaycategory">Manage Category</a></li>
            <li><a href="displaysupplier">Manage Supplier</a></li>
    <% } else {%>
            <li><a href="register">Register</a></li>
            <li ng-show="!isUserLoggedIn"><a href="login">Login</a></li>
            <li><a href="listproducts">Products</a></li>
	<% } %>
          <li ng-show="isUserLoggedIn" ><a href="logoutsuccess">Logout</a></li>
     </ul>
  </div>
</nav>
