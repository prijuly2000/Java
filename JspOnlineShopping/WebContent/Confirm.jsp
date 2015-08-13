<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="objUser" class="org.User" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="objUser"/>
userName:<jsp:getProperty property="userName" name="objUser"/><br/>
Name:<jsp:getProperty property="name" name="objUser"/><br/>
Email:<jsp:getProperty property="email" name="objUser"/><br/>

<a href='Register.jsp'>confirm</a>&nbsp;
&nbsp;
<a href='NewUser.jsp'>cancel</a>

</body>
</html>