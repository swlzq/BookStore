<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>还未登录</title>
</head>
<body>
<%if(session.getAttribute("login_name")!=null) {%>
		<script type="text/javascript" language="javascript">window.location="../Personal_center/personal_frame.jsp"; 
		</script>	 
		<%} else{%>
		
		
<script type="text/javascript" language="javascript">
		alert("请登录!");                                            // 弹出错误信息
		window.location="Home_iframe.jsp";                            // 跳转到登录界面
	</script>	
	<%} %>
</body>
</html>