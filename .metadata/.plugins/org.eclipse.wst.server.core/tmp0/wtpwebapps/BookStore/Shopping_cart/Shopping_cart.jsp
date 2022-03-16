<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="connectDB.Shopping_cart" %>
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
<%String user=(String)session.getAttribute("login_name");
Shopping_cart a=new Shopping_cart();
a.get_goodsmessage(user);
int n=a.getkinds_number();
//System.out.print(n);
for(int i=0;i<n;i++)
	{
	%>

oneRow = table.insertRow();//插入一行  
cell1=oneRow.insertCell(); 
cell2=oneRow.insertCell();  
cell3=oneRow.insertCell();
cell4=oneRow.insertCell();
cell5=oneRow.insertCell();
var a1="<%=a.getgoods().get(i)%>";
var a2="<%=a.getprice().get(i)%>";
var a3="<%=a.getnumber().get(i)%>";
var a4="<%=a.gettotalprice().get(i)%>";
cell1.innerHTML = a1;
cell2.innerHTML = a2;  
cell3.innerHTML = a3;
cell4.innerHTML = a4;
cell5.innerHTML = "<input type='checkbox' name='shopping' value='<%=a.getgoods().get(i)%>'>";
<%}%>
}
</script>
<body onload="insert()">
<form name="form_shopping"  action="ShoppingcartServlet"  method="post" >
     
<table width="100%"   id="tad" border="1" cellspacing="0">  
      <tr><th>商品名称</th><th>商品价格</th><th>商品数量</th><th>总价</th>
      </tr>      
</table>
 <input type="submit" name="del_goods" value="删除所选商品" style="float:right">
 <input type="submit" name="buy_goods" value="购买所选商品" style="float:right">
</form>
</body>
</html>