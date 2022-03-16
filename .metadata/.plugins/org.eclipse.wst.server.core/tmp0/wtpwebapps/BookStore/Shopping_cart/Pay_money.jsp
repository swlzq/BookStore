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
            <%request.setCharacterEncoding("utf-8");
            Order a=new Order();
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss"); 
            java.util.Date currentTime = new java.util.Date(); 
            String time = simpleDateFormat.format(currentTime).toString();  
            int n=(int)session.getAttribute("buy_number"); 
            String Username=(String)session.getAttribute("login_name");
            String address=request.getParameter("addr");
            double []money=new double[n];
                for(int i=0;i<n;i++)
           {
           String aaaa=(String)session.getAttribute("tempgood"+i);
           String []splittemp1=aaaa.split("--");
           money[i]=Double.parseDouble(splittemp1[3]);
           double count1=Double.parseDouble(splittemp1[1]);
           int count2=Integer.parseInt(splittemp1[2]);
           a.add_Order(Username,address , time,splittemp1[0] , count1,count2 ,"已支付");
         
           }
                
             double totalmoney=0;
             for(int k=0;k<n;k++)
            	 totalmoney+=money[k];
           %>
           
            <center><h2>扫码支付</h2>
            <p>合计：<%=totalmoney %>元</p>
            <img src="../image/payme.png" width="400px">
            </center>
</body>
</html>