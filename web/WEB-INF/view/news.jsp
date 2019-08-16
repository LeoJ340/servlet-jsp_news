<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${requestScope.news.title}</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/header.css">
</head>
<body>
<%@include file="header.jsp"%>
<div class="container mt-3 p-0 main">
    <div class="d-flex flex-wrap flex-column">
        <h1 class="text-center mb-3">${requestScope.news.title}</h1>
        <div class="d-flex justify-content-end mb-3">
            <span>${requestScope.news.author}发表于${requestScope.news.time}</span>
        </div>
        <p>
            ${requestScope.news.content}
        </p>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
