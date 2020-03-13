<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%--<%@ taglib prefix="sec" uri="http://java.sun.com/jsp/jstl/core"%>--%>
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
                            Archive
                        </a>
                    </li>
                    <div class="side_menu_section">
                        <h4 class="side_title"><b>Project</b></h4>
                        <ul  id="filtr-container"  class="filter_nav">
                            <li data-filter=".OMC"> <a href="javascript:void(0)">Old man's cave</a></li>
                            <li data-filter=".TLR"><a href="javascript:void(0)">The last romance in SEOUL</a></li>
                            <li data-filter=".NULL"><a href="javascript:void(0)">NULL</a></li>
                            <li data-filter=".Untitled"><a href="javascript:void(0)">Untitled</a></li>
                        </ul>
                    </div>
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


                    <li>
                        <sec:authorize access = "hasRole('ROLE_ADMIN')">
                            <a href = /admin>Admin</a>
                        </sec:authorize>
                    </li>
                </ul>
            </div>
            <!--main menu end -->

<%--            <!--filter menu -->--%>
<%--            <div class="side_menu_section">--%>
<%--                <h4 class="side_title">filter by:</h4>--%>
<%--                <ul  id="filtr-container"  class="filter_nav">--%>
<%--                    <li  data-filter="*" class="active"><a href="javascript:void(0)" >all</a></li>--%>
<%--                    <li data-filter=".branding"> <a href="javascript:void(0)">branding</a></li>--%>
<%--                    <li data-filter=".design"><a href="javascript:void(0)">design</a></li>--%>
<%--                    <li data-filter=".photography"><a href="javascript:void(0)">photography</a></li>--%>
<%--                    <li data-filter=".architecture"><a href="javascript:void(0)">architecture</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--            <!--filter menu end -->--%>

            <!--social and copyright -->
            <div class="side_menu_bottom">
                <ul class="menu_nav">
                <li>
                    <a href="contact">
                        Contact
                    </a>
                </li>
                </ul>
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
                        <p class="copyright">Copyright &copy;
                            <script>
                                document.write(new Date().getFullYear());
                            </script>,
                            <sec:authorize access="isAnonymous()">
                                <a href = /login>Janghyeon Jung</a>
                            </sec:authorize>
                            <sec:authorize access ="isAuthenticated()">
                                <a href = /logout>Janghyeon Jung</a>
                            </sec:authorize>
                            All rights reserved</br>with Colorlib
                        </p>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </div>
            <!--social and copyright end -->

        </div>
        <!--=================== side menu end====================-->

        <!--=================== content body ====================-->
<%--        <div class="col-lg-10 col-md-9 col-12 body_block  align-content-center">--%>
<%--            <div class="portfolio">--%>
<%--                <div class="container-fluid">--%>
<%--                    <!--=================== masaonry portfolio start====================-->--%>
<%--&lt;%&ndash;                    <div class="grid img-container justify-content-center no-gutters">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="grid-sizer col-sm-12 col-md-6 col-lg-3"></div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="grid-item branding  col-sm-12 col-md-6 col-lg-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a href="assets/img/home/1.jpg"> <!--title="project name 1">-->&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <div class="project_box_one">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <img src="assets/img/home/1.jpg"/><!-- alt="pro1" />-->&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <div class="product_info">&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        <div class="product_info_text">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            <!--&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            <div class="product_info_text_inner">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <i class="ion ion-plus"></i>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <h4>project name</h4>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            -->&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="grid-item  branding architecture  col-sm-12 col-md-6 col-lg-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a href="assets/img/home/2.jpg">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <div class="project_box_one">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <img src="assets/img/home/2.jpg" alt="pro1" />&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <div class="product_info">&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        <div class="product_info_text">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            <!--&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            <div class="product_info_text_inner">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <i class="ion ion-plus"></i>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <h4>project name</h4>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            -->&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="grid-item  design col-sm-12 col-md-6 col-lg-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a href="assets/img/home/3.jpg">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <div class="project_box_one">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <img src="assets/img/home/3.jpg" alt="pro1" />&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <div class="product_info">&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        <div class="product_info_text">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            <!--&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            <div class="product_info_text_inner">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <i class="ion ion-plus"></i>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <h4>project name</h4>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            -->&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="grid-item  photography design col-sm-12 col-md-6 col-lg-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a href="assets/img/home/4.jpg">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <div class="project_box_one">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <img src="assets/img/home/4.jpg" alt="pro1" />&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <div class="product_info">&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        <div class="product_info_text">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            <div class="product_info_text_inner">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <i class="ion ion-plus"></i>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <h4>project name</h4>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="grid-item  branding photography  col-sm-12 col-md-6 col-lg-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a href="assets/img/home/5.jpg">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <div class="project_box_one">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <img src="assets/img/home/5.jpg" alt="pro1" />&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <div class="product_info">&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        <div class="product_info_text">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            <div class="product_info_text_inner">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <i class="ion ion-plus"></i>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <h4>project name</h4>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="grid-item   architecture design col-sm-12 col-md-6 col-lg-3">&ndash;%&gt;--%>
<!--                            <a href="https://live.staticflickr.com/4861/31204864377_e0ab400d9c_h.jpg">-->
<%--                                <div class="project_box_one">--%>
<%--                                    <img width="340px"; src="https://live.staticflickr.com/4861/31204864377_e0ab400d9c_h.jpg" alt="pro1" />--%>
<%--                                    <div class="product_info">--%>
<%--                                        <div class="product_info_text">--%>
<!---->
        <%--                                            <div class="product_info_text_inner">--%>
