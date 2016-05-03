<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>汇智</title>
    <link rel="stylesheet" href="asset/css/bootstrap.min.css">
</head>
<body>
<div style="text-align: center;">
    <div>
        <h1>登录</h1>
    </div>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名: <input type="text" name="username"><hr/>
        密  码: <input type="password" name="password"><hr/>
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>
