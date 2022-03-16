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
            <form action="ManagerAddBookServlet" method="post">
                       <table align="center">
                                   <tr>
                                          <td>书的名称：</td>
                                          <td><input name="addname" type="text"></td>
                                   </tr>
                                   <tr>
                                          <td>书的作者</td>
                                          <td><input name=addauthor type="text"></td>
                                   </tr>
                                   <tr>
                                          <td>书的单价(元)：</td>
                                          <td><input name="addprice" type="text"></td>
                                   </tr>
                                   <tr>
                                           <td>分类</td>
                                           <td>
                                                  <select name="addkinds">
                                                  <%Book_kinds a=new Book_kinds();
                                                  a.show_bookkinds();
                                                  int count=a.get_kindsnumber();
                                                  for(int i=0;i<count;i++)
                                                  {%>
                                                                <option value="<%=a.get_allbookkinds().get(i)%>"><%=a.get_allbookkinds().get(i)%></option>
                                                   <%} %>
                                                   <option value="其它">其它</option>
                                                  </select>
                                           </td>
                                   </tr>
                                   <tr>
                                          <td>图片链接：</td>
                                          <td><input name="addURL" type="text"></td>
                                   </tr>
                                   <tr>
                                           <td style="">书的简介：</td>
                                           <td><textarea name="addabstract"></textarea></td>
                                   </tr>    
                                    <tr>
                                           <td><a href="http://photo.weibo.com/2932652790">上传图片：</a></td>  
                                             <td style="float:right"><input type="submit" value="添加图书"></td>
                                   </tr>
                             
                                        

                       </table>
            </form>
</body>
</html>