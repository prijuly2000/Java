<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/WEB-INF/Database.tld" prefix="pritz" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="objStudent" class="org.Student" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="objStudent"/>
<%
	pageContext.setAttribute("objStudent", objStudent);
%>
<pritz:connect></pritz:connect>
<%
	out.println("<h1>Registered Successfully</h1>");
%>

</body>
</html>