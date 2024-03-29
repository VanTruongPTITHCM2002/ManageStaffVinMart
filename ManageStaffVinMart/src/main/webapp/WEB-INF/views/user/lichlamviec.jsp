<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<script src="https://cdn.jsdelivr.net/npm/sweetalert@2/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert@2/dist/sweetalert.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords"
	content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 5 admin, bootstrap 5, css3 dashboard, bootstrap 5 dashboard, Nice lite admin bootstrap 5 dashboard, frontend, responsive bootstrap 5 admin template, Nice admin lite design, Nice admin lite dashboard bootstrap 5 dashboard template">
<meta name="description"
	content="Nice Admin Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
<meta name="robots" content="noindex,nofollow">
<title>Nhân viên</title>
<link rel="canonical"
	href="https://www.wrappixel.com/templates/niceadmin-lite/" />
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="${pageContext.request.contextPath}/resources/resources2/assets/images/logo-vinmart-inkythuatso.png">
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/resources/resources2/dist/css/style.min.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<style>
	.modal {
	display: none; /* mặc định được ẩn đi */
	position: fixed; /* vị trí cố định */
	z-index: 1; /* Ưu tiên hiển thị trên cùng */
	padding-top: 100px;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgb(0, 0, 0);
	background-color: rgba(0, 0, 0, 0.4);
	margin-left: 200px;
}
.box {
	margin: 100px auto;
	width: 300px;
	height: 50px;
}

.table#table-employee {
  border-collapse: collapse;
  width: 100%;
}

.table#table-employee th,
.table#table-employee td {
  padding: 8px;
  text-align: left;
 
}

.table#table-employee td {
  width: 10%; /* thay đổi độ rộng của cột tại đây */
}

</style>
</head>

