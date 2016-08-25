<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<html>
<head>
  <link rel="stylesheet" href='<x:url value="/resources/css/bootstrap.min.css"></x:url>' />
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      
    </div>
    <ul class="nav navbar-nav">
          <li><a href="cont">Contact us</a></li>
           <sec:authorize var="loggedIn" access="isAuthenticated()" />
          <sec:authorize access="permitAll">
          <li><a href="${pageContext.request.contextPath}/logout"><span>Logout</span></a></li>
		  </sec:authorize> 
          
         <!-- <li><a href="j_spring_security_logout">Logout</a></li> -->        
      </ul>
  </div>
</nav>
 <h1>Hello... <%=session.getAttribute("loggedInUser")%></h1>
    <div class="container">
        
<div ng-app="myApp" ng-controller="customersCtrl">
<input type="text" class="form-control" ng-model="searchBy.watchName"/>
<table class="table table-hover table-bordered">
  <tr>
       <th>Product Id</th>
       <th>Product Name</th>
       <th>Product Description</th>
       <th>Product price</th>
      
  </tr>
  <tr ng-repeat="x in names | filter:searchBy">
    <td>{{x.id}}</td>
    <td>{{x.name}}</td>
    <td>{{x.description}}</td>
    <td>{{x.price}}</td>
    <td>
    
    <a href="${pageContext.servletContext.contextPath}/viewproduct?id={{x.id}}"><span>View</span></a>
    
    <a href="${pageContext.servletContext.contextPath}/editproduct?id={{x.id}}"><span>| Edit |</span></a>
    <a href="${pageContext.servletContext.contextPath}/delete?id={{x.id}}"><span>Delete</span></a>
   
   </td>  
  </tr>
</table>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="addproduct" class="btn btn-info">addproduct</a>
</sec:authorize>

</div>

<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("list")
    .then(function (response) {$scope.names = response.data;});
});
</script>
</div>
</body>
</html>



