<%--
  Created by IntelliJ IDEA.
  User: lyb
  Date: 2020/3/17
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模拟Spring MVC运行机制</title>
</head>
<body>
    <h1 style="text-align: center;color: red">Hello World!</h1>
    <h3>POJO类型数据绑定：</h3>
    <form action="pojoType" method="post">
        用户名：<input type="text" name="userName">
        密  码：<input type="password" name="userPwd">
        <input type="submit" value="登陆">
    </form>

    <h3>POJO类型级联数据绑定：</h3>
    <form action="pojoCascadeType" method="post">
        用户编号：<input type="text" name="id">
        用户姓名：<input type="text" name="name">
        地址编号：<input type="text" name="address.id">
        地    址：<input type="text" name="address.name">
        <input type="submit" value="提交">
    </form>

    <h3>List类型数据绑定：</h3>
    <form action="listType" method="post">
        用户名1：<input type="text" name="users[0].userName">
        密  码1：<input type="password" name="users[0].userPwd">
        用户名2：<input type="text" name="users[1].userName">
        密  码2：<input type="password" name="users[1].userPwd">
        用户名3：<input type="text" name="users[2].userName">
        密  码3：<input type="password" name="users[2].userPwd">
        <input type="submit" value="登陆">
    </form>

    <h3>Set类型数据绑定：</h3>
    <form action="setType" method="post">
        用户名1：<input type="text" name="users[0].userName">
        密  码1：<input type="password" name="users[0].userPwd">
        用户名2：<input type="text" name="users[1].userName">
        密  码2：<input type="password" name="users[1].userPwd">
        用户名3：<input type="text" name="users[2].userName">
        密  码3：<input type="password" name="users[2].userPwd">
        <input type="submit" value="登陆">
    </form>
</body>
</html>
