<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
          <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
         <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
         
    
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adminpage</title>
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
<h2 style="color: white;font-family: fantasy;background-color: black;height: 30px;padding: 10px">Welcome to Admin page</h2>
<button id="logout" onclick="window.location.href='/logout'"  >Logout</button>

<h3 >Add questions</h3>



<form:form method="POST" commandName="questionanswer" action="/addQuestions">
 <form:label path="name">Enter the Question: </form:label>
 <form:input path="name"/>

 <form:label path="optionA">Option A: </form:label>
 <form:input path="optionA"/>
 <br>
  <form:label path="optionB">Option B:  </form:label>
 <form:input path="optionB"/>
 <br>
  <form:label path="optionC">Option C: </form:label>
 <form:input path="optionC"/>
  <form:label path="optionD">Option D: </form:label>
 <form:input path="optionD"/>
 
  <form:label path="answer">Correct Answer</form:label>
 <form:input path="answer"/>

<input style="font-size:20px;  border-radius: 8px;background-color: black;width: 113px; height: 36px;font-family: cursive;color: white;" type="submit" value="SUBMIT">

</form:form>
</div>

</body>
</html>