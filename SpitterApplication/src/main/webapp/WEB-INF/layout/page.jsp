<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="header">
<t:insertAttribute name="header"></t:insertAttribute>
</div>
<div id="body">
<t:insertAttribute name="body"></t:insertAttribute>
</div>
<div id="footer">
<t:insertAttribute name="footer"></t:insertAttribute>
</div>

</body>
</html>