<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
            <form action="Find_password2.jsp" method="post">
                                <center><h2>填写你的个人信息</h2></center>
                       <table align="center">
                                    <tr>
                                          <td>用户名</td><td><input type="text" name="findname" ></td>
                                    </tr>
                                    <tr>
                                            <td>邮箱</td><td><input type="text" name="findemail"></td>
                                    </tr>
                                    <tr>
                                           <td></td><td><input type="submit" value="确认" ></td>
                                    </tr>
                                    	<%if(session.getAttribute("ifpass")=="no"){%>
		     <tr><td></td><td>用户名或邮箱错误！</td>
		     </tr>
		     <%session.setAttribute("ifpass", "yes");} %>
                       </table>
            </form>
</body>
</html>