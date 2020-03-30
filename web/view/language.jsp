<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lyb
  Date: 2020/3/30
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC国际化</title>
</head>
<body>
<div>当前语言: ${pageContext.response.locale }</div>
切换：
<a href="?lang=zh_CN"><spring:message code="language.cn"/></a> &nbsp;&nbsp;&nbsp;
<a href="?lang=en_US"><spring:message code="language.en"/></a>
<h1>
    <spring:message code="info"/>
</h1>
<form action="" method="post">
    <table>
        <tr>
            <td>
                <spring:message code="username"/>：
            </td>
            <td>
                <input type="text"/>
            </td>
        </tr>
        <tr>
            <td>
                <spring:message code="password"/>：
            </td>
            <td>
                <input type="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <spring:message code="repassword"/>：
            </td>
            <td>
                <input type="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <spring:message code="tel"/>：
            </td>
            <td>
                <input type="text"/>
            </td>
        </tr>
        <tr>
            <td>
                <spring:message code="email"/>：
            </td>
            <td>
                <input type="text"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="<spring:message code="submit"/>"/>
            </td>
            <td>
                <input type="reset" value="<spring:message code="reset"/>"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
