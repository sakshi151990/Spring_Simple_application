<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
    
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Home</title>
<link type="text/css" href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" >
<style type="text/css">
.divmain{
	background-color:pink;border-style:solid;border-color:blue;border-width:2px;
	 width: 500x; height: 200px;
	 text-align: center;
}


</style>
</head>
<body style="text-align: center;">
<h1 style="font-family: Arial;color: maroon;">Welcome to the GK Quiz</h1>
<div class="divmain" style="height: 391px; ">
<h2>Please fill the below form</h2>
<sf:form cssClass="formmain"  commandName="user" method="POST">
UserID:    <sf:input  path="Userid"/><br>
Name:      <sf:input path="name"/><br>
Email:   <sf:input path="email"/><br>
<br>
<input  style="background-color: green" type="submit" value="Register">
</sf:form>

</div>


</body>
</html>