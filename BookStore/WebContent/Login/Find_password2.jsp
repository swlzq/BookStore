<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="connectDB.Judge_login" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
             <%Judge_login a=new Judge_login();
             request.setCharacterEncoding("utf-8");
             String findname=request.getParameter("findname");
             String findemail=request.getParameter("findemail");
             if(a.FindPassword(findname, findemail))
             {
                    a.Get_question(findname);
                  %>  
                  <center>
                  <%=a.Get_cur_question()%>?
                  <%session.setAttribute("altername",findname); %>
                  <form action="Alter_password.jsp">
                  <input type="text" name="confirmanswer">
                  <input type="submit" value="确认">
                  </form>
                  </center>
             <%} 
             else{
             session.setAttribute("ifpass","no");
             response.sendRedirect("Find_password.jsp");
            } %>
</body>
</html>