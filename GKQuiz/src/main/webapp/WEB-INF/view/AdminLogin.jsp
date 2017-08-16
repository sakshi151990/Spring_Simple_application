<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login page</title>
<style type="text/css">

.main {
background-color: white;
border-color: black;
border-style: solid;
border-width: 1px;
width: 431px; height: 100px;
padding: 20px;
margin: 0 auto;
border-radius: 30px;



</style>
</head>
<body>
<div style="background: #FAEBD7;text-align: center; width: 775px; height: 940px">

<h2 style="color: white;font-family: fantasy;background-color: black;">Welcome to the Online Quiz Application</h2>
<br>
<h3>Login with Admin credentials</h3>
<div class="main">
	<form:form method="POST" commandName="user" action="Adminpage.html">

       
        <br>
    <form:label path="name">Name :</form:label>
        <form:input path="name" /></br>
        
         <form:label path="password">Password :</form:label>
        <form:input path="password" />
    <br><br>
      
            <input style="font-size:20px; 
 border-radius: 8px;
 background-color: black;
 width: 113px; height: 47px;
 color:white;
 font-family: cursive;" type="submit" value="Submit"/>
    
      
  
</form:form>
	</div>
</div>
</body>
</html>