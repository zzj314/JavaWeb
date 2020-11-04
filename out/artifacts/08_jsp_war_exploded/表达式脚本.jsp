<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-09
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--
    <%=表达式%> :  jsp页面上输出数据
    所有表达式脚本都会被翻译到_jspService()方法中
    表达式脚本都会被翻译成为out.print()输出到页面上
--%>
</head>
<body>
    <%!
        static Map<String,Object> map;
        static {
            map = new HashMap<String,Object>();
            map.put("1", "a");
            map.put("2", "b");
            map.put("3", "c");
        }
    %>

    <%=12%><br>
    <%=12.12%><br>
    <%="字符串"%><br>
    <%=map%><br>
    <%=request.getCookies()%>
</body>
</html>
