<%@ page import="com.sc.bean.Userinfo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sc.bean.Cars" %><%--
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
    <title>我的购物车</title>
    <style>
        table, td, th {
            border: 1px solid black;
            border-collapse: collapse;
        }

        table {
            text-align: center;
            width: 80%;
            margin: 0 auto;
        }
    </style>
</head>
<body>

<h1 style="text-align: center">

    <%
        Userinfo u = (Userinfo) session.getAttribute("nowuser");
        out.println(u.getName());
    %>
    的购物车！
</h1>
<h2 style="text-align: center">
    <a href="main.jsp">继续购物</a>
</h2>

<table>
    <tr>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>购买数量</th>
        <th>操作</th>
    </tr>
    <%
        List<Cars> list = (List<Cars>) session.getAttribute("carslist");
        for (int i = 0; i < list.size(); i++) {
            Cars cars = list.get(i);
            out.println("<tr>");
            out.println("<td>" + cars.getGid() + "</td>");
            out.println("<td>" + cars.getGname() + "</td>");
            out.println("<td>" + cars.getGprice() + "</td>");
            out.println("<td>" + cars.getGnum() + "</td>");
            out.println("<td></td>");
            out.println("</tr>");
        }
    %>
</table>

</body>
</html>
