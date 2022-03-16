<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="connectDB.Book_kinds" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
            <form action="ManagerKindsServlet" method="post">
            <center><h2>当前分类</h2></center><br>
                       <table align="center">
            <%Book_kinds a=new Book_kinds();
            a.show_bookkinds();
            int n=a.get_kindsnumber();
            for(int i=0;i<n;i++)
            {%>
                   <tr>
                         <td align="center"><%=a.get_allbookkinds().get(i)%></td>
                         <td><input name="choosekinds" type="checkbox" value="<%=a.get_allbookkinds().get(i) %>"></td>
                   </tr>
            <%} %>
                   <tr>
                         <td></td>
                         <td><input type="submit" value="移除所选分类" name="del_kinds"></td>
                   </tr>
                   <tr>
                         <td style="height:100px"><input type="text" name="addthiskinds"></td>
                         <td style="height:100px"><input type="submit" value="添加分类" name="add_kinds"></td>
                   </tr>
                        </table>
                        
            </form>
</body>
</html>