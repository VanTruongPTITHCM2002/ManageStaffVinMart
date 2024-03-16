<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jstl/core_rt" prefix = "c" %>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.css">

<!-- sweetalert2 js -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert@2/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert@2/dist/sweetalert.min.css">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords"
        content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 5 admin, bootstrap 5, css3 dashboard, bootstrap 5 dashboard, Nice lite admin bootstrap 5 dashboard, frontend, responsive bootstrap 5 admin template, Nice admin lite design, Nice admin lite dashboard bootstrap 5 dashboard template">
    <meta name="description"
        content="Nice Admin Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
    <meta name="robots" content="noindex,nofollow">
    <title>Tài khoản nhân viên</title>
    <link rel="canonical" href="https://www.wrappixel.com/templates/niceadmin-lite/" />
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="resources2/assets/images/logo-vinmart-inkythuatso.png">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/resources2/assets/libs/chartist/dist/chartist.min.css" rel="stylesheet">
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
.alert-success {
  color: #155724;
  background-color: #d4edda;
  border-color: #c3e6cb;
}

.alert-danger {
  color: #721c24;
  background-color: #f8d7da;
  border-color: #f5c6cb;
}
 .table-responsive {
        overflow-y: auto;
        max-height: 300px;
    }

    .table-responsive table {
        width: 100%;
    }

    .table-responsive thead th {
        position: sticky;
        top: 0;
        background-color: white;
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
    <div id="main-wrapper" data-navbarbg="skin6" data-theme="light" data-layout="vertical" data-sidebartype="full"
        data-boxed-layout="full">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <header class="topbar" data-navbarbg="skin6">
            <nav class="navbar top-navbar navbar-expand-md navbar-light">
                <div class="navbar-header" data-logobg="skin5">
                    <!-- This is for the sidebar toggle which is visible on mobile only -->
                    <a class="nav-toggler waves-effect waves-light d-block d-md-none" href="javascript:void(0)">
                        <i class="ti-menu ti-close"></i>
                    </a>
                    <!-- ============================================================== -->
                    <!-- Logo -->
                    <!-- ============================================================== -->
                    <div class="navbar-brand">
                        <a href="#" class="logo">
                            <!-- Logo icon -->
                            <b class="logo-icon">
                                <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                                <!-- Dark Logo icon -->
                                <img src="${pageContext.request.contextPath}/resources/resources2/assets/images/logo-vinmart-inkythuatso.jpg" alt="homepage" class="dark-logo" />
                                <!-- Light Logo icon -->
                                <img src="${pageContext.request.contextPath}/resources/resources2/assets/images/logo-vinmart-inkythuatso.jpg" alt="homepage" class="light-logo" />
                            </b>
                            <!--End Logo icon -->
                            <!-- Logo text -->
                            <!-- <span class="logo-text">
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
                <div class="navbar-collapse collapse" id="navbarSupportedContent" data-navbarbg="skin6">
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav float-start me-auto">
                        <!-- ============================================================== -->
                        <!-- Search -->
                        <!-- ============================================================== -->
                        
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
                                     <a class="dropdown-item" href="doimatkhau.html" ><i class='fa fa-unlock' style='font-size:14px'></i>
                                    Đổi mật khẩu</a>
                                <a class="dropdown-item" href="home.html" ><i class="fa fa-sign-out" style="font-size:14px"></i>
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
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="homepage1.html"
                                aria-expanded="false">
                                <i class="fa fa-home"></i>
                                <span class="hide-menu">Trang chủ</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="manageaccount.html"
                                aria-expanded="false">
                              <i class="fa fa-user" aria-hidden="true"></i>
                                <span class="hide-menu">Quản lý tài khoản</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="pages-profile.html"
                                aria-expanded="false">
                                <i class="fa fa-id-card-o" aria-hidden="true"></i>
                                <span class="hide-menu">Quản lý nhân viên</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="form-basic.html"
                                aria-expanded="false">
                                <i class="mdi mdi-arrange-bring-forward"></i>
                                <span class="hide-menu">Quản lý bảng lương</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="table-basic.html"
                                aria-expanded="false">
                                <i class="mdi mdi-border-none"></i>
                                <span class="hide-menu">Quản lý hợp đồng lao động</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="thongbao.html"
                                aria-expanded="false">
                             <i class="mdi mdi-comment-processing"></i>
                                <span class="hide-menu">Quản lý thông báo</span>
                            </a>
                        </li> 
                            <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="quanlylichlamviec.html"
                                aria-expanded="false">
                                  <i class="mdi mdi-table-large"></i>
                                <span class="hide-menu">Quản lý lịch làm việc</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="starter-kit.html"
                                aria-expanded="false">
                               <i class="mdi mdi-briefcase-check"></i>
                                <span class="hide-menu">Quản lý chấm công</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="thongtincanhan.html"
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
    font-family: FontAwesome">Danh sách tài khoản</h4>
                <div class="row">
                    <div class="col-5 align-self-center">
                        
                    </div>
                    <div class="col-7 align-self-center">
                        <div class="d-flex align-items-center justify-content-end">                          									
                        </div>                       
                    </div>
                </div>
			</div>
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
						<span class="icon"><i class="fa fa-search"></i></span> <input onkeyup = "searchTable('search','table-account')"
							type="search" id="search" placeholder="Tìm kiếm thông tin nhân viên" style = "width:300px; margin-bottom: 10px"/>
					
				<!--<p id = "thongbaoloi" style = "color:red">${message}</p>-->
		<script>
    var message = "${mess}";
    if (message === "Tài khoản đã cập nhật thành công" || message === "Tài khoản đã thêm thành công" || message === "Tài khoản đã reset mật khẩu thành công") {
        swal({
            title: "Thông báo",
            text: message,
            icon: "success",
            button: "OK",
        });
    }
    else if (message === "Tài khoản đã tồn tại" || message === "Mã nhân viên chưa tạo"){
    	 swal({
             title: "Thông báo",
             text: message,
             icon: "error",
             button: "OK",
         });
    }
   
</script>
				<script>
				    // Lấy element chứa message
				    var messageDiv = document.getElementById("thongbaoloi");
				    // Nếu element tồn tại và có message
				    if (messageDiv != null && messageDiv.innerHTML.trim() != "") {
				        // Đóng message sau 5 giây
				        setTimeout(function() {
				            messageDiv.style.display = "none";
				        }, 2000); // thời gian đóng message (5 giây)
    					}
				</script>
                <!-- ============================================================== -->
                <!-- Email campaign chart -->
                <!-- ============================================================== -->
                
                      
                <!-- ============================================================== -->
                <!-- Email campaign chart -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Ravenue - page-view-bounce rate -->
                <!-- ============================================================== -->
                <div class="row">
                    <!-- column -->
                    <div class="col-12">
                        <div class="card">
                            <div class="table-responsive">
								<table class="table table-hover" id = "table-account">                        
                                    <thead>
                                        <tr>
                                            <th class="border-top-0">Tên tài khoản</th>                                            
                                            <th class="border-top-0">Trạng thái</th>   
                                            <th></th>                                         
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach var = "p" items = "${tk}">
                                        <tr>
                                            <td class="txt-oflo">${p.nhanvien.maNV}</td>                                                                                                                             
                                            <td class="txt-oflo">${p.trangThaiHoatDong()}</td> 
                                            <td><button style="float: right" id = "btncapnhattk" class= "modal-button" name = "btncn">
											<a href="#inform1">Cập nhật tài khoản</a>
											</button> </td>                                                                                                                                                 	                                     
                                       	</tr>
                                        </c:forEach>
                                    </tbody>
                                </table>                                                              
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- Ravenue - page-view-bounce rate -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Recent comment and chats -->
                <!-- ============================================================== -->
               <!--   <script>
  			window.onload = function() {
  		
    		document.getElementById("inform").style.display = "block";
  			}
	</script>
	-->
               
            <script>
            document.querySelector(".close").addEventListener("click", function() {
            	  document.getElementById("form-addcount").reset();
            	});

            
</script>
                    <script>
                    var addEmployeeBtn = document.querySelector('#btnthemtk');

                 // Thêm sự kiện click cho nút thêm nhân viên
                 addEmployeeBtn.addEventListener('click', function(event) {
                   event.preventDefault(); // Ngăn chặn mặc định hành vi chuyển hướng đến trang mới

                   // Hiển thị modal
                   var modal = document.querySelector('#inform');
                   modal.style.display = 'block';

                   // Thay đổi URL
                   window.history.pushState(null, null, '#inform');
                 });
                    </script>
                    
                      <script>
                    var addEmployeeBtn = document.querySelector('#btnthemtk');

                 // Thêm sự kiện click cho nút thêm nhân viên
                 addEmployeeBtn.addEventListener('click', function(event) {
                   event.preventDefault(); // Ngăn chặn mặc định hành vi chuyển hướng đến trang mới

                   // Hiển thị modal
                   var modal = document.querySelector('#inform');
                   modal.style.display = 'block';

                   // Thay đổi URL
                   window.history.pushState(null, null, '#inform');
                 });
                    </script>
                <!-- ============================================================== -->
                <!-- Recent comment and chats -->
                <!-- ============================================================== -->
            </div>
            
            <div class="modal" id = "inform1" onClick="stopCloseModal(event)">
                    <!-- Column -->
                    <!-- Column -->
                    <!-- Column -->
                    <div class="col-lg-8 col-xlg-9" style = "margin-left: 200px">
                        <div class="card">
                            <div class="card-body">
                                <form class="form-horizontal form-material mx-2" action = "manageaccount/add-account.html"  method="POST">                                    
                                   <span class="close" style = "float:right">&times;</span>
                                    <div class="form-group">
                                        <label class="col-md-12">Tên tài khoản</label>
                                        <div class="col-md-12">
                                            <input type="text" name = "id" id = "tentaikhoan"
                                                class="form-control form-control-line" readonly>
                                        </div>
                                    </div>
                                  
                                    <div class="form-group">
                                        <label class="col-md-12">Trạng thái</label>
                                        <div class="col-md-12">
                                            <select class="form-select shadow-none form-control-line"  name = "status" id = "adc">
                                                <option value = "True">Vẫn còn hoạt động</option>
                                                <option value = "False">Vô hiệu hóa</option>                                           
                                            </select>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-12">                                         
                                            <button class="btn btn-success text-white" type = "submit" name ="btnupdate-account">Cập nhật trạng thái</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                   
                    <script>
    // lấy phần Modal
 var btn = document.querySelectorAll("button.modal-button");

// All page modals
var modals = document.querySelectorAll('.modal');

// Get the <span> element that closes the modal
var spans = document.getElementsByClassName("close");

// When the user clicks the button, open the modal
for (var i = 0; i < btn.length; i++) {
 btn[i].onclick = function(e) {
    e.preventDefault();
    modal = document.querySelector(e.target.getAttribute("href"));
    modal.style.display = "block";
 }
}

// When the user clicks on <span> (x), close the modal
for (var i = 0; i < spans.length; i++) {
 spans[i].onclick = function() {
    for (var index in modals) {
      if (typeof modals[index].style !== 'undefined') modals[index].style.display = "none";    
    }
 }
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target.classList.contains('modal')) {
     for (var index in modals) {
      if (typeof modals[index].style !== 'undefined') modals[index].style.display = "none";    
     }
    }
}
</script>
<script>

