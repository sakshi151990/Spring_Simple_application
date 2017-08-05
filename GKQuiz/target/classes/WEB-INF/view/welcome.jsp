<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">


$(document).ready(function(){


$('.startbutton').click(function(){$(this).css('background-color',"grey");});

});


</script>
<title>Welcome</title>
</head>
<body style="text-align: center;color:fuchsia;">

<div style="background: #FAEBD7;text-align: center; width: 639px;margin: 0 auto;" >
<h2 style="color: white;font-family: fantasy;background-color: black;height: 50px;padding: 20px">Welcome ${name},</h2>

<div style="padding: 20px">

<h2 style="color: black;font-family: fantasy;height: 50px;padding: 20px"> Click below to Test your General knowledge </h2><br>

<button class="startbutton" style=" font-size:20px; 
 border-radius: 8px;
 background-color: black;
 width: 113px; height: 36px;
 font-family: cursive;
 color: white;
" onclick="window.location.href='/QuestionAnswer'" value="START"><strong>START</strong></button>


</div>
</div>


</body>
</html>