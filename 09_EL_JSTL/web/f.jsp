<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-10
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Map<String ,Object> map = new HashMap<String ,Object>();
        map.put("a-a-a", "aaskfdll");
        request.setAttribute("map",map);
    %>
    1
    ${map["a-a-a"]}
</body>
</html>
