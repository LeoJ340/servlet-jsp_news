<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${requestScope.cateName}新闻</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/newsCate.css">
</head>
<body>
<%@include file="header.jsp"%>
<div class="container p-0 main">
    <nav class="navbar navbar-dark bg-dark text-white mb-3">
        首页>${requestScope.cateName}新闻
    </nav>
    <div class="d-flex flex-wrap">
        <ul class="w-100">
            <c:forEach items="${requestScope.newsList}" var="news">
                <li class="border-bottom">
                    <a href="${pageContext.request.contextPath}/news?newsId=${news.id}" class="title">
                        <h5>${news.title}</h5>
                    </a>
                    <span class="d-flex justify-content-end time">${news.time}</span>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
