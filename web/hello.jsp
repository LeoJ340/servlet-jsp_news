<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Title</title>
</head>
<body>
<%
    request.getRequestDispatcher("/index").forward(request,response);
%>
</body>
</html>
