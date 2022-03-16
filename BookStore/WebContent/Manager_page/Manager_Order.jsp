<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="connectDB.Order" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<form action="ManagerOrderServlet" method="post">
              <table align="center" border="1" cellspacing="0">
              <tr>
                     <th>订单号</th><th>用户名</th><th>商品名称</th><th>商品单价(元)</th><th>商品数量</th><th>收获地址</th>
                     <th>交易时间</th><th>订单状态</th>
              </tr>
             <%Order a=new Order();
             a.show_order();
             int count=a.get_order_number();
             for(int i=0;i<count;i++)
             {%>
                    <tr><td><%=a.get_orderid().get(i) %></td>
                           <td><%=a.get_orderusername().get(i) %></td>
                           <td><%=a.get_ordergoods().get(i) %></td>
                           <td><%=a.get_orderprice().get(i) %></td>
                           <td><%=a.get_ordernumber().get(i) %></td>
                           <td><%=a.get_orderaddress().get(i) %></td>
                           <td><%=a.get_ordertime().get(i) %></td>
                           <td><%=a.get_orderstate().get(i) %></td>
                           <td><a href="Manager_AlterOrder.jsp?thisid=<%=a.get_orderid().get(i)%>">修改此订单状态</a></td>
                           <td><input type="checkbox" name="chooseOrder" value="<%=a.get_orderid().get(i)%>"></td>
                       </tr>
             <%} %>
             </table>
             <input type="submit" value="删除所选订单" style="float:right">
</form>
</body>
</html>