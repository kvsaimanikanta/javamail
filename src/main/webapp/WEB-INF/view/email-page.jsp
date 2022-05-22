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

	<h1 align="center">Send Result to email</h1>
	<h2 align="center">Hi ${userInfo.yourName}</h2>

	<div align="center">

		<form:form action="emailProcess-page" method="get"
			modelAttribute="emailDto">
			<form:label path="userEmail">Enter Your Email id :</form:label>
			<form:input path="userEmail" /><br><br>
			<input type="submit" value="send">
		</form:form>

	</div>

</body>
</html>