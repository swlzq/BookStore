<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="connectDB.*"%>
<%@ page import="java.util.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>浪翼的小书屋</title>
</head>

<body>
	<form name="form_login" method="post" action="LoginServlet">
		<h2 style="font-family: 楷体; font-size: 30px" align="center">用户登录</h2>
		<table border="0" style="font-family: 楷体" align="center">
			<tr>
				<td>用户名</td>
			</tr>
			<tr>
				<td><input name=username type="text" 
					style="font-family: 楷体;width:150px;height:20px"></td>
			</tr>

			<tr>
				<td>密 码</td>
			</tr>
			<tr>
				<td><input name=password type="password" 
					style="font-family: 楷体;width:150px;height:20px"></td>
			</tr>

			<tr>
				<td align="center"><input type="submit" value="登录"
					style="font-family: 楷体;width:150px;height:30px;background-color:#0095BB;color:white"> 
				</td>
			</tr>
			<tr><td align="center"><a href="Find_password.jsp" target="_top">忘记密码</a>
			                       <a href="../Register/Register.jsp" target="_top">新用户注册</a></td></tr>
			<%if(session.getAttribute("ifsuccess")=="no"){%>
		     <tr><td>用户名或密码错误！</td>
		     </tr>
		     <%session.setAttribute("ifsuccess", "yes");} %>
		</table>

	</form>

</body>
</html>