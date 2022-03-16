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
<a href="../Home_page/Home_iframe.jsp">回到主页</a>
	<form name="form_login" method="post" action="ManagerLoginServlet">
		<h2 style="font-family: 楷体; font-size: 30px" align="center">管理员登录</h2>
		<table border="0" style="font-family: 楷体" align="center">
			<tr>
				<td>用户名</td>
			</tr>
			<tr>
				<td><input name=username type="text" size=20
					style="height: 20px"></td>
			</tr>

			<tr>
				<td>密 码</td>
			</tr>
			<tr>
				<td><input name=password type="password" size=20
					style="height: 20px"></td>
			</tr>

			<tr>
				<td align="right" height=20px><input type="submit" value="登录"
					style="font-family: 楷体"> <a href="../Find_password.jsp">忘记密码</a>
				</td>
			</tr>
			<%if(session.getAttribute("ifmsuccess")=="no") 
                   {%>
			<tr>
				<td>用户名或密码错误！</td>
			</tr>
			<%session.setAttribute("ifmsuccess","yes");
                    } %>
		</table>

	</form>

</body>
</html>