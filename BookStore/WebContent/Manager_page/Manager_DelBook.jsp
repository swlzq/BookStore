<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="connectDB.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body >
<form name="form_insertbook"  action="ManagerDelBookServlet"  method="post" >
      
<table width="80%"   id="tad" border="1" cellspacing="0" align="center">  
      <tr><th>商品名称</th><th>商品单价(元)</th><th>商品分类</th><th>图片链接</th><th>商品简介</th>
      </tr>      
      <%Book a=new Book();
      a.show_book();
      int n=a.get_booknumber(); 
      for(int i=0;i<n;i++)
      {%>
      <tr><td><%=a.get_bookname().get(i) %></td><td ><%=a.get_bookprice().get(i) %></td>
             <td><%=a.get_bookkinds().get(i)%></td>
            <td ><%=a.get_bookURL().get(i) %></td><td ><%=a.get_bookabstract().get(i) %></td>
            
            <%String str1=a.get_bookname().get(i); 
              str1=java.net.URLEncoder.encode(str1,"utf-8");
          %>
            <td><a href="Manager_AlterBook.jsp?altername=<%=str1%>"> 修改</a></td>
            <td><input type="checkbox" name="choosebook"  value="<%=a.get_bookname().get(i) %>"></td>
      </tr>
      <%} %>
</table>
<input type="submit" value="删除所选图书" style="float:right">
</form>

</body>
</html>