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
    <title>数据校验器JSR</title>
</head>
<body>
    <h1>用户登陆（JSR标准校验测试）</h1>
    <form:form modelAttribute="userJSR" action="loginJSR" method="post">
        JSR用户名：<form:input path="username"></form:input>
                  <form:errors path="username" cssStyle="color: red;"></form:errors>
                  <br>
        JSR密  码：<form:password path="password"></form:password>
                  <form:errors path="password" cssStyle="color: red;"></form:errors>
                  <br>
        JSR邮  箱：<form:input path="email"></form:input>
                  <form:errors path="email" cssStyle="color: red;"></form:errors>
                  <br>
        JSR电  话：<form:input path="phone"></form:input>
                  <form:errors path="phone" cssStyle="color: red;"></form:errors>
                  <br>
        <input type="submit" value="登陆">
    </form:form>
</body>
</html>
