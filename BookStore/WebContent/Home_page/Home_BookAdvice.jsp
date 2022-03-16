<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="connectDB.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

</head>
<body>
<h2 style="color:red">热门推荐：</h2>
      <table width="80%" align="center">
      <tr>
      <%
        Book a=new Book();
        a.specify_book_byrecommend();
        for(int i=0;i<a.get_booknumber();i++)
        {
        	if(i%4==0)
        		%><tr><%
            session.setAttribute("bookname",a.get_bookname().get(i));%>
        <td align="center"><a href="BookAdvice_detail.jsp?thisbookname=<%=a.get_bookname().get(i)%>">
        <img src="<%=a.get_bookURL().get(i) %>" width=200px></a>
        <p align="center"><%=a.get_bookname().get(i) %></p>
        <p align="center">￥<%=a.get_bookprice().get(i) %></p></td>
        <%} %>
        </tr>
       </table>
</body>
</html>