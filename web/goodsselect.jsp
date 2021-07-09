<%@ page import="com.sc.bean.Userinfo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sc.bean.Cars" %>
<%@ page import="com.sc.bean.Goods" %><%--
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
    <title>商品管理</title>
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
    商品列表
</h1>
<h2 style="text-align: center">
    <a href="goodsadd.jsp">添加商品</a>
</h2>

<table>
    <tr>
        <th>商品编号</th>
        <th>商品图片</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>购买数量</th>
        <th>库存数量</th>
        <th>操作</th>
    </tr>
    <%
        List<Goods> list = (List<Goods>) request.getAttribute("goodslist");
        for (int i = 0; i < list.size(); i++) {
            Goods goods = list.get(i);
            out.println("<tr>");
            out.println("<td>" + goods.getGid() + "</td>");
            out.println("<td>");
            out.println("<a href='GoodsDownload?name="+goods.getGimg()+"'>");
            out.println("<img src='upload/" + goods.getGimg() + "' width='60px' height='40px'>");
            out.println("</a>");
            out.println("</td>");
            out.println("<td>" + goods.getGname() + "</td>");
            out.println("<td>" + goods.getGprice() + "</td>");
            out.println("<td>" + goods.getGnum() + "</td>");
            out.println("<td>" + goods.getGstock() + "</td>");
            out.println("<td>");
            out.println("<a href='GoodsGoUpdate?gid=" + goods.getGid() + "' onclick='return window.confirm(\"是否确定修改？\")'>修改</a>");
            out.println("/<a href='GoodDel?gid=" + goods.getGid() + "' onclick='return window.confirm(\"是否确定删除？\")'>删除</a>");
            out.println("</td>");
            out.println("</tr>");
        }
    %>
</table>


</body>
</html>
