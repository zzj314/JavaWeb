<%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-22
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("a.jsp执行了");
    Object user = session.getAttribute("user");
    //如果等于null，说明还没有登录
    if (user == null){
        request.getRequestDispatcher("/login.jsp").forward(request, response);
        return;
    }
%>
我是jsp文件
</body>
</html>
