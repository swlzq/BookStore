<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="connectDB.Alter_imformation" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<script type="text/javascript">
function insert_address()
{
var table = document.getElementById("address_table");    
<%
Alter_imformation a=new Alter_imformation();
String user=(String)session.getAttribute("login_name");
a.getuser(user);
int count=a.getaddress().size();
for(int i=0;i<count;i++)
	{
	%>
oneRow = table.insertRow();//插入一行  
cell1=oneRow.insertCell(); 
cell2=oneRow.insertCell();
var a1="<%=a.getaddress().get(i)%>";
cell1.innerHTML =a1;  
cell2.innerHTML="<input type='checkbox' name='choose_address' value='<%=a.getaddress().get(i)%>'>";
   <%}%> 
   
}

</script>
<body onload="insert_address()">
<a href="javascript:history.back(-1)">返回上一页</a>
<form name="form_address"  action="AddressServlet"  method="post" >
      <input type="text" name="address" style="width:80%">
      <input type="submit" value="添加收获地址" name="add_address" style="float:right">
</form>
<br>
<form name="del_address" action="AddressServlet" method="post">
<table width="100%"   id="address_table" border="1" cellspacing="0">  
      <tr><th style="border:none">当前收货地址</th>
      </tr>      
</table>
<input type="submit" value="删除所选地址" name="del_address" style="float:right">
</form>

</body>
</html>