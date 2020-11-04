<%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-11
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key1", "pageContext");
        pageContext.setAttribute("key2", "pageContext2");

        request.setAttribute("key2", "request");
        session.setAttribute("key2", "session");
        application.setAttribute("key2", "application");
    %>
    21   <br>
        ${key2}<br>
</body>
</html>
