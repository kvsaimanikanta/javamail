<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Form</title>

<style type="text/css">
.error {
	color: red;
	text-align: left;
	position: fixed;
	margin-left: 30px;
}
</style>

<script type="text/javascript">

function validation(){
	
	var name = document.getElementById('name').value;
	
	if(name.length < 1){
		alert("you need to enter the name")
		return false;
	}else{
		return true;
	}
	
}

</script>

</head>
<body>

	<h1 align="center">Love Calculator</h1>

	<div align="center">

		<form:form action="afterSignup" method="get" modelAttribute="userSignup">

			<form:label path="name">Name :</form:label>
			<form:input path="name" id="name"/>
			<form:errors path="name" cssClass="error"/><br><br>
			
			<form:label path="userName">User Name :</form:label>
			<form:input path="userName" />
			<form:errors path="userName" cssClass="error"/><br><br>
			
			<form:label path="password">Password :</form:label>
			<form:password path="password" /><br><br>
			
			<form:label path="country">Country :</form:label>
			<form:select path="country" id="country">
			<form:option value="" label=""></form:option>
			<form:option value="india" label="India"></form:option>
			<form:option value="us" label="United States"></form:option>
			<form:option value="uk" label="United Kingdom"></form:option>
			<form:option value="sl" label="Sri Lanka"></form:option>
			</form:select><br><br>

			<form:label path="hobbies">Hobbies :</form:label>
			<form:checkbox path="hobbies" value="cricket" label="Cricket" />
			<form:checkbox path="hobbies" value="reading" label="Reading" />
			<form:checkbox path="hobbies" value="programming" label="Programming" /><br><br>
			
			<form:label path="gender">Gender :</form:label>
			<form:radiobutton path="gender" value="male" label="Male"/>
			<form:radiobutton path="gender" value="female" label="Female"/><br><br>
			
			<p>
			<label>Age</label>
			<form:input path="age"/>
			<form:errors path="age" cssClass="error"/>
			</p>
			
			<label>Communication :</label>
			<p>
			<form:label path="communicationDto.email">Email :</form:label>
			<form:input path="communicationDto.email" id="email"/>
			<form:errors path="communicationDto.email" cssClass="error"/>
			</P>
			
			<p>
			<form:label path="communicationDto.phone">Phone :</form:label>
			<form:input path="communicationDto.phone" id="phone"/>
			<form:errors path="communicationDto.phone" cssClass="error"/>
			</p>
			
			<input type="submit" value="SignUp"/>

		</form:form>

	</div>

</body>
</html>