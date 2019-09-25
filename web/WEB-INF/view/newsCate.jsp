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
        首页>${requestScope.cate.name}新闻
    </nav>
    <div class="d-flex flex-wrap">
        <ul class="w-100">
            <c:forEach items="${requestScope.newsPage.beanList}" var="news">
                <li class="border-bottom">
                    <a href="${pageContext.request.contextPath}/news?newsId=${news.id}" class="title">
                        <h5>${news.title}</h5>
                    </a>
                    <span class="d-flex justify-content-end time">${news.time}</span>
                </li>
            </c:forEach>
        </ul>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <%--如果当前页面为第一页时，上一页按钮禁用--%>
                <c:choose>
                    <c:when test="${empty requestScope.newsPage.pageIndex || requestScope.newsPage.pageIndex <= 1}">
                    <li class="page-item disabled" data-toggle="tooltip" data-placement="left" title="没有上一页了">
                        <a class="page-link" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    </c:when>
                    <c:otherwise>
                    <li class="page-item">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/newsCate?cateId=${requestScope.cate.id}&pageIndex=${requestScope.newsPage.pageIndex-1}"
                           aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    </c:otherwise>
                </c:choose>
                <c:forEach var="pageIndex" begin="1" end="${requestScope.newsPage.totalPage}">
                    <c:choose>
                        <c:when test="${pageIndex eq requestScope.newsPage.pageIndex}">
                            <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/newsCate?cateId=${requestScope.cate.id}&pageIndex=${pageIndex}">${pageIndex}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/newsCate?cateId=${requestScope.cate.id}&pageIndex=${pageIndex}">${pageIndex}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <%--如果当前页面为最后一页时，下一页按钮禁用--%>
                <c:choose>
                    <c:when test="${empty requestScope.newsPage.pageIndex || requestScope.newsPage.pageIndex >= requestScope.newsPage.totalPage}">
                    <li class="page-item disabled" data-toggle="tooltip" data-placement="left" title="没有下一页了">
                        <a class="page-link" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                    </c:when>
                    <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="${pageContext.request.contextPath}/newsCate?cateId=${requestScope.cate.id}&pageIndex=${requestScope.newsPage.pageIndex+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
