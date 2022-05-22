<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
name : ${userSignup.name}<br>
userName : ${userSignup.userName}<br>
Password :
<c:forEach var ="temp" items="${userSignup.password}">
${temp}
</c:forEach><br>
Hobbies : 
<c:forEach var="temp" items="${userSignup.hobbies}">
${temp}
</c:forEach>
<br>
Country : ${userSignup.country}<br>
Age : ${userSignup.age}<br>
Gender : ${userSignup.gender}<br>
<br>
Email : ${userSignup.communicationDto.email	}<br>
Phone : ${userSignup.communicationDto.phone	}
</body>
</html>