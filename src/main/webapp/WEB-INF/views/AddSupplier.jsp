<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="nav.jsp" %>
    <c:url var="AddSupplier" value="AddSupplier"></c:url>
   <form:form commandName="Supplier" method="post" action="storeSupplier">
       <table class="table table-bordered" >
           
           <tr><td><form:label path="name">Supplier Name :</form:label></td>
               <td><form:input path="name"/>
               <font color="red"><form:errors path="name"></form:errors></font></td>
           </tr>
           
           <tr><td><form:label path="address">Supplier Address :</form:label></td>
               <td><form:input path="address"/>
               <font color="red"><form:errors path="address"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="id"> Supplier Id:</form:label></td>
               <td><form:input path="id"/>
               <font color="red"><form:errors path="id"></form:errors></font></td>
           </tr>
           <tr><td></td>
               <td><input type="submit" value="submit" class="btn"/></td>
           </tr>   
       </table>
   </form:form>
</body>
</html> 