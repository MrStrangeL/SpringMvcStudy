<%--
  Created by IntelliJ IDEA.
  User: lyb
  Date: 2020/3/28
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Apache fileupload文件上传</title>
</head>
<body>
    <h1>单文件上传：</h1>
    <form action="singleFileUpload" method="post" enctype="multipart/form-data">
        <input type="file" name="singleFile">
        <input type="submit" value="上传">
    </form>

    <c:if test="${filePath!=null }">
        <h1>上传的图片</h1><br />
        <img width="300px" src="<%=basePath %>${filePath}"/>
    </c:if>

    <h1>多文件上传：</h1>
    <form action="multiFileUpload" method="post" enctype="multipart/form-data">
        file1:<input type="file" name="multiFile"><br />
        file2:<input type="file" name="multiFile"><br />
        file3:<input type="file" name="multiFile"><br />
        <input type="submit" name="上传">
    </form>
    <c:if test="${filePaths!=null }">
        <h1>上传的图片</h1><br />
        <c:forEach items="${filePaths }" var="filePath">
            <img width="300px" src="<%=basePath %>${filePath}"/>
        </c:forEach>
    </c:if>

    <c:if test="${fileArrays!=null }">
        <h1>文件下载：</h1>
        <c:forEach items="${fileArrays }" var="fileName">
            <h6>${fileName}</h6>
            <a href="download?fileName=${fileName}">下载</a>
            <a href="http://localhost:8080/SpringMvcStudy/file/${fileName}" target="_blank">查看</a>
            <br>
        </c:forEach>
    </c:if>
</body>
</html>
