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
    <title>商品添加</title>
    <style>
        table, td, th {
            border: 1px solid black;
            border-collapse: collapse;
        }

        table {
            text-align: center;
            width: 50%;
            margin: 0 auto;
        }
    </style>
</head>
<body>

<h1 style="text-align: center">
    商品添加
</h1>
<h2 style="text-align: center">
    <a href="GoodsSelect">返回</a>
</h2>

<form action="GoodsAdd" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>商品名称：</td>
            <td style="text-align: left">
                <input type="text" name="gname" placeholder="请输入商品名称">
            </td>
        </tr>
        <tr>
            <td>商品价格：</td>
            <td style="text-align: left">
                <input type="text" name="gprice" placeholder="请输入商品价格">
            </td>
        </tr>
        <tr>
            <td>库存数量：</td>
            <td style="text-align: left">
                <input type="text" name="gstock" placeholder="请输入库存数量">
            </td>
        </tr>
        <tr>
            <td>商品图片：</td>
            <td style="text-align: left">
                <%--添加文件上传控件--%>
                <input type="file" name="upload" placeholder="请选择商品图片">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
