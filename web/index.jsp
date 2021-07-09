<%--
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
    <title>$Title$</title>
</head>
<body>
$END$
</body>
</html>
