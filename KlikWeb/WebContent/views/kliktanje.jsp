<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
	<title>Clicks</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body background="resources/images/background.jpg">	
	<br>
	<div class="container" align="center">
		<button id="btnnext"class="btn btn-primary btn-lg">Next</button>	
		<br>	
		<img id="image" src="${list[0].image.url}" class="img-thumbnail" width="400" height="300">	
		<p style="color:blue; font-size:20px"></p>	
	</div>	
		
	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="<c:url value="/resources/skripta.js"/>"></script>
</body>
</html>