<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-12
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    保存之前：${sessionScope.abc}<br>
http://localhost:8080/09_EL_JSTL/core.jsp
--%>
<%--    <c:set scope="session" var="abc" value="abcValue"></c:set>--%>
<%--    保存之后: ${sessionScope.abc}<br>--%>
<%--保存之前0：${applicationScope.abc}<br>--%>
<%--<c:set scope="application" var="abc" value="abcValue"></c:set>--%>
<%--保存之后0: ${applicationScope.abc}<br>--%>
<%--<c:if test="${12==12}">--%>
<%--    <h1>12</h1>--%>
<%--</c:if>--%>
<%--多路判断--%>
<%
    request.setAttribute("height", 10);
%>
<c:choose>  <%--switch--%>
    <c:when test="${requestScope.height>190}"> <%--case--%>
        <h2>很高</h2>
    </c:when>
    <c:when test="${requestScope.height >180}">
        <h2>高</h2>
    </c:when>
    <c:when test="${requestScope.height>170}">
        <h2>中</h2>
    </c:when>
    <c:otherwise >
            <c:choose>
                <c:when test="${requestScope.height>160}">
                    <h3>》160</h3>
                </c:when>
                <c:when test="${requestScope.height>150}">
                    <h3>》150</h3>
                </c:when>
                <c:when test="${requestScope.height>140}">
                    <h3>》140</h3>
                </c:when>
                <c:otherwise>130</c:otherwise>
            </c:choose>
    </c:otherwise>
</c:choose>
<%--default--%>
123第三方
</body>
</html>
