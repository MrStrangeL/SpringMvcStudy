<%--
  Created by IntelliJ IDEA.
  User: lyb
  Date: 2020/3/27
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESTful</title>
</head>
<body>
    <h1>POST</h1>
    <form action="course/addCourse" method="post">
        课程编号：<input type="text" name="id">
        课程名称：<input type="text" name="name">
        课程价格：<input type="text" name="price">
        <input type="submit" value="添加">
    </form>

    <h1>GET</h1>
    <form action="course/getAll" method="get">
        <input type="submit" value="获取">
    </form>

    <h1>PUT</h1>
    <form action="course/updateCourse" method="post">
        <input type="hidden" name="_method" value="put">
        课程编号：<input type="text" name="id">
        课程名称：<input type="text" name="name">
        课程价格：<input type="text" name="price">
        <input type="submit" value="修改">
    </form>

    <h1>DELETE</h1>
    <form action="course/deleteCourse" method="post">
        <input type="hidden" name="_method" value="delete">
        课程编号：<input type="text" name="id">
        <input type="submit" value="删除">
    </form>
</body>
</html>
