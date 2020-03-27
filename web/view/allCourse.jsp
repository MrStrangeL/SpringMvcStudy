<%--
  Created by IntelliJ IDEA.
  User: lyb
  Date: 2020/3/27
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>RESTful</title>
</head>
<body>
    <c:forEach items="${courses}" var="course">
        课程编号：${course.id}
        课程名称：${course.name}
        课程价格：${course.price}
        <br>
    </c:forEach>
</body>
</html>