<body>
	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper" data-navbarbg="skin6" data-theme="light"
		data-layout="vertical" data-sidebartype="full"
		data-boxed-layout="full">
		
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<header class="topbar" data-navbarbg="skin6">
			<nav class="navbar top-navbar navbar-expand-md navbar-light">
				<div class="navbar-header" data-logobg="skin5">
					<!-- This is for the sidebar toggle which is visible on mobile only -->
					<a class="nav-toggler waves-effect waves-light d-block d-md-none"
						href="javascript:void(0)"> <i class="ti-menu ti-close"></i>
					</a>
					<!-- ============================================================== -->
					<!-- Logo -->
					<!-- ============================================================== -->
					<div class="navbar-brand">
						<a href="#" class="logo"> <!-- Logo icon --> <b
							class="logo-icon"> <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
								<!-- Dark Logo icon --> <img
								src="${pageContext.request.contextPath}/resources/resources2/assets/images/logo-vinmart-inkythuatso.jpg"
								alt="" class="dark-logo"> <!-- Light Logo icon --> <img
								src="${pageContext.request.contextPath}/resources/resources2/assets/images/logo-vinmart-inkythuatso.jpg"
								alt="" class="light-logo">
						</b> <!--End Logo icon --> <!-- Logo text --> <!-- <span class="logo-text">
                                dark Logo text
                                <img src="resources2/assets/images/logo-text.png" alt="homepage" class="dark-logo" />
                                Light Logo text
                                <img src="resources2/assets/images/logo-light-text.png" class="light-logo" alt="homepage" />
                            </span> -->
						</a>
					</div>
					<!-- ============================================================== -->
					<!-- End Logo -->
					<!-- ============================================================== -->
					<!-- ============================================================== -->
					<!-- Toggle which is visible on mobile only -->
					<!-- ============================================================== -->

				</div>
				<!-- ============================================================== -->
				<!-- End Logo -->
				<!-- ============================================================== -->
				<div class="navbar-collapse collapse" id="navbarSupportedContent"
					data-navbarbg="skin6">
					<!-- ============================================================== -->
					<!-- toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav float-start me-auto">
						<!-- ============================================================== -->
						<!-- Search -->
						<!-- ============================================================== -->
						<li class="nav-item search-box">
							</li>
					</ul>
					<!-- ============================================================== -->
					<!-- Right side toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav float-end">
						<!-- ============================================================== -->
						<!-- User profile and search -->
						<!-- ============================================================== -->
						<li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <img src="${pageContext.request.contextPath}/resources/resources2/assets/images/users/1.jpg" alt="admin" class="rounded-circle" width="31">
                            </a>
                            
                            <ul class="dropdown-menu dropdown-menu-end user-dd animated" aria-labelledby="navbarDropdown">
                                 <a class="dropdown-item" href="thongtincanhan.html" ><i class="fa fa-info-circle" style="font-size:14px"></i>
                                    Thông tin cá nhân</a>
                                    <a class="dropdown-item" href="changepassword.html" ><i class='fa fa-unlock' style='font-size:14px'></i>
                                    Đổi mật khẩu</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/home.html" ><i class="fa fa-sign-out" style="font-size:14px"></i>
                                    Đăng xuất</a>
                            </ul>
                        </li>
						<!-- ============================================================== -->
						<!-- User profile and search -->
						<!-- ============================================================== -->
					</ul>
				</div>
			</nav>
		</header>
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		 <aside class="left-sidebar" data-sidebarbg="skin5">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                    <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="trangchu.html"
                                aria-expanded="false">
                               <i class="fa fa-home"></i>
                                <span class="hide-menu">Trang chủ</span>
                            </a>
                        </li>                                        
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="bangluong.html"
                                aria-expanded="false">
                                <i class="mdi mdi-arrange-bring-forward"></i>
                                <span class="hide-menu">Bảng lương</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="hopdonglaodong.html"
                                aria-expanded="false">
                                <i class="mdi mdi-border-none"></i>
                                <span class="hide-menu">Hợp đồng lao động</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="thongbao.html"
                                aria-expanded="false">
                                <i class="mdi mdi-comment-processing"></i>
                                <span class="hide-menu">Thông báo</span>
                            </a>
                        </li> 
                            <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="lichlamviec.html"
                                aria-expanded="false">
                                 <i class="mdi mdi-table-large"></i>
                                <span class="hide-menu">Lịch làm việc</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="chamcong.html"
                                aria-expanded="false">
                                <i class="mdi mdi-briefcase-check"></i>
                                <span class="hide-menu">Chấm công</span>
                            </a>
                        </li>
                         <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="inform_staff.html"
                                aria-expanded="false">
                               <i class="mdi mdi-information-outline"></i>
                                <span class="hide-menu">Thông tin cá nhân</span>
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb">
				<h4 class="page-title" style = "margin-left: 45%;
    font-size: 25px;
    color: orangered;
    font-family: FontAwesome">Lịch làm việc</h4>
				<div class="row">
					<div class="col-5 align-self-center">
						
					</div>
				</div>
			</div>
			<div></div>
			<!-- ============================================================== -->
			<!-- End Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">
			<span class="icon"><i class="fa fa-search"></i></span> <input onkeyup = "searchTable('search-lichlamviec','table-lichlamviec')"
							type="search" id="search-lichlamviec" placeholder="Tìm kiếm thông tin lịch làm việc" style = "width:300px;margin-bottom:10px"/>
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
					  <div class="row">
					<div class="col-12">
						<div class="card">							
							<div class="table-responsive">
								<table class="table" id = "table-lichlamviec">
									<thead>
										<tr>											
											<th scope="col">Mã nhân viên</th>
											<th scope="col">Ngày làm việc</th>
											<th scope="col">Giờ bắt đầu</th>
											<th scope="col">Giờ kết thúc</th>											
										</tr>
									</thead>
									<tbody>
									<c:forEach var = "p" items = "${user_llv}">
										<tr>											
											<td>${p.manhanvien.maNV}</td>
											<td>${p.ngayLam}</td>
											<td>${p.gioBatDau}</td>
											<td>${p.gioKetThuc}</td>											
										</tr>
									</c:forEach>	
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
		</div>
					
					
	
	<script src="${pageContext.request.contextPath}/resources/resources2/assets/libs/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/resources2/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<!-- slimscrollbar scrollbar JavaScript -->
	<script src="${pageContext.request.contextPath}/resources/resources2/assets/extra-libs/sparkline/sparkline.js"></script>
	<!--Wave Effects -->
	<script src="${pageContext.request.contextPath}/resources/resources2/dist/js/waves.js"></script>
	<!--Menu sidebar -->
	<script src="${pageContext.request.contextPath}/resources/resources2/dist/js/sidebarmenu.js"></script>
	<!--Custom JavaScript -->
	<script src="${pageContext.request.contextPath}/resources/resources2/dist/js/custom.min.js"></script>
	<script>
	function searchTable(inputId, tableId) {
		  let input = document.getElementById(inputId);
		  let table = document.getElementById(tableId);
		  let rows = table.getElementsByTagName("tr");
		  input.addEventListener("keyup", function () {
		    let value = input.value.toLowerCase();
		    for (let i = 1; i < rows.length; i++) {
		      let show = false;
		      let cells = rows[i].getElementsByTagName("td");
		      for (let j = 0; j < cells.length; j++) {
		        let cell = cells[j];
		        if (cell.innerHTML.toLowerCase().indexOf(value) > -1) {
		          show = true;
		          break;
		        }
		      }
		      if (show) {
		        rows[i].style.display = "";
		      } else {
		        rows[i].style.display = "none";
		      }
		    }
		  });
		}
	</script>
</body>

</html>