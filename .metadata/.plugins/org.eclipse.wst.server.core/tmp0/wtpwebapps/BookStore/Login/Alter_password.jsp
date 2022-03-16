<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="connectDB.Judge_login" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<script type="text/javascript">
function alterpassword()
{
if(document.form_password.newpassword.value=="")
	{
	 window.alert(" 密码不能为空！");
     return false;
	}
if(form_password.newpassword.value!=form_password.againnew.value)
{
	   window.alert("两次输入的密码不同，请重新输入！");
	   return false;
}
	return true;
}
</script>
<body>
            <%Judge_login a=new Judge_login();
             request.setCharacterEncoding("utf-8");
             a.Get_question((String)session.getAttribute("altername"));
             if(a.Question_Answer(a.Get_cur_question(), request.getParameter("confirmanswer")))
             {%>
             <center>
             <form name="form_password" action="AlterPasswordServlet" method="post"  target="_top">
                      请输入新的密码 <input name="newpassword" type="text" >
                       请确认新的密码<input name="againnew" type="password">
                       <input type="submit"  value="确认修改" onclick="return(alterpassword())">
             </form>
             </center>
             <%}
             else
             {%>
            	 <a href="javascript:history.back(-1)">密保答案不正确，返回上一页</a>
            <%}
           %>
</body>
</html>