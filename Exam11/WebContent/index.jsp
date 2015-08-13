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
<s:url id="en" action="AddCat">
	<s:param name="request_locale">en</s:param>
</s:url>
<s:url id="hi" action="AddCat">
	<s:param name="request_locale">hi</s:param>
</s:url>

<s:a href="%{en}">English</s:a>
<s:a href="%{hi}">Hindi</s:a>
</body>
</html>