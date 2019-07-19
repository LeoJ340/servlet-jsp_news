<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<form class="form-signin" method="post" action="${pageContext.request.contextPath}/login">
    <div class="text-center mb-4">
        <img class="mb-5" src="images/logo.webp" alt="" width="200">
        <h1 class="h3 mb-3 font-weight-normal">用户登录</h1>
    </div>

    <div class="form-label-group">
        <label for="username">用户名：</label>
        <input type="text" id="username" class="form-control" placeholder="请输入用户名" name="username" value="${requestScope.rememberUsername}">
    </div>

    <div class="form-label-group">
        <label for="password">密码：</label>
        <input type="password" id="password" class="form-control" placeholder="请输入密码" name="password" value="${requestScope.rememberPassword}">
    </div>

    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" name="remember">记住我
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>
<script src="js/jquery.min.js"></script>
<script src="bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
