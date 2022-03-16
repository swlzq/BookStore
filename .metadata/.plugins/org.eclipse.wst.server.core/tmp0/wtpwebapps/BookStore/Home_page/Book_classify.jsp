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
      <%request.setCharacterEncoding("utf-8");
      String GetThisKindsBook=request.getParameter("GetThisKindsBook") ;
      String KeyWords=request.getParameter("lookup");
      String CurrentPosition="";
      //System.out.println(KeyWords);
      Book a=new Book();
      if(KeyWords!=null)
      {
    	  a.specify_book_bykeyword(KeyWords);
    	  CurrentPosition=KeyWords+" 的查询结果：";
      }
      else
      {
      
        a.specify_book_bykinds(GetThisKindsBook);
        CurrentPosition="当前位置："+GetThisKindsBook;
      }
      
        %>
        <h3><%=CurrentPosition %></h3>
         <table width="80%" align="center">
      <tr>
        <%
        if(a.get_booknumber()==0)
        {
        	out.print("目前尚无此类书籍，欢迎留言添加！");
        }
        else
        {
        for(int i=0;i<a.get_booknumber();i++)
        {
        	if(i%4==0)
        		%><tr><%
            session.setAttribute("bookname",a.get_bookname().get(i));%>
        <td align="center"><a href="BookAdvice_detail.jsp?thisbookname=<%=a.get_bookname().get(i)%>">
        <img src="<%=a.get_bookURL().get(i) %>" width=200px></a>
        <p align="center"><%=a.get_bookname().get(i) %></p>
        <p align="center">￥<%=a.get_bookprice().get(i) %></p></td>
        <%}
        }%>
        </tr>
       </table>
</body>
</html>