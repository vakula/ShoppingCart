<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"></c:url>' />
  <script src='<c:url value="/resources/js/jquery.min.js"></c:url>'></script>
  <script src='<c:url value="/resources/js/bootstrap.min.js"></c:url>'></script>
  <script src='<c:url value="/resources/js/angular.min.js"></c:url>'></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="back">HOME</a></li>
          <li><a href="hai">LOGOUT</a></li>
      </ul>
  </div>
</nav>
<!--<c:url var="storeProduct" value="saveProduct"/>-->
  <form:form id="st1" modelAttribute="Product" method="post" action="storeproduct" enctype="multipart/form-data">
    <form:hidden style="visibility:hidden" path="id" value="${product.id}" />
      <tr><td><form:label path="name">Product Name :</form:label></td>
               <td><form:input path="name" value="${product.name}"/></td>
           </tr>
               <tr><td><form:label path="price">Product Price :</form:label></td>
               <td><form:input path="price" value="${product.Price}"/></td>
           </tr>
           <tr><td><form:label path="description">Description :</form:label></td>
               <td><form:input path="description" value="${product.description}"/></td>
           </tr>           
          <tr><td><form:label path="warranty">Warranty :</form:label></td>
               <td><form:input path="warranty" value="${product.warranty}"/></td>
           </tr>
                 
           <tr><td><form:label path="img">Product Image :</form:label></td>
               <td><form:input path="img" type="file" />
               <font color="red"><form:errors path="img"></form:errors></font></td><tr>
           
           
               <tr><td></td>
               <td><input type="submit" value="submit"/></td>
           </tr>
           
                      
  </form:form>   
</body>
</html>
