<%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-09
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    pageContext3域：<%=pageContext.getAttribute("key")%><br>
    request3域：<%=request.getAttribute("key")%><br>
    session2域：<%=session.getAttribute("key")%><br>
    application2域：<%=application.getAttribute("key")%><br>

</body>
</html>
