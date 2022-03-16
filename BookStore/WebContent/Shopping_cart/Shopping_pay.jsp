<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="connectDB.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>完善购物订单</title>
</head>
</head>
<script type="text/javascript">
       function buyCheck()
       {
    	   if(buysomething.people.value=="")
    	   {
    	       window.alert("收货人不能为空！");
    	       return false;
    	   }
    	   if(buysomething.addr.value=="")
		   {
		       window.alert("收获地址不能为空！");
		       return false;
		   }
    	   return true;
       }
</script>
<body>
<form name="buysomething"  action="Pay_money.jsp" method="post">
<h2 align="center">确认购买信息</h2>
      <table border="1" cellspacing="0" align="center">
              <tr>
              <td> 收货人：</td>
              <td><input type="text" name="people" value=<%=session.getAttribute("login_name") %>></td>
              </tr>
              <tr>
                <td> 收货地址：</td><td><select name="addr">
           <%Alter_imformation a=new Alter_imformation();
           String user=(String)session.getAttribute("login_name");
           a.getuser(user);
           int count=a.getaddress().size(); 
           for(int i=0;i<count;i++)
           {%>
           <option value=<%=a.getaddress().get(i) %>><%=a.getaddress().get(i) %></option>
           <%} %>
           </select>
           </td>
          </tr>
           <tr><td></td><td><a href="../Personal_center/alter_address.jsp">添加收货地址</a></td></tr>
          
          <tr><th> 订单信息：</th></tr>
           
           <tr><td>商品名称</td><td>商品单价（元）</td><td>商品数量(个)</td><td>商品总价（元）</td></tr>
           <%int n=(int)session.getAttribute("buy_number"); 
           
           for(int j=0;j<n;j++)
           {
           String aaa=(String)session.getAttribute("tempgood"+j);
           String []splittemp=aaa.split("--");
           out.println("<tr><td>");
           out.println(splittemp[0]);
           out.println("</td><td>");
           out.println(splittemp[1]);
           out.println("</td><td>");
           out.println(splittemp[2]);
           out.println("</td><td>");
           out.println(splittemp[3]);
           out.println("</td></tr>");
           } %>
           </table>
          <center> <input type="submit" value="确认购买" onclick="return(buyCheck())"></center>
</form>
</body>
</html>