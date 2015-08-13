<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Details.jsp">
<input type="radio" name="condition" value="id">Id<br/><br/>
<input type="radio" name="condition" value="userName">username<br/><br/>
<input type="radio" name="condition" value="name">name<br/><br/>
<input type="radio" name="condition" value="email">email<br/><br/>
Criteria:<input type="text" name="criteria" ><br/><br/>
<input type="submit" value="Submit">


</form>
</body>
</html>