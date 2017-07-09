<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

span.error{
color: red;

}

</style>
</head>
<body>

<p>Registration</p>
<sf:form method="POST" commandName="student">
Name:
<sf:input path="name" /><sf:errors path="name" cssClass="error"></sf:errors></br>
Rollno:
<sf:input path="rollno" /><sf:errors path="rollno" cssClass="error"></sf:errors></br>

 <input type="submit" value="Register" />
</sf:form>
</body>
</html>