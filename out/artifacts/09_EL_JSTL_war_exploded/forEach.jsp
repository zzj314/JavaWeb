<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.guigu.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-13
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            border-collapse: collapse;
            border:1px solid red;
            width: 500px;
        }
        th,td{
            border: 1px solid red;
        }
    </style>
</head>
<body>

<%--    <c:forEach begin="1" end="10" var="i">--%>
<%--        <tr>--%>
<%--            <td>第${i}行</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--        <%--%>
<%--           request.setAttribute("attr", new String[]{"1","2","3"});--%>
<%--        %>--%>
<%--        <c:forEach items="${attr}" var="ele">--%>
<%--           ${ele} <br>--%>
<%--        </c:forEach>--%>
<%--    <%--%>
<%--        Map<String ,Object> map = new HashMap<String ,Object>();--%>
<%--        map.put("key1", "value1");--%>
<%--        map.put("key2", "value2");--%>
<%--        map.put("key3", "value3");--%>
<%--        request.setAttribute("map", map);--%>
<%--    %>--%>

<%--    <c:forEach items="${requestScope.map}" var="entry" >--%>
<%--        <h1>${entry.key}=${entry.value}</h1>--%>
<%--    </c:forEach>--%>
    <%
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 0; i <= 10; i++) {
            studentList.add(new Student(i, "username"+i, "pass"+i,18+i ,"phone"+i ));
        }
        request.setAttribute("stus", studentList);
    %>
    <table border="1">
        <tr>
            <th>编码</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
        <c:forEach begin="2" end="10" step="1" varStatus="status" items="${requestScope.stus}" var="stu">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.username}</td>
                <td>${stu.password}</td>
                <td>${stu.age}</td>
                <td>${stu.phone}</td>
<%--                <td>${status.step}</td>--%>
<%--                <td>${status.count}</td>--%>
<%--                <td>${status.current}</td>--%>
<%--                Student{id=2, username='username2', password='pass2', age=20, phone='phone2'}--%>
<%--                <td>${status.first}</td>    调用的是is方法，要看返回值类型--%>
<%--                <td>${status.last}</td>--%>
<%--                <td>${status.begin}</td>--%>
                <td>${status.end}</td>
            </tr>

        </c:forEach>
    </table>

</body>
</html>
