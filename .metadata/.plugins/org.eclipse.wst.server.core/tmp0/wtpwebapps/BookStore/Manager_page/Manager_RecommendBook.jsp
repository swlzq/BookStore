<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="connectDB.Book"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
           <form action="ManagerRecommendServlet" method="post">
           <center><h2>当前首页推荐</h2></center>
           <table align="center">
           <%Book a=new Book();
           a.specify_book_byrecommend();
           int count=a.get_booknumber();
           for(int i=0;i<count;i++)
           {%>
                 <tr>
                        <td><%=a.get_bookname().get(i)%></td>
                        <td><input name="chooseR" type="checkbox" value="<%=a.get_bookname().get(i)%>"></td>
                 </tr>
           <%} %>
           <tr>
                         <td></td>
                         <td><input type="submit" value="移除所选推荐" name="del_recommend"></td>
                   </tr>
                   <tr>
                         <td style="height:100px"><input type="text" name="addthisrecommend"></td>
                         <td style="height:100px"><input type="submit" value="添加推荐" name="add_recommend"></td>
                   </tr>
           </table>
           </form>
</body>
</html>