<%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-10
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key", "值");
    %>
    表达式脚本输出：
    <%=request.getAttribute("key1")%><br>
    EL:
    ${key1}
</body>
</html>
