<%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-10
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
         1212
    --%>
    <%
        out.write("12");
        out.print("12");

    %>
    <br>
    <%--
    12  print底层将输出内容转成字符串后，再调用write();
          char[] cb 是out的缓冲区
          write将输出的字符：cb[nextChar++] = (char)c;
    --%>
    <%
        out.write(12);
        out.print(12);

    %>
</body>
</html>
