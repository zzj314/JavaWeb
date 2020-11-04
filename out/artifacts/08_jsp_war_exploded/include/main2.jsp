<%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-10
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br>
    主体内容<br>
    <%--        传递到footer2的页面，用户名和密码可以被footer2拿到    --%>
    <jsp:include page="/include/footer2.jsp">
        <jsp:param name="username" value="bbj"></jsp:param>
        <jsp:param name="password" value="bbj2"></jsp:param>

    </jsp:include>
</body>
</html>
