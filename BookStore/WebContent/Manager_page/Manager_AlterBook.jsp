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
            <%request.setCharacterEncoding("utf-8");
            String altername=request.getParameter("altername"); 
            Book a=new Book();
            a.specify_book(altername);
            %>
            <form action="ManagerAlterBookServlet" method="post">
                       <table align="center">
                                   <tr>
                                          <th>商品名称</th><td><input name="alterthisname" type="text" value="<%=altername%>"></td>
                                   </tr>
                                    <tr>
                                          <th>商品单价（元）</th><td><input name="alterthisprice" type="text" value="<%=a.get_curprice()%>"></td>
                                   </tr>
                                    <tr>
                                          <th>商品分类</th><td><input name="alterthiskinds" type="text" value="<%=a.get_curkinds()%>"></td>
                                   </tr>
                                    <tr>
                                          <th>图片链接</th><td><textarea name="alterthisURL" cols="40" rows="10" ><%=a.get_curURL()%></textarea></td>
                                   </tr>
                                    <tr>
                                          <th>商品简介</th><td><textarea name="alterthisabstract" cols="40" rows="10"><%=a.get_curabstract()%></textarea></td>
                                   </tr>
                                   <tr><td><input type="submit" value="确认修改"></td></tr>
                       </table>
                                  
            </form>
            
</body>
</html>