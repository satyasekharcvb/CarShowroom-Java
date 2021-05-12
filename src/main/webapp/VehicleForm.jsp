<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Book Store</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
  	<ul>
	  	<li><a href="list">Vehicle List View</a></li>
    	<li><a class="active" href="new">New Vehicle Arrivals</a></li>
	</ul>

<div class="container">
    <form name="book_form" method="post" action="insert">
    <h2>
        New Vehicle Form
    </h2>
	  <p><label>Brand:</label>
    <input type="text" name="vehiclebrand" /></p>
	  <p><label>Model:</label>
    <input type="text" name="vehiclemodel" /></p>
    <p><label>Price:</label>
    <input type="text" name="vehicleprice" /></p>
	  <p><input type="submit" value="Submit"></p>
	</form>
	</div>
</body>
</html>