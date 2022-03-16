<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<center>
             <h2>选择该订单状态</h2>
             <br><br>
             <form action="ManagerAlterOrderServlet" method="post">
            <select name="alterstate" style="font-size:30px">
                         <option>待付款</option>
                         <option>待发货</option>
                         <option>待收获</option>
                         <option>待评价</option>
            </select>
            <%
            session.setAttribute("thisid", request.getParameter("thisid")); 
            %>
            <input type="submit" value="确定修改">
            </form>
            </center>
</body>
</html>