<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
var objXMLHttp;
function checkUser()
{
	objXMLHttp=new ActiveXObject("Microsoft.XmlHttp");
	if(objXMLHttp==null)
	{
		alert("AJAX failed");
		return;
	}
	
	objXMLHttp.onreadystatechange=handleresponse;
	var name=document.registerForm.userName.value;
	objXMLHttp.open("Get","CheckUser.jsp?userName="+name,true);
	objXMLHttp.send(null);
}

function handleresponse()
{
	if(objXMLHttp.readystate==4)
		{
		document.getElementById("result").innerHTML=objXMLHttp.responseText;
		
		}
}
</script>
</head>
<body>
<form name="registerForm" action="NewUser.jsp" method="get">
Username:<input type="text" name="userName"/>
<input type="button" value="Check" onclick="checkUser();"/>
<span id="result" ></span><br/><br/>
Password:<input type="text" name="password"/><br/><br/>
Name:<input type="text" name="name"/><br/><br/>
Email:<input type="text" name="email"/> <br/><br/>
<input type="submit" value="submit"/> 
</form>
</body>
</html>