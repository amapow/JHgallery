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
<h1>비밀번호 확인</h1>
<form action="BoardServlet" name="frm" method="get">
    <input type="hidden" name="command" value="board_check_pass">
    <input type="hidden" name="num" value="${param.num}">

    <!--boardView.jsp의  "게시글 수정" 부분에
                onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}')
                부분에서 num값을 보낸것을 param(.$.{.}.EL에서 키를 지정하지않은 파라메타)으로 받는다
                /> -->

    <table>
        <tr>
            <th>password</th>
            <td>
                <input type="password" name="pass" size="20">
            </td>
        </tr>
    </table>
    <input type="submit" value="확인" onclick="return passCheck()">
    <a href="admin"></a>
    </input>

    <!--  BoardCheckPassAction에 request영역의
    setAttribyte로 ("message","비밀번호가 틀렸습니다.")의 키와 값을
     주어 "비밀번호가 틀렸습니다 출력"-->

</form>
<div class="loader">
    <div class="loader-outter"></div>
    <div class="loader-inner"></div>
</div>
<div class="body-container container-fluid">
    <a class="menu-btn" href="javascript:void(0)">
        <i class="ion ion-grid"></i>
    </a>
    <!-- row justify-content-left는 왼쪽 정렬 div -->
    <!--=================== content body ====================-->
    <div class="col-lg-10 col-md-9 col-12 body_block  align-content-center">
        <div class="portfolio">
            <div class="container-fluid">
                <!--=================== masaonry portfolio start====================-->
                <div class="grid img-container justify-content-center no-gutters">
                    <div class="grid-sizer col-sm-12 col-md-6 col-lg-3"></div>
                    <div class="grid-item  branding architecture  col-sm-12 col-md-6 col-lg-3">
                        <a href="../assets/img/home/1.jpg"/>
                            <div class="admin_box_one">
                                <img src="../assets/img/home/1.jpg"/><!-- alt="pro1" />-->
                                <div class="product_info">
                                    <%--                                        <div class="product_info_text">--%>
                                    <%--                                            <!----%>
                                    <%--                                            <div class="product_info_text_inner">--%>
                                    <%--                                                <i class="ion ion-plus"></i>--%>
                                    <%--                                                <h4>project name</h4>--%>
                                    <%--                                            </div>--%>
                                    <%--                                            -->--%>
                                    <%--                                        </div>--%>
                                </div>
                            </div>

                    </div>
                    <div class="grid-item  branding architecture  col-sm-12 col-md-6 col-lg-3">
                        <a href="../assets/img/home/2.jpg">
                            <div class="project_box_one">
                                <img src="../assets/img/home/2.jpg" alt="pro1" />
                                <div class="product_info">
                                    <%--                                        <div class="product_info_text">--%>
                                    <%--                                            <!----%>
                                    <%--                                            <div class="product_info_text_inner">--%>
                                    <%--                                                <i class="ion ion-plus"></i>--%>
                                    <%--                                                <h4>project name</h4>--%>
                                    <%--                                            </div>--%>
                                    <%--                                            -->--%>
                                    <%--                                        </div>--%>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="grid-item  design col-sm-12 col-md-6 col-lg-3">
                        <a href="assets/img/home/3.jpg">
                            <div class="project_box_one">
                                <img src="assets/img/home/3.jpg" alt="pro1" />
                                <div class="product_info">
                                    <%--                                        <div class="product_info_text">--%>
                                    <%--                                            <!----%>
                                    <%--                                            <div class="product_info_text_inner">--%>
                                    <%--                                                <i class="ion ion-plus"></i>--%>
                                    <%--                                                <h4>project name</h4>--%>
                                    <%--                                            </div>--%>
                                    <%--                                            -->--%>
                                    <%--                                        </div>--%>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="grid-item  photography design col-sm-12 col-md-6 col-lg-3">
                        <a href="assets/img/home/4.jpg">
                            <div class="project_box_one">
                                <img src="assets/img/home/4.jpg" alt="pro1" />
                                <div class="product_info">
                                    <%--                                        <div class="product_info_text">--%>
                                    <%--                                            <div class="product_info_text_inner">--%>
                                    <%--                                                <i class="ion ion-plus"></i>--%>
                                    <%--                                                <h4>project name</h4>--%>
                                    <%--                                            </div>--%>
                                    <%--                                        </div>--%>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="grid-item  branding photography  col-sm-12 col-md-6 col-lg-3">
                        <a href="assets/img/home/5.jpg">
                            <div class="project_box_one">
                                <img src="assets/img/home/5.jpg" alt="pro1" />
                                <div class="product_info">
                                    <%--                                        <div class="product_info_text">--%>
                                    <%--                                            <div class="product_info_text_inner">--%>
                                    <%--                                                <i class="ion ion-plus"></i>--%>
                                    <%--                                                <h4>project name</h4>--%>
                                    <%--                                            </div>--%>
                                    <%--                                        </div>--%>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="grid-item   architecture design col-sm-12 col-md-6 col-lg-3">
                        <a href="https://live.staticflickr.com/4861/31204864377_e0ab400d9c_h.jpg">
                            <div class="project_box_one">
                                <img width="340px"; src="https://live.staticflickr.com/4861/31204864377_e0ab400d9c_h.jpg" alt="pro1" />
                                <div class="product_info">
                                    <%--                                        <div class="product_info_text">--%>
                                    <%--                                            <div class="product_info_text_inner">--%>
                                    <%--                                                <i class="ion ion-plus"></i>--%>
                                    <%--                                                <h4>project name</h4>--%>
                                    <%--                                            </div>--%>
                                    <%--                                        </div>--%>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="grid-item  photography architecture col-sm-12 col-md-6 col-lg-3">
                        <a href="assets/img/home/7.jpg">
                            <div class="project_box_one">
                                <img src="assets/img/home/7.jpg" alt="pro1" />
                                <div class="product_info">
                                    <%--                                        <div class="product_info_text">--%>
                                    <%--                                            <div class="product_info_text_inner">--%>
                                    <%--                                                <i class="ion ion-plus"></i>--%>
                                    <%--                                                <h4>project name</h4>--%>
                                    <%--                                            </div>--%>
                                    <%--                                        </div>--%>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="grid-item  branding design  col-sm-12 col-md-6 col-lg-3">
                        <a href="assets/img/home/8.jpg">
                            <div class="project_box_one">
                                <img src="assets/img/home/8.jpg" alt="pro1" />
                                <div class="product_info">
                                    <%--                                        <div class="product_info_text">--%>
                                    <%--                                            <div class="product_info_text_inner">--%>
                                    <%--                                                <i class="ion ion-plus"></i>--%>
                                    <%--                                                <h4>project name</h4>--%>
                                    <%--                                            </div>--%>
                                    <%--                                        </div>--%>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="grid-item architecture  col-sm-12 col-md-6 col-lg-3">
                        <a href="assets/img/home/9.jpg">
                            <div class="project_box_one">
                                <img width="340px"; src="assets/img/home/9.jpg" alt="pro1" />
                                <div class="product_info">
                                    <%--                                        <div class="product_info_text">--%>
                                    <%--                                            <div class="product_info_text_inner">--%>
                                    <%--                                                <i class="ion ion-plus"></i>--%>
                                    <%--                                                <h4>project name</h4>--%>
                                    <%--                                            </div>--%>
                                    <%--                                        </div>--%>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="grid-item architecture  col-sm-12 col-md-6 col-lg-3">
                        <a href="https://live.staticflickr.com/1927/46191320502_776092f3c7_h.jpg">
                            <div class="project_box_one">
                                <img width="340px"; src="https://live.staticflickr.com/1927/46191320502_776092f3c7_h.jpg" alt="pro1" />
                                <div class="product_info">
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="grid-item architecture  col-sm-12 col-md-6 col-lg-3">
                        <a href="https://live.staticflickr.com/4839/46007759942_d6d454bddd_h.jpg">
                            <div class="project_box_one">
                                <img width="340px"; src="https://live.staticflickr.com/4839/46007759942_d6d454bddd_h.jpg" alt="pro1" />
                                <div class="product_info">
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="grid-item architecture  col-sm-12 col-md-6 col-lg-3">
                        <a href="https://live.staticflickr.com/4811/31204856837_a476326df4_h.jpg">
                            <div class="project_box_one">
                                <img width="340px"; src="https://live.staticflickr.com/4811/31204856837_a476326df4_h.jpg" alt="pro1" />
                                <div class="product_info">
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
                <!--=================== masaonry portfolio end====================-->
            </div>
        </div>
    </div>
</div>

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
