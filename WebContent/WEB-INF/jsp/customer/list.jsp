<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page isELIgnored="false" %>
<!-- This contains the most used tag libraries -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
</head>
<body>
 <spring:url value="/customer/add" var="addURL" />
 <a href="${addURL }">Add new Customer</a>
 
 <table width="100%" border="1">
  <tr>
   <td>ID</td>
   <td>Firstname</td>
   <td>Lastname</td>
   <td>Email</td>
   <td>Comnments</td>
   <td>Recommendation</td>
    <td>Date of submission</td>
     <td>Total characters</td>
   <td colspan="2">Action</td>
  </tr>  
  <c:forEach items="${list }" var="customer" >
  
   <tr>
    <td>${customer.id }</td>
    <td>${customer.firstname }</td>
    <td>${customer.lastname }</td>
    <td>${customer.email }</td>
    <td>${customer.comments }</td>
    <td>${customer.recommendations }</td>
    <td>${customer.createdate }</td>
   <td> <c:choose>
       <c:when test="${customer.comments}=>1">
              <p>less than or equal to 150 characters </p>
       </c:when>
       <c:otherwise>
              <p> was greater or equal to 150 characters. </p>
       </c:otherwise>
  </c:choose>`</td>
    <td>
     <spring:url value="/customer/update/${customer.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/customer/delete/${customer.id }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>
  </c:forEach>
 </table>
</body>
</html>