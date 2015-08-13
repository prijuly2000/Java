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
<h1>Welcome To the site of nt-pritz & company supported by Shaktiman&Kilwish Company</h1><br/>
<h1><s:text name="welcome.company"></s:text> </h1>
<h3><s:text name="welcome.message"></s:text></h3>

<s:url id="en" action="Welcome">
	<s:param name="request_locale">en</s:param>
</s:url>
<s:url id="hi" action="Welcome">
	<s:param name="request_locale">hi</s:param>
</s:url>
<s:url id="fr" action="Welcome">
	<s:param name="request_locale">fr</s:param>
</s:url>

<s:a href="%{en}">english</s:a>
<s:a href="%{hi}">Hindi</s:a>
<s:a href="%{fr}">French</s:a>
</body>
</html>