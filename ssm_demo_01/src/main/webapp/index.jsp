<%--
  Created by IntelliJ IDEA.
  User: XmJ
  Date: 2020/8/16
  Time: 下午 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <h2 align="center"><a href="account/findAll">查询所有</a></h2>
<div align="center">
    <form action="account/add" method="post">
        姓名：<input type="text" name="name" /><br/>
        余额：<input type="text" name="balance" /><br/>
        <input type="submit" value="添加"/><br/>
    </form>
</div>
</body>
</html>
