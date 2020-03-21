<%--
  Created by IntelliJ IDEA.
  User: janghyeon
  Date: 2020/03/06
  Time: 7:28 오후
  admin page
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

    <div class="body-container container-fluid">
        <a class="menu-btn" href="javascript:void(0)">
            <i class="ion ion-grid"></i>
        </a>
        <div class="row justify-content-center">
            <div class="col-lg-2 col-md-3 col-12 menu_block">
            <!--=================== side menu ====================-->
            <!--logo -->
                <div class="logo_box">
                    <p style="font-size:24px; color:white; margin-left: 30px"; align="left"; >
                        Janghyeon Jung
                    </p>
                </div>
            <!--logo end-->

            <!--main menu -->
                <div class="side_menu_section">
                    <ul class="menu_nav">
                        <li>
                            <a href="..">
                                Return Home
                            </a>
                        </li>
                        <li>
                            <a href="upload">
                                Upload
                            </a>
                        </li>
                        <li>
                            <a href="categoryConfig">
                                Project Config
                            </a>
                        </li>
                        <li>
                            <a href="authConfig">
                                Auth Config
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-10 col-md-9 col-12 body_block  align-content-center">
                <div class="portfolio">
                    <div class="container-fluid">
                        <div class="grid img-container justify-content-center no-gutters">
                            <div class="grid-sizer col-sm-12 col-md-6 col-lg-3"></div>
                            <div class="grid-item col-sm-12 col-md-6 col-lg-3">
                                    <div class="project_box_one">
                                        <div class="product_info">
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>


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
