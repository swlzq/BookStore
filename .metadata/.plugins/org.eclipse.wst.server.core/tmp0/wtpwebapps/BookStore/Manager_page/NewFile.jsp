<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ page import="connectDB.Book" %>
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
<% Book a=new Book();
a.show_book();
int count=0;
int n=a.get_booknumber();
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
var a1="<%=a.get_bookname().get(count)%>";
var a2="<%=a.get_bookprice().get(count)%>";
var a3="<%=a.get_bookabstract().get(count)%>";
var a4="<%=a.get_bookURL().get(count)%>";
cell1.innerHTML = a1;
cell2.innerHTML = a2;  
cell3.innerHTML = a3;
cell4.innerHTML = a4;  
cell5.innerHTML = "<input type='checkbox' name='user' value='<%=a.get_bookname().get(count)%>'>";
	<%count++;}%>
}

</script>
<body onload="insert()">
<form name="form_user"  action="ManageServlet"  method="post" >
      <input type="submit" value="删除所选用户">
<table width="100%"   id="tad" border="1" cellspacing="0">  
      <tr><th>账号</th><th>密码</th><th>昵称</th><th>性别</th><th><%=a.get_bookname().get(1) %></th><th></th>
      </tr>      
      
</table>
</form>

</body>
</html>