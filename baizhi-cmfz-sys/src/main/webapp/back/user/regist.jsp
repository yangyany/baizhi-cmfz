<%--
  Created by IntelliJ IDEA.
  User: yanyan
  Date: 2017/6/13
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ include file="../util.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${prc}/user/saveUser" method="post" >
    请输入手机号：<input name="tel" type="text"/><br/><br/>

    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" value="注册"/>
</form>
</body>
</html>
