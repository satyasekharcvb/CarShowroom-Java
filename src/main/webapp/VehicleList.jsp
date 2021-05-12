<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Car Show Room</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	</head>
<body>
 	<div class="container">
 		<ul>
		  	<li><a class="active" href="list">Vehicle List View</a></li>
	    	<li><a href="new">New Vehicle Arrivals</a></li>
		</ul>
	    <div class="vehicletable">
	        <table border="1">
	            <caption><h2>List of Vehicles</h2><a href="new" class="button">New<br/>Vehicle</a></caption>
	            <tr>
	                <th>Brand</th>
	                <th>Model</th>
	                <th>Price</th>
	            </tr>

	 			<c:forEach items="${vehicleList}" var="vehicle">
	                <tr>
                      <td> ${ vehicle.getBrand() } </td>
	                    <td> ${ vehicle.getModel() } </td>
	                    <td> 
	                    	<fmt:setLocale value="en_IN"/>
	                    	<fmt:formatNumber value = "${ vehicle.getPrice() }" type = "currency"/>
	                    </td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>
    </div>
</body>
</html>