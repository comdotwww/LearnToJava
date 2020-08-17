<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>查询所有账户</title>
</head>
<body>
<h3>查询所有账户</h3>
<h4>
    <c:forEach items="${accounts}" var="account">
        ${account.name}
    </c:forEach>
</h4>
</body>
</html>
