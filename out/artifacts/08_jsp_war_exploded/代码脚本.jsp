<%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-09
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        int i = 12;
        if (i == 12){
            System.out.println("shsdfh");
        }else {
            System.out.println("bbb");
        }
    %>
    <%
        String username = request.getParameter("username");
        System.out.println("用户名的请求参数值是:"+username);
    %>
    <table border="1" cellspacing="0">
    <%
        for (int j = 0; j < 10; j++) {
    %>
        <tr>
            <td>第<%=j+1 %>行<br></td>
        </tr>
    <%
        }
    %>

    </table>
</body>
</html>