function stopCloseModal(event) {
	  event.stopPropagation();
	}

</script>
<script>var updateButtons = document.querySelectorAll('.modal-button');

		// Lặp qua từng nút và thêm sự kiện "click"
		updateButtons.forEach(function(button) {
		  button.addEventListener('click', function() {
		    // Lấy thông tin của nhân viên đang được chọn
		    var row = this.closest('tr');
		    var tentk = row.querySelector('td:nth-child(1)').innerText;
		    document.getElementById('tentaikhoan').value = tentk;
		    var trangthai = row.querySelector('td:nth-child(2)').innerText.trim();
		    if (trangthai === 'Vẫn còn hoạt động') {
		      document.getElementById('adc').value = 'True';
		    } else if (trangthai === 'Vô hiệu hóa') {
		      document.getElementById('adc').value = 'False';
		    }
		  });
		});</script>
     <!-- ============================================================== -->
                <!-- Recent comment and chats -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            <footer class="footer text-center">
                All Rights Reserved by Nhóm 24. Designed and Developed by
                <a href="https://www.nhom24.com">Nhom24</a>.
            </footer>
            <!-- ============================================================== -->
            <!-- End footer -->
            <!-- ============================================================== -->
        </div>
       
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>
    </div>
    
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    <script src="${pageContext.request.contextPath}/resources/resources2/assets/libs/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/resources2/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/resources2/assets/extra-libs/sparkline/sparkline.js"></script>
    <!--Wave Effects -->
    <script src="${pageContext.request.contextPath}/resources/resources2/dist/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="${pageContext.request.contextPath}/resources/resources2/dist/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/resources2/dist/js/custom.min.js"></script>
    <script>function searchTable(inputId, tableId) {
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
		}</script>
    <!--This page JavaScript -->
    <!--chartis chart-->
    <script src="${pageContext.request.contextPath}/resources/resources2/assets/libs/chartist/dist/chartist.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/resources2/assets/libs/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/resources2/dist/js/pages/dashboards/dashboard1.js"></script>
</body>

</html>