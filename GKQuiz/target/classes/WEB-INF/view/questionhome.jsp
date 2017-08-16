<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
         <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
         
    
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizpage</title>
<script type="text/javascript">
$(document).ready(function(){
$('.ans').click(function(){$(this).css("background-color","aqua");});
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

.ans{


margin: 0 auto;
background-color:gray;width: 300px;color: black;
height: 40px;
padding: 5px 5px 5px 5px 5px;
}

</style>
</head>
<body style="text-align: center;">
<div style="background: #FAEBD7;text-align: center; width: 1000px;margin: 0 auto;">
<h2 style="color: white;font-family: fantasy;background-color: black;height: 30px;padding: 10px">Welcome ${name}</h2>
<h3 >General Knowledge Quiz</h3>




<form action="/QuestionAnswer.html/submit.html" method="POST">

<div class="quest" style="background-color: gray; width: 300px;margin-left: 190px; height: 160px;float: left;display:inline">
<c:out   value="${quest.name}"></c:out>
</div>
<div style="float: right;display:inline; margin-right: 200px;height: 165px">
<div class="ans" >
<input style="white-space: nowrap;" type="radio" value="${quest.optionA}" name="answer1"/>   
<c:out value="${quest.optionA}"></c:out>
</div>
<div class="ans"  >
<input type="radio" value="${quest.optionB}" name="answer1"/>
<c:out value="${quest.optionB}"></c:out>
</div>
<div class="ans" >
<input type="radio" value="${quest.optionC}" name="answer1"/>
<c:out value="${quest.optionC}"></c:out>
</div>
<div class="ans" >
<input type="radio" value="${quest.optionD}" name="answer1" />
<c:out value="${quest.optionD}"></c:out>
</div>

<br>

<input style="font-size:20px;  border-radius: 8px;background-color: black;width: 113px; height: 36px;font-family: cursive;color: white;" type="submit" value="submit">
</div>
</form>
</div>

</body>
</html>