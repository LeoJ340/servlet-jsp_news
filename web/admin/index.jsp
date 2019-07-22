<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>系统管理中心</title>
    <link rel="stylesheet" href="../bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <style type="text/css">
        .left_nav {
            position: fixed;
            top: 0;
            bottom: 0;
            left: 0;
            z-index: 100;
            box-shadow: inset -1px 0 0 rgba(0, 0, 0, .1);
        }
        .left_nav .nav-link{
            font-weight: 500;
            color: #000000;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-dark fixed-top bg-dark p-0 shadow">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">管理系统</a>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="#">注销</a>
        </li>
    </ul>
</nav>
<div class="container-fluid pt-5">
    <div class="row">
        <%--侧边导航栏--%>
        <nav class="col-md-2 d-none d-md-block bg-light pt-5 left_nav">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Orders</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Customers </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Reports</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Integrations</a>
                    </li>
                </ul>
            </div>
        </nav>
            <main class="col-md-9 ml-sm-auto col-lg-10 px-4">
                <div class="d-flex flex-column pt-3 pb-5 mb-3">

                </div>
            </main>
    </div>
</div>
<script src="../js/jquery.min.js"></script>
<script src="../bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
<script src="../ckeditor5-build-classic/build/ckeditor.js"></script>
<script>
    let editor;
    ClassicEditor
        .create(document.querySelector('#editor'),{
            removePlugins: [ 'MediaEmbed' ]
        })
        .then(newEditor => {
        editor = newEditor;
    })
    .catch(error => {
        console.error(error);
    });
</script>
</body>
</html>