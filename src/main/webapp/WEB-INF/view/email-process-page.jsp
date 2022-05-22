<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"> Email Result Page </h1>
	<h2 align="center">Hi ${userInfo.yourName}</h2>
	<br> 
	
	<div align="center">
	Email send successfully to ${emailDto.userEmail}
	</div>

</body>
</html>