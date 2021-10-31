<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContent.request.contextPath}" />
<!--
=========================================================
 Light Bootstrap Dashboard - v2.0.1
=========================================================

 Product Page: https://www.creative-tim.com/product/light-bootstrap-dashboard
 Copyright 2019 Creative Tim (https://www.creative-tim.com)
 Licensed under MIT (https://github.com/creativetimofficial/light-bootstrap-dashboard/blob/master/LICENSE)

 Coded by Creative Tim

=========================================================

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.  -->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="${contextPath}/resources/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="${contextPath}/resources/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>TrustLab</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <!-- CSS Files -->
    <link href="${contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${contextPath}/resources/assets/css/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="${contextPath}/resources/assets/css/demo.css" rel="stylesheet" />
</head>

<body>
    <div class="wrapper">
        <div class="sidebar" data-image="${contextPath}/resources/assets/img/sidebar-5.jpg">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

        Tip 2: you can also add an image using data-image tag
    -->
            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="/dashboard" class="simple-text">
                        TrustLab Company
                    </a>
                </div>
                <ul class="nav">
                    <li>
                        <a class="nav-link" href="/dashboard">
                            <i class="nc-icon nc-chart-pie-35"></i>
                            <p>Dashboard</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="/user">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>User Profile</p>
                        </a>
                    </li>
                    <li >
                        <a class="nav-link" href="/department">
                            <i class="nc-icon nc-bag"></i>
                            <p>Phòng Ban</p>
                        </a>
                    </li >
                    <li class="nav-item active">
                        <a class="nav-link" href="/employee">
                            <i class="nc-icon nc-badge"></i>
                            <p>Nhân Viên</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="main-panel">
            <!-- Navbar -->
               <!-- Navbar -->
            <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/"> Dashboard </a>
                    <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-bar burger-lines"></span>
                        <span class="navbar-toggler-bar burger-lines"></span>
                        <span class="navbar-toggler-bar burger-lines"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                        <ul class="nav navbar-nav ">
                            <li class="nav-item">
                                <a href="#" class="nav-link" data-toggle="dropdown">
                                    <span class="d-lg-none">Dashboard</span>
                                </a>
                            </li>
                           <li class="nav-item" style ="float:right;" >
                                <a class="nav-link" href="/user">
                                    <button type="button" class="btn btn btn-dark" >Hello ${pageContext.request.userPrincipal.name}</button>
                                </a>
                            </li>
                            <li class="nav-item" style ="float:right;" >
                                <a class="nav-link" href="/logout">
                                    <button type="button" class="btn btn btn-danger" >Log out</button>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<form:form action="/department/${departmentName}/employee/save" modelAttribute="employee"
									method="POST">
									<div class="card-header card-header-primary">
										<h4 class="card-title">Thông Tin Nhân Viên</h4>
										<p class="card-category">Vui lòng nhập đầy đủ thông tin nhân viên</p>
									</div>
									<div class="card-body">
											<div class="row">
												<div class="col-md-12"  hidden = "True" >
													<div class="form-group" >
														<label class="bmd-label-floating">id</label>
														<form:input type="text" path="id" class="form-control" readonly = "True" required = "true"></form:input>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-5">
													<div class="form-group">
														<label class="bmd-label-floating">Họ & Tên</label>
														<form:input type="text" path="fullName" class="form-control" required = "true"></form:input>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label>Ngày Sinh</label>
														<form:input type="date" path="dob" class="form-control" required = "true"></form:input>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label class="bmd-label-floating">CMND/CCCD</label>
														<form:input type="text" path="personalID" class="form-control" required = "true"></form:input>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
														<label class="bmd-label-floating">Địa Chỉ</label>
														<form:input type="text" path="address" class="form-control" required = "true"></form:input>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<label>Ngày Bắt Đầu</label>
														<form:input type="date" path="startDate" class="form-control" value="${curdate}"></form:input>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label>Ngày Nghỉ Việc</label>
														<form:input type="date" path="endDate" class="form-control" readonly = "true"></form:input>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label class="">Trình Độ Học Vấn</label>
														<form:select path="educationalLevel" class="form-control" required="required" >
															<form:option value="None" label="-- None --" />
															<form:option value="Tiểu học" label="Tiểu học" />
															<form:option value="Trung học cơ sơ" label="Trung học cơ sơ" />
															<form:option value="Trung học phổ thông" label="Trung học phổ thông" />
															<form:option value="Đại học" label="Đại học" />
															<form:option value="Sau đại học" label="Sau đại học" />
														</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label class="">Trình Độ Tiếng Anh</label>
														<form:select path="englishLevel" class="form-control" required="required">
															<form:option value="None" label="-- None --" />
															<form:option value="A1: Căn bản" label="A1: Căn bản (Tốt nghiệp cấp I)" />
															<form:option value="A2: Sơ cấp" label="A2: Sơ cấp (Tốt nghiệp cấp II)" />
															<form:option value="B1: Trung cấp" label="B1: Trung cấp (Tốt nghiệp cấp III và tốt nghiệp đại học không chuyên ngữ)" />
															<form:option value="B2: Trung cao cấp" label="B2: Trung cao cấp (Tốt nghiệp cao đẳng chuyên ngữ)" />
															<form:option value="C1: Cao cấp" label="C1: Cao cấp (Tốt nghiệp đại học chuyên ngữ)" />
															<form:option value="C2: Thành thạo." label="C2: Thành thạo." />
														</form:select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label class="">Trình Độ Tin Học</label>
														<form:select path="informaticsLevel" class="form-control" required="required">
															<form:option value="None" label="-- None --" />
															<form:option value="CNTT cơ bản" label="CNTT cơ bản" />
															<form:option value="CNTT nâng cao" label="CNTT nâng cao" />
															<form:option value="Tin học quốc tế MOS" label="Tin học quốc tế MOS" />
															<form:option value="Tin học quốc tế IC3" label="Tin học quốc tế IC3" />
														</form:select>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
														<label class="bmd-label-floating">Thành Tích Công Việc</label>
														<form:input type="text" path="workAchievement" class="form-control"></form:input>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<label class="bmd-label-floating">Phòng Ban</label>
														<form:select path="departmentID" class="form-control" >
															<c:forEach items="${list_department}" var="department" >
																<form:option value="${department.id}" label="${department.departmentName}"/>
															</c:forEach>
														</form:select>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="bmd-label-floating" >Chức Vụ</label>
														<form:select path="positionID" class="form-control">
															<c:forEach items="${list_position}" var="position" >
																<form:option value="${position.positionCode}" label="${position.positionName}"/>
															</c:forEach>
														</form:select>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<div class="form-group" >
														<button type="submit" class="btn btn-primary">
															<c:out value="${tin_nhan}"></c:out>
														</button>
														<button type="submit" class="btn btn-danger"
															href="/employee"
															onclick="return confirm('Bạn chắc chắn muốn ngừng thực hiện tác vụ không ?')">Cancel</button>
													</div>
												</div>
											</div>
										</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
            <footer class="footer">
                <div class="container-fluid">
                    <nav>
                        <ul class="footer-menu">
                            <li>
                                <a href="#">
                                    Home
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Company
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Portfolio
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Blog
                                </a>
                            </li>
                        </ul>
                        <p class="copyright text-center">
                            ©
                            <script>
                                document.write(new Date().getFullYear())
                            </script>
                            <a href="https://www.facebook.com/hades2808/">TuanPhan</a>, made with love for a better web
                        </p>
                    </nav>
                </div>
            </footer>
        </div>
    </div>
    <!--   -->
    <!-- <div class="fixed-plugin">
    <div class="dropdown show-dropdown">
        <a href="#" data-toggle="dropdown">
            <i class="fa fa-cog fa-2x"> </i>
        </a>

        <ul class="dropdown-menu">
			<li class="header-title"> Sidebar Style</li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Background Image</p>
                    <label class="switch">
                        <input type="checkbox" data-toggle="switch" checked="" data-on-color="primary" data-off-color="primary"><span class="toggle"></span>
                    </label>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger background-color">
                    <p>Filters</p>
                    <div class="pull-right">
                        <span class="badge filter badge-black" data-color="black"></span>
                        <span class="badge filter badge-azure" data-color="azure"></span>
                        <span class="badge filter badge-green" data-color="green"></span>
                        <span class="badge filter badge-orange" data-color="orange"></span>
                        <span class="badge filter badge-red" data-color="red"></span>
                        <span class="badge filter badge-purple active" data-color="purple"></span>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="header-title">Sidebar Images</li>

            <li class="active">
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="${contextPath}/resources/assets/img/sidebar-1.jpg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="${contextPath}/resources/assets/img/sidebar-3.jpg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="..//assets/img/sidebar-4.jpg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="${contextPath}/resources/assets/img/sidebar-5.jpg" alt="" />
                </a>
            </li>

            <li class="button-container">
                <div class="">
                    <a href="http://www.creative-tim.com/product/light-bootstrap-dashboard" target="_blank" class="btn btn-info btn-block btn-fill">Download, it's free!</a>
                </div>
            </li>

            <li class="header-title pro-title text-center">Want more components?</li>

            <li class="button-container">
                <div class="">
                    <a href="http://www.creative-tim.com/product/light-bootstrap-dashboard-pro" target="_blank" class="btn btn-warning btn-block btn-fill">Get The PRO Version!</a>
                </div>
            </li>

            <li class="header-title" id="sharrreTitle">Thank you for sharing!</li>

            <li class="button-container">
				<button id="twitter" class="btn btn-social btn-outline btn-twitter btn-round sharrre"><i class="fa fa-twitter"></i> · 256</button>
                <button id="facebook" class="btn btn-social btn-outline btn-facebook btn-round sharrre"><i class="fa fa-facebook-square"></i> · 426</button>
            </li>
        </ul>
    </div>
</div>
 -->
</body>
<!--   Core JS Files   -->
<script src="${contextPath}/resources/assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="${contextPath}/resources/assets/js/plugins/bootstrap-switch.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!--  Chartist Plugin  -->
<script src="${contextPath}/resources/assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="${contextPath}/resources/assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="${contextPath}/resources/assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="${contextPath}/resources/assets/js/demo.js"></script>

</html>
