
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>浪翼的小书屋</title>
</head>
<script type="text/javascript">
       function userCheck()
       {
    	   if(form_register.username.value=="")
    	   {
    	       window.alert("用户名不能为空！");
    	       return false;
    	   }
    	   if(form_register.password.value=="")
		   {
		       window.alert("密码不能为空！");
		       return false;
		   }
    	   if(form_register.again_password.value=="")
		   {
		       window.alert("请确认密码！");
		       return false;
		   }
    	   if(form_register.email.value=="")
		   {
		       window.alert("邮箱不能为空！");
		       return false;
		   }
    	   var target=document.getElementsByTagName("option")[0];
    	       if(target.selected)
    	    	   {
    	    	   window.alert("请选择一个邮箱域名！");
    	    	   return false;
    	    	   }
    	   if(form_register.password.value!=form_register.again_password.value)
    	   {
    		   window.alert("两次输入的密码不同，请重新输入！");
    		   return false;
    	   }
    	   
    	   if(form_register.question.value=="")
		   {
		       window.alert("密保问题不能为空！");
		       return false;
		   }
    	   if(form_register.answer.value=="")
		   {
		       window.alert("密保答案不能为空！");
		       return false;
		   }
    	   
    	   return true;
       }
</script>
<body>
	<center>
		<h3 style="font-family: 楷体">新用户注册</h3>
		<form action="RegisterServlet" target="_top" name="form_register" method="post"
			onsubmit="return userCheck()">
			<table border="0" style="font-family: 楷体">
				<tr>
					<td>用户名</td>
					<td><input name="username" type="text" size=20> <font
						color="red">*</font></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input name="password" type="password" size=20> <font
						color="red">*</font></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input name="again_password" type="password" size=20>
						<font color="red">*</font></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><input name="email" type="text" size=20> <select
						name="email2" style="font-family: 楷体">
							<option>--请选择邮箱域名--</option>
							<option>@qq.com</option>
							<option>@163.com</option>
							<option>@126.com</option>
							<option>@sina.com</option>
							<option>@sina.cn</option>
							<option>@yahoo.com.cn</option>
							<option>@gmail.com</option>
							<option>@sohu.com</option>
							<option>@hotmail.com</option>
					</select> <font color="red">*</font></td>
				</tr>
				<tr>
					<td>设置密保问题</td>
					<td><input name="question" type="text" size=20>
						<font color="red">*</font></td>
				</tr>
				<tr>
					<td>设置密保答案</td>
					<td><input name="answer" type="text" size=20>
						<font color="red">*</font></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="注册"></td>
				</tr>
				<tr>
					<td></td>
					<td>注意：<font color="red">*</font>为必填
					</td>
				</tr>
			</table>

		</form>
	</center>

</body>
</html>
