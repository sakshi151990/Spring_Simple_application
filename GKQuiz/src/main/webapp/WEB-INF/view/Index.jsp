<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$('button').hover(function(){$(this).css('background-color',"grey")});
$('#butt-in').click(function(){
$('.login').show();

})
$('#butt-up').click(function(){
$('.register').show();});
});


</script>
<title>Login Form</title>
<style type="text/css">
 button {
 font-size:20px; 
 border-radius: 8px;
 background-color: black;
 width: 113px; height: 36px;
 font-family: cursive;
 color: white;

 }
.main {
background-color: white;
border-color: black;
border-style: solid;
border-width: 1px;
width: 431px; height: 100px;
padding: 20px;
margin: 0 auto;
border-radius: 30px;



}

.register , .login{
margin: 0 auto;
border-color: black;
border-style: solid;
border-width: 1px;
display:none;
background-color: white;
width: 431px;
border-radius: 20px;

}
</style>
</head>
<body style="text-align: center;">
<div style="background: #FAEBD7;text-align: center; width: 775px; height: 940px">

<h2 style="color: white;font-family: fantasy;background-color: black;">Welcome to the Online Quiz Application</h2>
<br>

<div class="main" >

<label style="color: black;font-family: sans-serif;font-style: oblique;">Already a user ?</label>&nbsp;&nbsp;&nbsp;
<button id="butt-in" >Sign In</button>
<br><br>
<label style="color: black;font-family: sans-serif;font-style: oblique;">New user ?</label>&nbsp;&nbsp;&nbsp;
<button id="butt-up"  >Sign Up</button>

</div>
<br><br><div class="login">
	<form:form method="POST" commandName="user" action="/login">

       
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
<div class="register" >
<form:form method="POST" commandName="user" action="register.html">
<h4>Create a new account:</h4>
      
        <br>
    <form:label path="name">Username :</form:label>
        <form:input path="name" />
    <br>
         <form:label path="email">Email :</form:label>
        <form:input path="email" />
    <br>
      
         <form:label path="password">Password :</form:label>
        <form:input path="password" />
        <br>
        <form:label path="fullName">Full Name :</form:label>
        <form:input path="fullName" />
    <br><br>
            <input style="background: black;font-family: cursive;font-size: 16px; width: 107px ;color: white;" type="submit" value="Register"/>
    
</form:form>

</div>
</div>
</body>
</html>