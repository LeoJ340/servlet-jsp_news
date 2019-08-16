<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>新闻</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index.css">
  </head>
  <body>
  <%@include file="header.jsp"%>
  <div class="container mt-3 main">
    <div class="d-flex flex-wrap">
      <c:forEach items="${requestScope.allNewsCateVo}" var="NewsCateVo">
        <div class="news w-50 p-2">
          <div class="d-flex">
            <h3>${NewsCateVo.name}</h3>
            <div class="flex-grow-1 d-flex justify-content-end">
              <a href="${pageContext.request.contextPath}/newsCate?cateId=${NewsCateVo.cateId}">更多</a>
            </div>
          </div>
          <ul>
            <c:forEach items="${NewsCateVo.news}" var="news">
              <li class="d-flex">
                <a class="title" href="${pageContext.request.contextPath}/news?newsId=${news.id}">${news.title}</a>
                <span class="flex-grow-1 d-flex justify-content-end time">${news.time}</span>
              </li>
            </c:forEach>
          </ul>
        </div>
      </c:forEach>
  <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
  </body>
</html>
