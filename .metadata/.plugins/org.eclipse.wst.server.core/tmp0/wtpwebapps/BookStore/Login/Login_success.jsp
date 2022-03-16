<%@ page import="connectDB.Judge_login"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<table border="0"  style="font-family: 楷体 ;position:absolute;top:100px">
		<%
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"); 
            java.util.Date currentTime = new java.util.Date(); 
            String time = simpleDateFormat.format(currentTime).toString();  
            %>
		<tr>
			<td align="center" style="border: none;">欢迎你</td>
		</tr>
		<tr><td align="center" style="border:none;font-size:30pt;color:red"><%=session.getAttribute("login_name")%></td></tr>
		<tr>
			<td align="center" style="border: none;"><%=time %></td>
		</tr>
	</table>
</body>
</html>