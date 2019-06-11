<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<form class="form-signin">
    <div class="text-center mb-4">
        <img class="mb-5" src="images/logo.webp" alt="" width="200">
        <h1 class="h3 mb-3 font-weight-normal">用户注册</h1>
    </div>

    <div class="form-label-group">
        <span class="text-danger">*</span>
        <label for="username">用户名：</label>
        <input type="text" id="username" class="form-control" placeholder="请输入用户名">
    </div>

    <div class="form-label-group">
        <span class="text-danger">*</span>
        <label for="password">密码：</label>
        <input type="password" id="password" class="form-control" placeholder="请输入密码">
    </div>

    <div class="form-label-group">
        <span class="text-danger">*</span>
        <label for="passwordAgain">再次输入密码：</label>
        <input type="password" id="passwordAgain" class="form-control" placeholder="请再次输入密码">
    </div>

    <div class="form-label-group">
        <span class="text-danger">*</span>
        <label for="birthday">出生日期：</label>
        <input type="date" id="birthday" class="form-control">
    </div>

    <div class="form-label-group">
        <label for="email">email：</label>
        <input type="email" id="email" class="form-control" placeholder="请输入您的Email">
    </div>

    <div class="form-label-group mb-3">
        <span class="text-danger">*</span>
        <label for="tel-number">联系电话：</label>
        <input type="tel" id="tel-number" class="form-control" placeholder="请输入您的联系电话">
    </div>

    <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
</form>
<script src="js/jquery.min.js"></script>
<script src="bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
