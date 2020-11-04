<%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-11
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${param.username}<br>
    ${param.password}<br>

    ${paramValues.username[0]}<br>
    ${paramValues.hobby[0]}<br>
    ${paramValues.hobby[1]}<br>

    ${header['User-Agent']}<br>
    ${header.Connection}<br>
    ${headerValues['User-Agent'][0]}<br>

    ${cookie.JSESSIONID.name}<br>
    ${cookie.JSESSIONID.value}<br>

    ${initParam.username}<br>
    ${initParam.url}

</body>
</html>
