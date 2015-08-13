<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<form action="Admission.jsp" method="get">
Admission Form<br/>

<tr><td>Name : -</td><td><input type="text" name="name"></td></tr><br/>
<tr><td>Email : -</td><td><input type="text" name="email"></td></tr><br/>
<tr><td>Class To Join :-</td><td><select name="select"><option>Java</option><option>JavaEE</option><option>JavaME</option></select></td></tr><br/>
<tr><td>Mobile : -</td><td><input type="text" name="mobile"></td><br/>
<tr><td colspan="1"><input type="submit" value="Register"></td></tr>


</form> 


</table>
</body>
</html>