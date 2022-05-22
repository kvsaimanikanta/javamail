<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Page</title>
</head>
<body>

	<h1 align="center">Lc App Result</h1>
	<hr>

	<div align="center">

		<p>your result is</p>

		${userInfo.yourName} and ${userInfo.crushName} both are <br>
		${userInfo.result} <br>

		<!-- <a href="/SpringMvc-lc/sendEmail">Send Result to my email</a>  -->

		<a href="<c:url value = "/sendEmail"/>"> Send Result to my email </a>

	</div>

</body>
</html>