<%--
  Created by IntelliJ IDEA.
  User: lyb
  Date: 2020/3/26
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>如何给项目定制数据类型转换器</title>
</head>
<body>
    <h4>String转Date</h4>
    <form action="stringToDateTest" method="post">
        请输入日期：<input type="text" name="date" placeholder="yyyy-mm-dd">
        <input type="submit" value="提交">
    </form>

    <h4>String转UserRegister</h4>
    <form action="stringToUserRegisterTest" method="post">
        请输入日期：<input type="text" name="userRegister" placeholder="userName-userPwd">
        <input type="submit" value="提交">
    </form>
</body>
</html>
