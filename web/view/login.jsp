<%--
  Created by IntelliJ IDEA.
  User: lyb
  Date: 2020/3/29
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>数据校验器</title>
</head>
<body>
    <h1>用户登陆（自定义数据校验器测试）</h1>
    <form:form modelAttribute="userRegister" action="login" method="post">
        用户名：<form:input path="userName"></form:input>
               <form:errors path="userName" cssStyle="color: red;"></form:errors>
               <br>
        密  码：<form:password path="userPwd"></form:password>
               <form:errors path="userPwd" cssStyle="color: red;"></form:errors>
               <br>
        <input type="submit" value="登陆">
    </form:form>
</body>
</html>
