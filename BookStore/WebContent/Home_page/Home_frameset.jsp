<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>浪翼的小书屋</title>
</head>
<frameset border="0" rows="120,*" >
	<frame scrolling="no" src="Navigation.jsp" name="top" />
	<frameset cols="200,*">
		<frameset rows="300,*" >
		    <%String src="../Login/Login_interface.jsp"; 
		       if(session.getAttribute("login_name")!=null)
		       {src="../Login/Login_success.jsp";}%>
			<frame scrolling="no" src="<%=src %>" name="left1" scrolling="no"  style="background-color:cornsilk"/>
			<frame scrolling="no" src="Home_classify.jsp" name="left2" scrolling="no" style="background-color: cornsilk" />
		</frameset>
		<frame scrolling="yes" src="Home_BookAdvice.jsp" name="right" style="background-color:cornsilk"  />
	</frameset>
</frameset>
<body >
</body>
</html>