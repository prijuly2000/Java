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
<s:form action="catFile" enctype="multipart/form-data" method="post">
<table>
<tr>
	<td><s:text name="reg.catId"/></td>
 	<td><s:textfield name="catId"/></td>
</tr>
<tr>
	<td><s:text name="reg.catName"/></td>
	<td><s:textfield name="catName" /></td>
</tr>
<tr>	
	<td><s:text name="reg.catDesc"/></td>
	<td><s:textfield name="catDesc" /></td>
</tr>
<tr>
	<td><s:text name="reg.catImg"/></td>
	<td><s:file name="catImg"></s:file></td>
</tr>
<tr>
	<td></td>
	<td><s:submit value="submit"/><br/></td>
</tr>
</table>
</s:form>
</body>
</html>