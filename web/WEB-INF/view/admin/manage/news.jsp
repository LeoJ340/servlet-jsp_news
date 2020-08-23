<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>文章管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/manage.css">
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
                    <c:forEach items="${requestScope.newsVoPage.beanList}" var="newsVo">
                        <li class="pt-3 pb-1 border-top d-block">
                            <form class="d-flex flex-column" method="post" action="${pageContext.request.contextPath}/admin/manage/news">
                                <h3>
                                    <a href="${pageContext.request.contextPath}/news?newsId=${newsVo.id}">[${newsVo.newsCate.name}]${newsVo.title}</a>
                                </h3>
                                <div class="row pl-3 pr-3">
                                    <span class="pt-2 time">${newsVo.time}</span>
                                    <span class="ml-2 pt-2 author">${newsVo.author}</span>
                                    <a href="${pageContext.request.contextPath}/admin/manage/news?newsId=${newsVo.id}"
                                       class="ml-auto btn btn-outline-primary btn-sm">编辑</a>
                                    <button type="submit" class="btn btn-danger btn-sm" name="id" value="${newsVo.id}">删除</button>
                                </div>
                            </form>
                        </li>
                    </c:forEach>
                </ul>
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <%--如果当前页面为第一页时，上一页按钮禁用--%>
                        <c:choose>
                            <c:when test="${empty requestScope.newsVoPage.pageIndex || requestScope.newsVoPage.pageIndex <= 1}">
                                <li class="page-item disabled" data-toggle="tooltip" data-placement="left" title="没有上一页了">
                                    <a class="page-link" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item">
                                    <a class="page-link" href="${pageContext.request.contextPath}/admin/manage/news?pageIndex=${requestScope.newsVoPage.pageIndex-1}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach var="pageIndex" begin="1" end="${requestScope.newsVoPage.totalPage}">
                            <c:choose>
                                <c:when test="${pageIndex eq requestScope.newsVoPage.pageIndex}">
                                    <li class="page-item active">
                                        <a class="page-link" href="${pageContext.request.contextPath}/admin/manage/news?pageIndex=${pageIndex}">${pageIndex}</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item">
                                        <a class="page-link" href="${pageContext.request.contextPath}/admin/manage/news?pageIndex=${pageIndex}">${pageIndex}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <%--如果当前页面为最后一页时，下一页按钮禁用--%>
                        <c:choose>
                            <c:when test="${empty requestScope.newsVoPage.pageIndex || requestScope.newsVoPage.pageIndex >= requestScope.newsVoPage.totalPage}">
                                <li class="page-item disabled" data-toggle="tooltip" data-placement="left" title="没有下一页了">
                                    <a class="page-link" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item">
                                    <a class="page-link" href="${pageContext.request.contextPath}/admin/manage/news?pageIndex=${requestScope.newsVoPage.pageIndex+1}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </nav>
            </div>
        </main>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>