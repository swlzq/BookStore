<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ page import="connectDB.Manager_operate" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<script type="text/javascript">
function insert()
{
var table = document.getElementById("tad");    
<% Manager_operate a=new Manager_operate();
a.get_userimformation();
int count=0;
int n=a.getuser_number();
System.out.print(n);
for(int i=0;i<n;i++)
	{
	%>

oneRow = table.insertRow();//插入一行  
cell1=oneRow.insertCell(); 
cell2=oneRow.insertCell();  
cell3=oneRow.insertCell();
cell4=oneRow.insertCell();
cell5=oneRow.insertCell();
cell6=oneRow.insertCell();
cell7=oneRow.insertCell();
var a1="<%=a.getname().get(count)%>";
var a2="<%=a.getpassword().get(count)%>";
var a3="<%=a.getnickname().get(count)%>";
var a4="<%=a.getsex().get(count)%>";
var a5="<%=a.getemail().get(count)%>";
var a6="<%=a.getaddress().get(count)%>";
cell1.innerHTML = a1;
cell2.innerHTML = a2;  
cell3.innerHTML = a3;
cell4.innerHTML = a4;  
cell5.innerHTML = a5;  
cell6.innerHTML = a6; 
cell7.innerHTML = "<input type='checkbox' name='user' value='<%=a.getname().get(count)%>'>";
	<%count++;}%>
}

</script>
<body onload="insert()">
<form name="form_user"  action="ManageServlet"  method="post" >
      <input type="submit" value="删除所选用户" style="float:right">
<table width="100%"   id="tad" border="1" cellspacing="0">  
      <tr><th>账号</th><th>密码</th><th>昵称</th><th>性别</th><th>邮箱</th><th>地址</th> 
      </tr>      
</table>
</form>

</body>
</html>