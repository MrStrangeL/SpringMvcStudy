<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lyb
  Date: 2020/3/30
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC表单标签库</title>
</head>
<body>
    <h1>修改用户信息（使用EL表达式）</h1>
    <form action="" method="">
        用户名：<input type="text" value="${userJSR.username}" name="username"><br>
        密  码：<input type="password" value="${userJSR.password}" name="password"><br>
        邮  箱：<input type="text" value="${userJSR.email}" name="email"><br>
        电  话：<input type="text" value="${userJSR.phone}" name="phone"><br>
        <input type="submit" value="修改">
    </form>

    <h1>修改用户信息（使用标签库）</h1>
    <form:form modelAttribute="userJSRTagLib">
        用户名：<form:input path="username"></form:input><form:errors path="username"></form:errors><br>
        密  码：<form:input path="password"></form:input><form:errors path="password"></form:errors><br>
        邮  箱：<form:input path="email"></form:input><form:errors path="email"></form:errors><br>
        电  话：<form:input path="phone"></form:input><form:errors path="phone"></form:errors><br>
        标  记：<form:checkbox path="flag"></form:checkbox><form:errors path="flag"></form:errors><br>
        爱  好：<form:checkbox path="hobby" value="打游戏"></form:checkbox>打游戏<form:errors path="hobby"></form:errors><br>
               <form:checkbox path="hobby" value="看书"></form:checkbox>看书<form:errors path="hobby"></form:errors><br>
               <form:checkbox path="hobby" value="旅行"></form:checkbox>旅行<form:errors path="hobby"></form:errors><br>
               <form:checkbox path="hobby" value="徒步"></form:checkbox>徒步<form:errors path="hobby"></form:errors><br>
               <form:checkbox path="hobby" value="看电影"></form:checkbox>看电影<form:errors path="hobby"></form:errors><br>
               <form:checkbox path="hobby" value="摄影"></form:checkbox>摄影<form:errors path="hobby"></form:errors><br>
               <form:checkbox path="hobby" value="游泳"></form:checkbox>游泳<form:errors path="hobby"></form:errors><br>
        爱  好（checkboxes）：<form:checkboxes path="hobby" items="${userJSRTagLib.hobbyList}"></form:checkboxes><form:errors path="hobby"></form:errors><br>
        性  别：<form:radiobutton path="sex" value="女"></form:radiobutton>女<form:errors path="sex"></form:errors><br>
               <form:radiobutton path="sex" value="男"></form:radiobutton>男<form:errors path="sex"></form:errors><br>
        年  级（radiobuttons）：<form:radiobuttons path="grade" items="${userJSRTagLib.gradeList}"></form:radiobuttons><form:errors path="grade"></form:errors><br>
        城  市：<form:select path="city" items="${userJSRTagLib.cityMap}"></form:select><form:errors path="city"></form:errors><br>
        城 市2：<form:select path="city">
                    <form:options items="${userJSRTagLib.cityMap}"></form:options>
               </form:select>
               <form:errors path="city"></form:errors><br>
        城 市3：<form:select path="city">
                    <form:option value="0">云南</form:option>
                    <form:option value="1">四川</form:option>
                    <form:option value="2">重庆</form:option>
                    <form:option value="3">西藏</form:option>
                    <form:option value="4">拉萨</form:option>
               </form:select>
               <form:errors path="city"></form:errors><br>
        自我介绍：<form:textarea path="introduce"></form:textarea><form:errors path="introduce"></form:errors><br>
        隐藏标签：<form:hidden path="hidden"></form:hidden><form:errors path="hidden"></form:errors><br>
        <input type="submit" value="修改">
    </form:form>
</body>
</html>
