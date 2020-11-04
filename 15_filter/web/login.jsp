<%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-22
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这是登录页面<br>
<form action="http://localhost:8080/15_filter/loginServlet" method="get">
    用户名：<input type="text" name="username"/><br>
    密码：<input type="password" name="password"/><br>
    <input type="submit"/>
</form>
</body>
</html>
