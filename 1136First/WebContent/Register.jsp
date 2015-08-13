<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="Confirm.jsp">
	<s:textfield name="userName" label="User Name"></s:textfield>
	<s:textfield name="password" label="password"></s:textfield>
	<s:radio list="'Female'" name='gender'></s:radio>
	<s:radio list="'Male'" name='gender'></s:radio>
	
	<s:textfield name="dob" label="dob"></s:textfield>
	<s:submit></s:submit>
</s:form>
</body>
</html>