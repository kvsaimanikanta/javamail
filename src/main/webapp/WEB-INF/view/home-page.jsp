<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<style type="text/css">
.error {
	color: red;
	text-align: left;
	position: fixed;
	margin-left: 30px;
}
</style>

<script type="text/javascript">
function validateNames(){
	
	var userName = document.getElementById('yn').value;
	var crushName = document.getElementById('cn').value;

	if(userName.length < 3){
		alert("Your name must have 3-10 chars only")
		return false;
	}else if (crushName.length < 3){
		alert("Crush name must have 3-10 chars only")
		return false;
	}else if(userName == crushName) {
		alert("user name and crush name con't be same")
		return false;
	}else{
		return true;
	}
}
</script>

</head>
<body>

	<h1 align="center">Love Calculator</h1><hr>

	<form:form action="process-page" method="get" modelAttribute="userInfo">

		<div align="center">
		
		    <p>
			<label for="yn">Your Name :</label> 
			<form:input id="yn" path="yourName" /> 
			<form:errors path="yourName" cssClass="error"/>
			</p>
			
			<p>
			<label for="cn">Crush Name :</label> 
			<form:input id="cn" path="crushName" /> 
			<form:errors path="crushName" cssClass="error"/>
			</p>
			
			<p>
			<form:checkbox path="termsAndCon"/>
			<form:label path="termsAndCon">This is only for fun</form:label>
			<form:errors path="termsAndCon" cssClass="error" />
			</p>
			
			<input type="submit" value="calculate">
			
		</div>

	</form:form>

</body>
</html>