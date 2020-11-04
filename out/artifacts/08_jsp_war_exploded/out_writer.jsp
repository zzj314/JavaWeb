<%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-10
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
response输出1
response输出2
1 out输出1
out输出2
--%>
1
    <%
        out.write("out输出1<br/>");
        out.flush();
        out.write("out输出2<br>");
        response.getWriter().write("response输出1<br>");
        response.getWriter().write("response输出2<br>");

    %>
</body>
</html>
