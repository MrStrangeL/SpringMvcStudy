<%--
  Created by IntelliJ IDEA.
  User: lyb
  Date: 2020/3/25
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>探寻 Spring MVC 视图层的实现机制</title>
</head>
<body>
    <h4>Map业务数据绑定</h4>
    <h6>用户名：${userRegisterMap.userName}</h6>
    <h6>密码：${userRegisterMap.userPwd}</h6>

    <h4>Model业务数据绑定</h4>
    <h6>用户名：${userRegisterModel.userName}</h6>
    <h6>密码：${userRegisterModel.userPwd}</h6>

    <h4>ModelAndView1业务数据绑定</h4>
    <h6>用户名：${userRegisterModelAndView1.userName}</h6>
    <h6>密码：${userRegisterModelAndView1.userPwd}</h6>

    <h4>ModelAndView2业务数据绑定</h4>
    <h6>用户名：${userRegisterModelAndView2.userName}</h6>
    <h6>密码：${userRegisterModelAndView2.userPwd}</h6>

    <h4>ModelAndView3业务数据绑定</h4>
    <h6>用户名：${userRegisterModelAndView3.userName}</h6>
    <h6>密码：${userRegisterModelAndView3.userPwd}</h6>

    <h4>ModelAndView4业务数据绑定</h4>
    <h6>用户名：${userRegisterModelAndView4.userName}</h6>
    <h6>密码：${userRegisterModelAndView4.userPwd}</h6>

    <h4>ModelAndView5业务数据绑定</h4>
    <h6>用户名：${userRegisterModelAndView5.userName}</h6>
    <h6>密码：${userRegisterModelAndView5.userPwd}</h6>

    <h4>ModelAndView6业务数据绑定</h4>
    <h6>用户名：${userRegisterModelAndView6.userName}</h6>
    <h6>密码：${userRegisterModelAndView6.userPwd}</h6>

    <h4>ModelAndView7业务数据绑定</h4>
    <h6>用户名：${userRegisterModelAndView7.userName}</h6>
    <h6>密码：${userRegisterModelAndView7.userPwd}</h6>

    <h4>ModelAndView8业务数据绑定</h4>
    <h6>用户名：${userRegisterModelAndView8.userName}</h6>
    <h6>密码：${userRegisterModelAndView8.userPwd}</h6>

    <h4>HttpServletRequest业务数据绑定</h4>
    <h6>用户名：${userRegisterRequest.userName}</h6>
    <h6>密码：${userRegisterRequest.userPwd}</h6>

    <h4>@ModelAttribute业务数据绑定(直接返回对象)</h4>
    <h6>用户名：${userRegister.userName}</h6>
    <h6>密码：${userRegister.userPwd}</h6>

    <h4>@ModelAttribute业务数据绑定(没有返回对象，通过Map手动添加)</h4>
    <h6>用户名：${userMap.userName}</h6>
    <h6>密码：${userMap.userPwd}</h6>

    <h4>@ModelAttribute业务数据绑定(没有返回对象，通过Model手动添加)</h4>
    <h6>用户名：${userModel.userName}</h6>
    <h6>密码：${userModel.userPwd}</h6>

    <h4>@ModelAttribute业务数据绑定(没有返回对象，通过Model手动添加)</h4>
    <h6>id：${user.id}</h6>
    <h6>name：${user.name}</h6>
    <h6>user.address.id：${user.address.id}</h6>
    <h6>address.id：${address.id}</h6>
    <h6>user.address.name：${user.address.name}</h6>
    <h6>address.name：${address.name}</h6>

    <h4>@SessionAttributes</h4>
    <h6>sessionScope.id：${sessionScope.user.id}</h6>
    <h6>sessionScope.name：${sessionScope.user.name}</h6>
    <h6>sessionScope.user.address.id：${sessionScope.user.address.id}</h6>
    <h6>sessionScope.user.address.name：${sessionScope.user.address.name}</h6>
</body>
</html>
