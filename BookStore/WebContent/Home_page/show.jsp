<%@ page contentType="text/html; charset=utf-8" %> 
<%@ page import="java.io.*"%> 
<%@ page import="java.sql.*, javax.sql.*" %> 
<%@ page import="java.util.*"%> 
<%@ page import="java.math.*"%> 
<%@ page import="connectDB.ConnectDB" %>
<% 
// 准备语句执行对象
String bookname=(String)session.getAttribute("bookname");
ConnectDB a=new ConnectDB();
Statement stmt = a.con.createStatement(); 
String sql = " SELECT * FROM book WHERE name = '"+bookname+"'"; 
ResultSet rs = stmt.executeQuery(sql); 
if (rs.next()) { 
Blob b = rs.getBlob("image"); 
long size = b.length(); 
//out.print(size); 
byte[] bs = b.getBytes(1, (int)size); 
response.setContentType("image/jpeg"); 
OutputStream outs = response.getOutputStream(); 
outs.write(bs); 
outs.flush(); 
rs.close(); 
out.clear();  
out = pageContext.pushBody();  
} 

else { 
rs.close(); 
response.sendRedirect("./images/error.gif"); 
}  
%> 
