<%@ page import="com.springmvcstudy.entity.UserRegister" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: lyb
  Date: 2020/3/31
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 核心标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 格式化标签库 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 函数标签库 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>JSTL标签库</title>
</head>
<body>
<h1>核心标签库</h1>
<h4>set标签向域中添加数据</h4>
<c:set var="message" value="set标签" scope="request"></c:set>
${requestScope.message}
<br>
<hr>

<h4>set标签修改对象的属性值</h4>
<%
    UserRegister userRegister=new UserRegister("UserName","UserPwd");
    request.setAttribute("userRegister",userRegister);
%>
<c:set value="用户名" property="userName" target="${userRegister}"></c:set>
<c:set value="密码" property="userPwd" target="${userRegister}"></c:set>
${userRegister}
<hr>

<h4>out标签修改对象的属性值</h4>
<c:out value="${userRegister}" default="未定义"></c:out>
<hr>

<h4>remove标签删除域对象中的数据</h4>
<c:remove var="message"></c:remove>
<c:out value="${message}" default="未定义"></c:out>
<hr>

<h4>catch标签捕获异常</h4>
<c:catch var="error">
    <%
        request.setAttribute("result",(10/0));
    %>
</c:catch>
<c:out value="${error}"></c:out>
<hr>

<h4>if标签流程控制</h4>
<c:set var="num1" value="2"></c:set>
<c:set var="num2" value="5"></c:set>
<c:if test="${num1>num2}">${num1} > ${num2}</c:if>
<c:if test="${num1<num2}">${num1} < ${num2}</c:if>
<hr>

<h4>choose标签流程控制</h4>
<c:choose>
    <c:when test="${num1>num2}">
        ${num1} > ${num2}
    </c:when>
    <c:otherwise>
        ${num1} < ${num2}
    </c:otherwise>
</c:choose>
<hr>

<h4>forEach标签迭代集合</h4>
<%
    UserRegister userRegisterList=new UserRegister("userNameList","userPwdList");
    UserRegister userRegisterSet=new UserRegister("userNameSet","userPwdSet");
    UserRegister userRegisterMap=new UserRegister("userNameMap","userPwdMap");

    List<UserRegister> list=new ArrayList<>();
    list.add(userRegisterList);
    list.add(userRegisterSet);
    list.add(userRegisterMap);

    Set<UserRegister> set=new HashSet<>();
    set.add(userRegisterList);
    set.add(userRegisterSet);
    set.add(userRegisterMap);

    Map<Integer,UserRegister> map=new HashMap<>();
    map.put(1,userRegisterList);
    map.put(2,userRegisterSet);
    map.put(3,userRegisterMap);

    request.setAttribute("list",list);
    request.setAttribute("set",set);
    request.setAttribute("map",map);
%>
<h5>遍历List</h5>
<c:forEach items="${list}" var="userRegister">${userRegister}<br></c:forEach>
<hr>

<h5>遍历Set</h5>
<c:forEach items="${set}" var="userRegister">${userRegister}<br></c:forEach>
<hr>

<h5>遍历Map</h5>
<c:forEach items="${map}" var="userRegister">${userRegister}<br></c:forEach>
<hr>

<h4>日期格式化</h4>
<%
    request.setAttribute("today",new Date());
%>
today:<c:out value="${today}"></c:out><br>
格式化:<fmt:formatDate value="${today}"></fmt:formatDate><br>
格式化（yyyy-MM-dd HH:mm:ss）:<fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate><br>
<hr>

<h4>数字格式化</h4>
12345.6789:<fmt:formatNumber value="12345.6789" maxIntegerDigits="3" maxFractionDigits="2"></fmt:formatNumber><br>
12345.6789:<fmt:formatNumber value="12345.6789" maxIntegerDigits="3" minFractionDigits="2"></fmt:formatNumber><br>
45.6789:<fmt:formatNumber value="45.6789" minIntegerDigits="3" maxFractionDigits="2"></fmt:formatNumber><br>
45.6789:<fmt:formatNumber value="45.6789" minIntegerDigits="3" minFractionDigits="2"></fmt:formatNumber><br>
<hr>

<h4>函数标签库</h4>
<%
    request.setAttribute("info","Java,C");
%>
Java,C判断是否包含"Ja"：${fn:contains(info,"Ja")}<br>
Java,C判断是否以"Ja"开始：${fn:startsWith(info,"Ja")}<br>
Java,C判断是否以"C"结尾：${fn:endsWith(info,"C")}<br>
Java,C求"va"的下标：${fn:indexOf(info,"va")}<br>
Java,C中"Java"替换为"JavaScript"：${fn:replace(info,"Java","JavaScript")}<br>
Java,C截取：${fn:substring(info,2,5)}<br>
Java,C以"，"分割：${fn:split(info,",")[1]}<br>
<hr>

</body>
</html>
