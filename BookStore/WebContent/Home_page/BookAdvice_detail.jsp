<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@page import="connectDB.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<a href="javascript:history.back(-1)">返回上一页</a>
<center>
<form action="BookServlet" method="post">
<%
if(request.getParameter("thisbookname")!=null)
session.setAttribute("bookname",(String)request.getParameter("thisbookname"));
else
	session.setAttribute("bookname",(String)session.getAttribute("bookname1"));
String booknamethis=(String)session.getAttribute("bookname");
Book a=new Book();
a.specify_book(booknamethis);
%>
<img src="<%=a.get_curURL() %>" width=200px>
<p>[作者]<%=a.get_curauthor() %></p>
<p>￥<%=a.get_curprice() %></p>
<br>
<p><%=a.get_curabstract() %></p>
<br>
数量<input type="text" name="cur_number">
<input type="submit" value="加入购物车" >
</form>
</center>
</body>
</html>