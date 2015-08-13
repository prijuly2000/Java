<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddData.jsp" >
Name:<input type="text" name="name">
<br/>
<br/>
Email:<input type="text" name="email">
<br/>
<br/>
Class :
<select name="className">
<option>Java</option>
<option>JavaEE</option>
<option>JavaME</option>
</select>
<br/>
<br/>
Mobile:<input type="text" name="mobile">
<br/>
<br/>
<input type="submit" value="Submit">

</form>
</body>
</html>