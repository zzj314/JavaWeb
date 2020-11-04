<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-10
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%

            //1、值为null的时候
            request.setAttribute("emptyNull",null);
           // 2、值为""
            request.setAttribute("emptyStr", "");
            //3、数组，长度0
            request.setAttribute("emptyArr", new Object[]{});
            //4、list集合
            List<String > list = new ArrayList<>();
            request.setAttribute("emptyList", list);
           // 5、map集合
            Map map = new HashMap<String,Object>();
            request.setAttribute("emptyMap", map);
    %>

    ${empty emptyNull}<br>
    ${empty emptyStr}<br>
    ${empty emptyArr}<br>
    ${empty emptyList}<br>
    ${empty emptyMap}<br>
</body>
</html>
