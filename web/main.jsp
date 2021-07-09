<%@ page import="com.sc.bean.Userinfo" %><%--
  Created by ChenLong.
  User: ChenLong
  Date: 2021/6/8
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <base href="<%=basePath %>"/>
    <title>商城主页</title>
    <style>
        div {
            float: left;
            width: 24%;
            border: 1px solid aliceblue;
            margin: 1px;
            padding: 1px;
        }
    </style>
</head>
<body>

<%
    //模拟当前登录的用户信息123
    Userinfo userinfo = new Userinfo(1, "张三", "123", "女");
    session.setAttribute("nowuser", userinfo);//用户对象存入session
%>

<h1 style="text-align: center">
    欢迎，
    <%
        Userinfo u = (Userinfo) session.getAttribute("nowuser");
        out.println(u.getName());
    %>
    ，来到我的商城！
</h1>
<h2 style="text-align: center">
    <a href="cars.jsp">我的购物车</a>
</h2>
<h2 style="text-align: center">
    <a href="GoodsSelect">商品管理-后台</a>
</h2>

<div>
    名称：羽绒服00
    <br>
    价格：68.00
    <br>
    库存：700
    <br>
    <a href="CarsAdd?gid=2">加入购物车</a>
</div>
<div>
    名称：牛仔裤
    <br>
    价格：38.00
    <br>
    库存：100
    <br>
    <a href="CarsAdd?gid=3">加入购物车</a>
</div>
<div>
    名称：保暖裤
    <br>
    价格：58.99
    <br>
    库存：100
    <br>
    <a href="CarsAdd?gid=4">加入购物车</a>
</div>
<div>
    名称：裙子
    <br>
    价格：3000.00
    <br>
    库存：333
    <br>
    <a href="CarsAdd?gid=5">加入购物车</a>
</div>
</body>
</html>
