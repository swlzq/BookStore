<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ page import="connectDB.Book_kinds"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<form method="post" action="Book_classify.jsp" target="right">
		<center>
			<input name="lookup" type="text"> 
			<input type="submit" value="查询">
		</center>
	</form>
	<table align="center"
		style="font-family: 楷体; border-collapse: separate; border-spacing: 30px; font-size: 80;">
		<%Book_kinds a=new Book_kinds();
		      a.show_bookkinds();
		      int count=a.get_kindsnumber();
		      for(int i=0;i<count;i++)
		      {
		    	  String str=a.get_allbookkinds().get(i);
		    	  str=java.net.URLEncoder.encode(str,"utf-8");
		            if(i%2==0)
		            {%>
		            <tr>
		            <% }%>
		            <td style="width:50px"><a href="Book_classify.jsp?GetThisKindsBook=<%=str%>" target="right"><%=a.get_allbookkinds().get(i) %></a></td>	
		      <%} %>
	</table>

</body>
</html>