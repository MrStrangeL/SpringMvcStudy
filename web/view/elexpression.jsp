<%@ page import="com.springmvcstudy.entity.UserRegister" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lyb
  Date: 2020/3/30
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<%
    pageContext.setAttribute("message","page");
    request.setAttribute("message","request");
    session.setAttribute("message","session");
    application.setAttribute("message","application");
%>
message:${message}<br>
pageScope:${pageScope.message}<br>
requestScope:${requestScope.message}<br>
sessionScope:${sessionScope.message}<br>
applicationScope:${applicationScope.message}<br>

<h1>使用 EL 表达式获取对象的属性值:</h1>
<%
    UserRegister userRegister=new UserRegister("UserName","UserPwd");
    request.setAttribute("userRegister",userRegister);
%>
${userRegister.userName}--${userRegister.userPwd}<br>

<h1>EL 表达式获取集合:</h1>
<%
    UserRegister userRegisterOne=new UserRegister("UserNameOne","UserPwdOne");
    UserRegister userRegisterTwo=new UserRegister("UserNameTwo","UserPwdTwo");
    UserRegister userRegisterThree=new UserRegister("UserNameThree","UserPwdThree");
    List<UserRegister> userRegisterList=new ArrayList<>();
    userRegisterList.add(userRegisterOne);
    userRegisterList.add(userRegisterTwo);
    userRegisterList.add(userRegisterThree);
    request.setAttribute("userRegisterList",userRegisterList);
%>
${userRegisterList[0].userName}--${userRegisterList[0].userPwd}<br>
${userRegisterList[1].userName}--${userRegisterList[1].userPwd}<br>
${userRegisterList[2].userName}--${userRegisterList[2].userPwd}<br>

<h1>EL 表达式支持关系运算符和逻辑运算符:</h1>
<%
    request.setAttribute("num1",8);
    request.setAttribute("num2",9);
    request.setAttribute("num3",9);
%>
<p>num1:8</p>
<p>num2:9</p>
<p>num3:9</p>
num1 < num2：${num1<num2}<br>
num1 lt num2：${num1 lt num2}<br>
num1 > num2：${num1 > num2}<br>
num1 gt num2：${num1 gt num2}<br>
num2 == num3：${num2 == num3}<br>
num2 eq num3：${num2 eq num3}<br>
num1 < num2 && num1 > num2：${num1<num2 && num1>num2}<br>
num1 < num2 and num1 > num2：${num1<num2 and num1>num2}<br>
num1 < num2 || num1 > num2：${num1<num2 || num1>num2}<br>
num1 < num2 or num1 > num2：${num1<num2 or num1>num2}<br>

<h1>关键字 empty 判断变量是否为空:</h1>
<%
    Integer num=null;
    String str="";
    List<String> list=new ArrayList<>();
    request.setAttribute("num",num);
    request.setAttribute("str",str);
    request.setAttribute("list",list);
%>
Integer num=null;${empty num}<br>
String str="";${empty str}<br>
List<String> list=new ArrayList<>();${empty list}<br>

<h1>EL 访问 HTTP 请求参数对象:</h1>
单个参数：${param.id}<br>
多个参数：${paramValues.id[0]}<br>
         ${paramValues.id[1]}<br>
         ${paramValues.id[2]}<br>
<h1>EL 访问 pageContext 对象:</h1>
pageContext.servletConfig.servletName:${pageContext.servletConfig.servletName}<br>
pageContext.servletConfig.initParameterNames:${pageContext.servletConfig.initParameterNames}<br>
pageContext.servletContext.contextPath:${pageContext.servletContext.contextPath}<br>
pageContext.request:${pageContext.request}<br>
</body>
</html>
