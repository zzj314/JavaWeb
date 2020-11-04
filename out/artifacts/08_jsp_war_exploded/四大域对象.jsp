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
    <%
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>
        pageContext域：<%=pageContext.getAttribute("key")%><br>
        request域：<%=request.getAttribute("key")%><br>
        session域：<%=session.getAttribute("key")%><br>
        application域：<%=application.getAttribute("key")%><br>
    <%
      //  request.getRequestDispatcher("/四大域对象2.jsp").forward(request, response);
    %>
<%--    现在也可以永标签实现--%>
    <jsp:forward page="/四大域对象3.jsp"></jsp:forward>
</body>
</html>
