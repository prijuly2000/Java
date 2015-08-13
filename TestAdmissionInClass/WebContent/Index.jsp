<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Admissions.jsp" method="get">
Name : <input type="text" name="Name"><br/>
Email: <input type="text" name="Email"><br/>
Class: <select><option>Java</option>
       <option>JavaEE</option>
       <option>JavaME</option>
       </select><br/>
Mobile:<input type="text" name="Mobile"><br/>
       <input type="submit" name="Confirm Admission">
</form>
</body>
</html>