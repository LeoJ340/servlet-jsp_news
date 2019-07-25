<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>文章管理</title>
    <link rel="stylesheet" href="../../bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<%--header--%>
<%@include file="header.jsp"%>
<div class="container-fluid pt-5">
    <div class="row">
        <%--侧边导航栏--%>
        <%@include file="nav.jsp"%>
        <main class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <div class="d-flex flex-column pt-3 pb-5 mb-3">
                <ul>
                    <c:forEach items="${sessionScope.allNews}" var="news">
                        <li class="pt-3 pb-1 border-top d-block">
                            <form class="d-flex flex-column" method="post" action="${pageContext.request.contextPath}/admin/manage/news">
                                <h3>
                                    <a href="${pageContext.request.contextPath}/news?newsId=${news.id}">[${news.cate}]${news.title}</a>
                                </h3>
                                <div class="row pl-3 pr-3">
                                    <span class="pt-2 time">${news.time}</span>
                                    <span class="ml-2 pt-2 author">${news.author}</span>
                                    <button type="submit" class="ml-auto btn btn-danger btn-sm" name="id" value="${news.id}">删除</button>
                                </div>
                            </form>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </main>
    </div>
</div>
<script src="../../js/jquery.min.js"></script>
<script src="../../bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>