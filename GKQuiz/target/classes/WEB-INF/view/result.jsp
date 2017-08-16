<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>resultpage</title>
<script type="text/javascript">


$(document).ready(function(){


$('button').click(function(){$(this).toggle().css('background-color',"grey");});


});


</script>
<style type="text/css">

button {
style=" font-size:20px; 
 border-radius: 8px;
 background-color: black;
 width: 113px; height: 36px;
 font-family: cursive;
 color: white;


}


</style>
</head>
<body>
<div style="background: #FAEBD7;text-align: center; width: 639px;margin: 0 auto;" >
<h2 style="color: white;font-family: fantasy;background-color: black;height: 50px;padding: 20px">Welcome ${name},</h2>
<c:if test="${ userresult.result >=  50 }">
<p>Congratulations , You have passed the quiz.</p>
</c:if>
<c:if test="${ userresult.result <  50 } ">
<p>You are failed. Please try again... </p>
</c:if>
<p>Correct Answers: ${userresult.correct}</p>
<p>Your result is : ${ userresult.result}</p>
<h3>Thank you for taking the quiz.</h3>

<br>
<button class="startbutton" 
 onclick="window.location.href='/welcome'" value="Home"><strong>Home</strong></button>
</div>

</body>
</html>