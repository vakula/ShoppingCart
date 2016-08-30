<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
  <link rel="stylesheet" href='<x:url value="/resources/css/bootstrap.min.css"></x:url>' />
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<%@ include file="nav.jsp" %>
 <h1>Hello... <%=session.getAttribute("loggedInUser")%></h1>
    <div class="container">
        
<div ng-app="myApp" ng-controller="customersCtrl">
<input type="text" class="form-control" ng-model="searchBy.name"/>
<table class="table table-hover table-bordered">
  <tr>
       <th>Category id</th>
       <th>Category name</th>
       <th>Category description</th>
      
  </tr>
  <tr ng-repeat="c in names | filter:searchBy">
    <td>{{c.id}}</td>
    <td>{{c.name}}</td>
    <td>{{c.description}}</td>
    <td>
    <a href="${pageContext.servletContext.contextPath}/viewcategory?id={{c.id}}"><span>View</span></a>
    <a href="${pageContext.servletContext.contextPath}/editcategory?id={{c.id}}"><span>| Edit |</span></a>
    <a href="${pageContext.servletContext.contextPath}/deletecategory?id={{c.id}}"><span>Delete</span></a>
   </td>  
  </tr>
</table>
<a href="AddCategory" class="btn btn-info">Add Category</a>
</div>
<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("list1")
    .then(function (response) {$scope.names = response.data;});
});
</script>
</div>
</body>
</html>