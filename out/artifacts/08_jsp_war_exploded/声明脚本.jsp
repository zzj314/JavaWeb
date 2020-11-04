<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-09
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!
        private Integer id;
        private String name;
        private static Map<String ,Object> map;
    %>
    <%!
        static {
            map = new HashMap<String,Object>();
            map.put("key1", "value1");
            map.put("key2", "value2");
            map.put("key3", "value3");
        }
    %>
    <%!
        public int abc(){
            return 12;
        }
    %>
</body>
</html>
