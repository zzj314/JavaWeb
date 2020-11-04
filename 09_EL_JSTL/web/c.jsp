<%@ page import="com.guigu.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: jie
  Date: 2020-07-10
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
       Person person =  new Person();
       person.setName("中国");
       person.setPhones(new String[]{"11347923","23492734972","3947929"});

        List<String > cites = new ArrayList<String>();
        cites.add("北京");
        cites.add("上海");
        cites.add("深圳");
        person.setCities(cites);

        Map<String ,Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        person.setMap(map);
        pageContext.setAttribute("p", person);


    %>
    EL 表达式输出 Bean 的普通属性，数组属性。List 集 合属性，map 集合属性<br>
    输出Person:   ${p} <br>
    输出Person的name属性：    ${p.name} <br>
    phones属性：   ${p.phones[1]} <br>
    cites集合中的元素 ${p.cities} <br>
    List集合中的元素 ${p.cities[1]} <br>
    Map集合   ${p.map} <br>
    Map中元素     ${p.map.key1} <br>
    age属性 ${p.age}
</body>
</html>
