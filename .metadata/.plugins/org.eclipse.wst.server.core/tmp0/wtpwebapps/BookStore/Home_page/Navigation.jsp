<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>浪翼的小书屋</title>
<style>
body, div, ul, li {
	margin: 0;
	padding: 0;
	font-style: normal;
	font: 12px/22px "\5B8B\4F53", Arial, Helvetica, sans-serif
}

ol, ul, li {
	list-style: none
}

img {
	border: 0;
	vertical-align: middle
}

body {
	color: #000000;
	background: #FFF;
	text-align: center
}

.clear {
	clear: both;
	height: 1px;
	width: 100%;
	overflow: hidden;
	margin-top: -1px
}

a {
	color: #000000;
	text-decoration: none
}

a:hover {
	color: #BA2636
}

.red, .red a {
	color: #F00
}

.lan, .lan a {
	color: #1E51A2
}

.pd5 {
	padding-top: 5px
}

.dis {
	display: block
}

.undis {
	display: none
}

ul#nav {
	width: 100%;
	height:120px;
	background-image:url(../image/mmm.jpg);
	background-size:100%;
	background-repeat:no-repeat;
	margin: 0 auto
}

ul#nav li {
	display: inline;
	height: 120px
}

ul#nav li a {
	display: inline-block;
	padding: 0 20px;
	height: 120px;
	line-height: 120px;
	color: #FFF;
	font-family: "\5FAE\8F6F\96C5\9ED1";
	font-size: 16px
}

ul#nav li a:hover {
	background: #e8a171
}
</style>
</head>

<body>
	<ul id="nav">
		<li><a href="Home_iframe.jsp" target="_top">首页</a></li>
		<li><a href="../Shopping_cart/Shopping_frame.jsp" target="_top">我的购物车</a></li>
		<li><a href="../My_order/MyOrder_frame.jsp" target="_top">我的订单</a></li>
		<li><a href="Alert.jsp" target="_top">个人中心</a></li>
		<li><a href="../Manager_page/Manager_login.jsp" target="_top">书屋管理</a></li>
		<li><a href="../Message_board/Message_frameset.jsp" target="_top">给浪翼留言</a></li>
		<li><a href="../Login/off_login.jsp" target="_top">退出登录</a></li>
	</ul>
</body>
</html>