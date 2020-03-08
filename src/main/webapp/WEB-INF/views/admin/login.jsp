<%--
  Created by IntelliJ IDEA.
  User: janghyeon
  Date: 2020/03/06
  Time: 8:08 오후
  admin 접근을 위한 passwd 확인을 위한 페이
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <!-- ========== Meta Tags ========== -->
    <meta charset="UTF-8">
    <meta name="description" content="Cocoon -Portfolio">
    <meta name="keywords" content="Cocoon , Portfolio">
    <meta name="author" content="Pharaohlab">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- ========== Title ========== -->
    <title>Janghyeon Jung</title>
    <!-- ========== Favicon Ico ========== -->
    <!--<link rel="icon" href="fav.ico">-->
    <!-- ========== STYLESHEETS ========== -->
    <!-- Bootstrap CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Fonts Icon CSS -->
    <link href="assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/et-line.css" rel="stylesheet">
    <link href="assets/css/ionicons.min.css" rel="stylesheet">
    <!-- Carousel CSS -->
    <link href="assets/css/slick.css" rel="stylesheet">
    <!-- Magnific-popup -->
    <link rel="stylesheet" href="assets/css/magnific-popup.css">
    <!-- Animate CSS -->
    <link rel="stylesheet" href="assets/css/animate.min.css">
    <!-- Custom styles for this template -->
    <link href="assets/css/main.css" rel="stylesheet">
</head>
<body>
<div class="loader">
    <div class="loader-outter"></div>
    <div class="loader-inner"></div>
</div>
<form action="admin/loginPost" method="post" id="loginForm">
    <div class="form-group label-floating">
        <label class="content_label">아이디</label><input name="userEmail" type="text" id="exampleInputEmail1" class="form-control" value="${cookie.rememberID.value}">
    </div>
    <div class="form-group label-floating">
        <label class="control-label">비밀번호</label> <input name="userPwd" type="password" id="exampleInputPassword1" class="form-control"></label>
    </div>
    <button type="submit" class="btn btn-default">로그인</button>
</form>

<!-- jquery -->
<script src="../../../assets/js/jquery.min.js"></script>
<!-- bootstrap -->
<script src="../../../assets/js/popper.js"></script>
<script src="../../../assets/js/bootstrap.min.js"></script>
<script src="../../../assets/js/waypoints.min.js"></script>
<!--slick carousel -->
<script src="../../../assets/js/slick.min.js"></script>
<!--Portfolio Filter-->
<script src="../../../assets/js/imgloaded.js"></script>
<script src="../../../assets/js/isotope.js"></script>
<!-- Magnific-popup -->
<script src="../../../assets/js/jquery.magnific-popup.min.js"></script>
<!--Counter-->
<script src="../../../assets/js/jquery.counterup.min.js"></script>
<!-- WOW JS -->
<script src="../../../assets/js/wow.min.js"></script>
<!-- Custom js -->
<script src="../../../assets/js/main.js"></script>
</body>
</html>