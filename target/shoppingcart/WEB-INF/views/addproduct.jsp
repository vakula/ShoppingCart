 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet"
   href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
   
  <script 
  src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script
   src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="hai">Home</a></li>
     </ul>
  </div>
</nav>
    <div class="container" ng-app="imgApp" ng-controller="imgCtrl">
    <c:url var="addproduct" value="addproduct"></c:url>
   <form:form commandName="Product" method="post" action="storeproduct" enctype="multipart/form-data">
       <table class="table table-bordered" >
      
       <tr><td><form:label path="id">id :</form:label></td>
               <td><form:input path="id"/>
               <font color="red"><form:errors path="id"></form:errors></font></td>
           </tr>
           
           <tr><td><form:label path="name">name :</form:label></td>
               <td><form:input path="name"/>
               <font color="red"><form:errors path="name"></form:errors></font></td>
           </tr>
            <tr><td><form:label path="description">description :</form:label></td>
               <td><form:input path="description"/>
               <font color="red"><form:errors path="description"></form:errors></font></td>
           </tr> 
                <tr><td><form:label path="warranty">Warranty :</form:label></td>
               <td><form:input path="warranty"/>
               <font color="red"><form:errors path="warranty"></form:errors></font></td>
           </tr>   
           <tr><td><form:label path="price">price :</form:label></td>
               <td><form:input path="price"/>
               <font color="red"><form:errors path="price"></form:errors></font></td>
           </tr> 
            <tr><td><form:label path="img">Product Image :</form:label></td>
               <td><form:input path="img" type="file"/>
               <font color="red"><form:errors path="img"></form:errors></font></td>
           </tr>
       </table>
   </form:form> 
   
</body>
</html>