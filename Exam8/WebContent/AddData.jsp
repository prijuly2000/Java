<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="WEB-INF/Database.tld" prefix="pritz"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="objUser" class="org.Admission" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="objUser"/>

<%
pageContext.setAttribute("objUser", objUser);
	
%>
<pritz:connect></pritz:connect>
</body>
</html>