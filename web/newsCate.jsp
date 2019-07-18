<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${requestScope.cateName}新闻</title>
    <link rel="stylesheet" type="text/css" href="bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <link rel="stylesheet" type="text/css" href="css/newscate.css">
</head>
<body>
<%@include file="header.jsp"%>
<div class="container mt-1 p-0 main">
    <nav class="navbar navbar-dark bg-dark text-white mb-3">
        首页>${requestScope.cateName}新闻
    </nav>
    <div class="d-flex flex-wrap">
        <ul class="w-100">
            <c:forEach items="${requestScope.newslist}" var="news">
                <li class="d-flex flex-column pb-3 border-bottom">
                    <a href="${pageContext.request.contextPath}/news?newsId=${news.id}">
                        <h3>${news.title}</h3>
                    </a>
                    <div class="d-flex">
                        <p class="col-10 mb-0 p-0">${news.content}</p>
                        <span class="col-2 align-self-end d-flex justify-content-end p-0 time">${news.time}</span>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
<script src="js/jquery.min.js"></script>
<script src="bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