<%--                                                <i class="ion ion-plus"></i>--%>
<%--                                                <h4>project name</h4>--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="grid-item  photography architecture col-sm-12 col-md-6 col-lg-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a href="assets/img/home/7.jpg">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <div class="project_box_one">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <img src="assets/img/home/7.jpg" alt="pro1" />&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <div class="product_info">&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        <div class="product_info_text">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            <div class="product_info_text_inner">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <i class="ion ion-plus"></i>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <h4>project name</h4>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="grid-item  branding design  col-sm-12 col-md-6 col-lg-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a href="assets/img/home/8.jpg">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <div class="project_box_one">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <img src="assets/img/home/8.jpg" alt="pro1" />&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <div class="product_info">&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        <div class="product_info_text">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            <div class="product_info_text_inner">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <i class="ion ion-plus"></i>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <h4>project name</h4>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="grid-item architecture  col-sm-12 col-md-6 col-lg-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a href="assets/img/home/9.jpg">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <div class="project_box_one">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <img width="340px"; src="assets/img/home/9.jpg" alt="pro1" />&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <div class="product_info">&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        <div class="product_info_text">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            <div class="product_info_text_inner">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <i class="ion ion-plus"></i>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                                <h4>project name</h4>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                            </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;                                        </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="grid-item architecture  col-sm-12 col-md-6 col-lg-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a href="https://live.staticflickr.com/1927/46191320502_776092f3c7_h.jpg">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <div class="project_box_one">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <img width="340px"; src="https://live.staticflickr.com/1927/46191320502_776092f3c7_h.jpg" alt="pro1" />&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <div class="product_info">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="grid-item architecture  col-sm-12 col-md-6 col-lg-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a href="https://live.staticflickr.com/4839/46007759942_d6d454bddd_h.jpg">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <div class="project_box_one">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <img width="340px"; src="https://live.staticflickr.com/4839/46007759942_d6d454bddd_h.jpg" alt="pro1" />&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <div class="product_info">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="grid-item architecture  col-sm-12 col-md-6 col-lg-3">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a href="https://live.staticflickr.com/4811/31204856837_a476326df4_h.jpg">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <div class="project_box_one">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <img width="340px"; src="https://live.staticflickr.com/4811/31204856837_a476326df4_h.jpg" alt="pro1" />&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <div class="product_info">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="col-lg-10 col-md-9 col-12 body_block  align-content-center">
            <div class="portfolio">
                <div class="container-fluid">
                    <%
                        {
                            ArrayList<String> mediumList = (ArrayList<String>)request.getAttribute("mediumModel");
                            ArrayList<String> largeList = (ArrayList<String>)request.getAttribute("largeModel");
                            ArrayList<String> titleList = (ArrayList<String>)request.getAttribute("titleModel");
                    %>
                    <div class="grid img-container justify-content-center no-gutters">
                        <div class="grid-sizer col-sm-12 col-md-6 col-lg-3"></div>
                        <%
                            for(int i = 0 ; i < mediumList.size() ; i++) {
                        %>
                        <div class="grid-item <%out.print(titleList.get(i));%> col-sm-12 col-md-6 col-lg-3">

                            <a href="<%out.print(largeList.get(i));%>"> <!--title="project name 1">-->
                                <div class="project_box_one">
                                    <img src="<%out.print(mediumList.get(i));%>"/><!-- alt="pro1" />-->
                                    <div class="product_info">
                                    </div>
                                </div>
                            </a>
                        </div>
                        <%}}%>
                    </div>
                </div>
            </div>
        </div>
        <!--=================== masaonry portfolio end====================-->
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
<!-- Custom js -->
<script src="assets/js/main.js"></script>
</body>
</html>