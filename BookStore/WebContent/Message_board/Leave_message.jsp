<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="connectDB.Message"  %>
 <%@ page import="java.util.Random" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
             <center>
             <form action="MessageServlet" method="post" >
             留言：
             <br>
             <textarea name="leave_message" rows="10" cols="40"></textarea>
             <br>
             <input type="submit" value="提交">
             </form>
             </center>
             <hr>
               <%
             
            Message a=new Message();
            a.show_context();
            int count=a.Get_context_number();
            if(count>0)
            {
            	for(int i=0;i<count;i++)
            	{ 	
            	 out.print(a.Get_time().get(count-i-1)+"  "+a.Get_username().get(count-i-1));
            	 %><hr><%
                 out.print(a.Get_context().get(count-i-1));
                 %><hr><%
                }
            }
            %>
</body>
</html>