<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<%@ page session="false" %>
<html>
<head>
<title>Spitter</title>
<style type="text/css">
span.error {
color: red;
}
</style>
</head>
<body>
<h1>Register</h1>
<sf:form method="POST" commandName="spitter" enctype="multipart/form-data">
First Name: <sf:input  path="firstName" /><sf:errors path="firstName" cssClass="error"></sf:errors><br/>
Last Name: <sf:input  path="lastName" /><sf:errors path="lastName" cssClass="error"></sf:errors><br/>
Username: <sf:input path="username" /><sf:errors path="username" cssClass="error"></sf:errors><br/>
Password: <sf:password path="password" /><sf:errors path="password" cssClass="error"></sf:errors><br/>
<input type="file" 	name="profilepicture" accept="image/jpeg,image/png,image/gif"/>
<input type="submit" value="Register" />
</sf:form>
</body>
</html>