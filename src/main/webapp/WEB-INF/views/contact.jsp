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
        <!--=================== side menu ====================-->
        <div class="col-lg-2 col-md-3 col-12 menu_block">

            <!--logo -->
            <div class="logo_box">
                <p style="font-size:24px; color:white; margin-left: 30px"; align="left"; >
                    <!--鄭長賢 -->
                    Janghyeon Jung
                </p>

            </div>
            <!--logo end-->

            <!--main menu -->
            <div class="side_menu_section">
                <ul class="menu_nav">
                    <li>
                        <a href="home">
                            Home
                        </a>
                    </li>
<%--                    <li>--%>
<%--                        <a href="about">--%>
<%--                            About Us--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                    <li>--%>
<%--                        <a href="portfolio">--%>
<%--                            Portfolio--%>
<%--                        </a>--%>
<%--                    </li>--%>
                    <!--
                    <li>
                        <a href="blog">
                            Blog
                        </a>
                    </li>
                    -->
                    <li  class="active">
                        <a href="contact">
                            Contact
                        </a>
                    </li>
                </ul>
            </div>
            <!--main menu end -->

            <!--social and copyright -->
            <div class="side_menu_bottom">
                <div class="side_menu_bottom_inner">
                    <ul class="social_menu">
                        <li>
                            <a href="https://www.instagram.com/suit_hyeon/"> <i class="ion ion-social-instagram"></i> </a>
                        </li>
                        <li>
                            <a href="https://amapow.github.io/"> <i class="ion ion-social-github"></i> </a>
                        </li>
                    </ul>
                    <div class="copy_right">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        <p class="copyright">Copyright &copy;<script>document.write(new Date().getFullYear());</script>, Janghyeon Jung All rights reserved | with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="admin" target="_blank">Colorlib</a></p>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </div>
            <!--social and copyright end -->

        </div>
        <!--=================== side menu end====================-->

        <!--=================== content body ====================-->
        <div class="col-lg-10 col-md-9 col-12 body_block  align-content-center">
            <div>
                <div class="img_card">
                    <div class="row justify-content-center">
                        <div class="col-md-6 col-7 content_section">
                            <!--=================== contact info and form start====================-->
                            <div class="content_box">
                                <div class="content_box_inner">
                                    <div>
                                        <h3>
                                            Janghyeon Jung
                                        </h3>
<%--                                        <p>--%>
<%--                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur leo est, feugiat nec elementum id, suscipit id nulla. Nulla sit amet luctus dolor. Etiam finibus consequat ante ac congue.--%>
<%--                                        </p>--%>

                                        <ul class="nosyely_list pt50">
<%--                                            <li>--%>
<%--                                                <div class="img_box_two">--%>
<%--                                                    <img src="assets/img/icons/satelite.png" alt="info list">--%>
<%--                                                    <div class="content align-items-center">--%>
<%--                                                        <p>--%>
<%--                                                            Rosia Road , No234/56<br/>--%>
<%--                                                            Gibraltar , UK--%>
<%--                                                        </p>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                            </li>--%>
                                            <li>
                                                <div class="img_box_two">
                                                    <img src="assets/img/icons/scheme.png" alt="info list">
                                                    <div class="content align-items-center">
                                                        <p>
                                                            amapow25@gmail.com
                                                        </p>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="img_box_two">
                                                    <img src="assets/img/icons/smartphone.png" alt="info list">
                                                    <div class="content align-items-center">
                                                        <p>
                                                            +112
                                                        </p>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                                    <form method = "POST" action = sendmail>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                        <div class="mt75 row justify-content-center">
                                            <div class="col-lg-6 col-12">
                                                <input name="name" type="text" placeholder="Name" class="form-control">
                                            </div>
                                            <div class="col-lg-6 col-12">
                                                <input name="eemail" type="email" placeholder="E-Mail" class="form-control">
                                            </div>
                                            <div class="col-12">
                                                <input name="subject" type="text" placeholder="Subject" class="form-control">
                                            </div>
                                            <div class="col-12">
                                                <textarea name="text" placeholder="Massage" class="form-control" cols="4" rows="4"></textarea>
                                            </div>
                                            <div class="col-12">
                                                <button name="sendmail" value = "sendmail" type="mail" class="btn btn-primary">Send</button>
                                            </div>
                                        </div>
                                    </form>
                                    </div>
                                </div>
                            </div>
                            <!--=================== contact info and form end====================-->
                        </div>
<%--                        <div class="col-md-6 col-5 img_section" style="background-color:#000;">--%>
<%--                            <!--map -->--%>
<%--                            <div id="map" data-lon="24.036176" data-lat=" 57.039986" class="map"></div>--%>
<%--                            <!--map end-->--%>
<%--                        </div>--%>
                    </div>
                </div>
            </div>
        </div>
        <!--=================== content body end ====================-->
    </div>
</div>



<!-- jquery -->
<script src="assets/js/jquery.min.js"></script>
<!-- bootstrap -->
<script src="assets/js/popper.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/waypoints.min.js"></script>
<!--slick carousel -->
<script src="assets/js/slick.min.js"></script>
<!--Portfolio Filter-->
<script src="assets/js/imgloaded.js"></script>
<script src="assets/js/isotope.js"></script>
<!-- Magnific-popup -->
<script src="assets/js/jquery.magnific-popup.min.js"></script>
<!--Counter-->
<script src="assets/js/jquery.counterup.min.js"></script>
<!-- WOW JS -->
<script src="assets/js/wow.min.js"></script>
<!--map -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAuahgsm_qfH1F3iywCKzZNMdgsCfnjuUA"></script>
<!-- Custom js -->
<script src="assets/js/main.js"></script>
</body>
</html>