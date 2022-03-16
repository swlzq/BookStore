<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="connectDB.Alter_imformation" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
      <%Alter_imformation a=new Alter_imformation();
      String user=(String)session.getAttribute("login_name");
      System.out.print(user+"!!!");
      a.getuser(user);
      String check1="";
      String check2="";
      String check3="";
      String check="";
      if(a.getsex().equals("male"))
    	  check1="checked";
      else if(a.getsex().equals("female"))
    	  check2="checked";
      else if(a.getsex().equals("gay"))
    	  check3="checked";
      else check="no";
      %>
	<center>
		<form action="PersonalServlet" style="font-family: 楷体" method="post">
			昵称<input name="nickname" type="text" value="<%=a.getnickname()%>"> <br>
			<%if(check1.equals("checked")) {%>
			<br> <br> <input name="sex" type="radio" value="male" checked="checked">男神
			<input name="sex" type="radio" value="female" >女神 <input
				name="sex" type="radio" value="gay">其他 <br> <br>
	        <%} %>
	        <%if(check2.equals("checked")) {%>
			<br> <br> <input name="sex" type="radio" value="male" >男神
			<input name="sex" type="radio" value="female" checked="checked">女神 <input
				name="sex" type="radio" value="gay">其他 <br> <br>
	        <%} %>
	        <%if(check3.equals("checked")) {%>
			<br> <br> <input name="sex" type="radio" value="male" >男神
			<input name="sex" type="radio" value="female" >女神 <input
				name="sex" type="radio" value="gay" checked="checked">其他 <br> <br>
	        <%} %>
	         <%if(check.equals("no")) {%>
			<br> <br> <input name="sex" type="radio" value="male" >男神
			<input name="sex" type="radio" value="female">女神 <input
				name="sex" type="radio" value="gay">其他 <br> <br>
	        <%} %>
			<input type="submit" value="保存">
		</form>
	</center>
</body>
</html>