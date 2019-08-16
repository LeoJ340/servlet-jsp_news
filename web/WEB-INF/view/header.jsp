<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<header class="bg-dark">
    <div class="container d-flex">
        <a href="${pageContext.request.contextPath}/">首页</a>
        <div class="flex-grow-1 d-flex justify-content-end">
            <c:choose>
                <c:when test="${empty sessionScope.userStatus}">
                    <a href="${pageContext.request.contextPath}/login">登录</a>
                    <a href="${pageContext.request.contextPath}/register">注册</a>
                </c:when>
                <c:otherwise>
                    <span>欢迎您！尊敬的用户</span>
                    <a href="#">${sessionScope.user.username}</a>
                    <a href="${pageContext.request.contextPath}/logout">注销</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</header>
<nav class="navbar navbar-expand-sm bg-light navbar-light">
    <ul class="container navbar-nav">
        <c:forEach items="${requestScope.allCate}" var="cate">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/newsCate?cateId=${cate.id}" >
                    ${cate.name}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>
