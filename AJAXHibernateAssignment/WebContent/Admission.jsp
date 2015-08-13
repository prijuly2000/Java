<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
var objXMLHttp;
function insertCourse()
{
	objXMLHttp=new ActiveXObject("Microsoft.XmlHttp");
	if(objXMLHttp==null)
	{
		alert("AJAX not done");
		return;
	}
	
	objXMLHttp.onreadystatechange=handleresponse;
	
	
	objXMLHttp.open("Get","AllCourses.jsp",true);
	objXMLHttp.send(null);
	alert("called");
		
}

function handleresponse()
{
	if(objXMLHttp.readystate==4)
	{
		document.getElementById("all").innerHTML=objXMLHttp.responseText;
		var str=objXMLHttp.responseText;
		var index=0;
		var split=str.split(",");
		document.getElementById("al").innerHTML=split;
		for(var i=0;i<4;i++)
		{
			
			var o = new Option(objXMLHttp.responseText, objXMLHttp.responseText);
			document.register.course.add(o);
		} 
	}
	
}
</script>

</head>
<body onload="insertCourse();">
<form name="register" method="get" >
<table>
<tr>
	<td>Name :</td>
	<td><input type="text" name="name" /></td>
</tr>

<tr>
	<td>Course :</td>
	<td><select id="course" name="course" ></select></td>
</tr>

<tr>
	<td>Phone :</td>
	<td><input type="text" name="phone"/></td>
</tr>

<tr>
	<td>Best Time To Call :</td>
	<td>
		<select name="btc">
		<option>8-10 am</option>
		<option>10-12 am</option>
		<option>12-2 pm</option>
		<option>2-4 pm</option>
		</select>
	</td>
</tr>

<tr>
	<td>Email : </td>
	<td><input type="text" name="email"/></td>
</tr>

<tr>
	<td>Message :</td>
	<td><textarea rows="5" cols="13" name="msg"></textarea></td>
</tr>

<tr>
	<td><span id="all"></span></td>
	<td><input type="submit" value="Submit"/></td>
</tr>
<span id="al"></span>
</table>    
</form>
</body>
</html>