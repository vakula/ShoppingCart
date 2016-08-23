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
<body>
<center>
		<h1>
		<p>E<span style="color:blue;font-weight:bold">y</span>e<span style="color:darkolivegreen;font-weight:bold">W</span>e<span style="color:red;font-weight:bold">a</span>r  Shopping.</p>

		</h1>
	</center>
<head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.activ)
{
background-color:#111;
}
.activ {
	background-color: blue;
}
</style>
</head>
<body>
<center>
	<ul>
		<li><a href="Adminhome">Home</a></li>
		<li><a href="Category">Categories</a></li>
			<li><a href="Retrieveproduct">product details</a></li>
		<li><a href="Retriveuser">user details</a></li>
	
		<li style="float: right"><a class="activ" href="logout">Logout</a></li>
	</ul>
  </div>
</nav>
 <h1>Hello... <%=session.getAttribute("loggedInUser")%></h1>
    <div class="container">
        
<div ng-app="myApp" ng-controller="customersCtrl">
<input type="text" class="form-control" ng-model="searchBy.name"/>
<table class="table table-hover table-bordered">
  <tr>
       <th>User Id</th>
       <th>User Name</th>
       <th>User Password</th>
       <th>User Status</th>
        <th>User_Role</th>
       
      
  </tr>
  <tr ng-repeat="u in names | filter:searchBy">
    <td>{{u.id}}</td>
    <td>{{u.name}}</td>
    <td>{{u.password}}</td>
     <td>{{u.status}}</td>
     <td>{{u.role}}</td>

    <td>
    
    <a href="./Edituser?id={{u.id}}"><span>|Edit|</span></a>
 <a href="./deleteuser?id={{u.id}}"><span>Delete</span></a>
</td>
</tr>
<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("list3")
    .then(function (response) {$scope.names = response.data;});
});
</script>
</div>
</body>
</html>