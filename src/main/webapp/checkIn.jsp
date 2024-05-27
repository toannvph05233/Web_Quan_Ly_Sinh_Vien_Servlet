<%@ page import="java.util.List" %>
<%@ page import="com.qlnv.model.ChamCong" %>
<%@ page import="com.qlnv.model.BangLuong" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">

    <!-- theme meta -->
    <meta name="theme-name" content="quixlab"/>

    <title>Quixlab - Bootstrap Admin Dashboard Template by Themefisher.com</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
    <!-- Pignose Calender -->
    <link href="/plugins/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
    <!-- Chartist -->
    <link rel="stylesheet" href="/plugins/chartist/css/chartist.min.css">
    <link rel="stylesheet" href="/plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
    <!-- Custom Stylesheet -->
    <link href="/css/style.css" rel="stylesheet">
    <style>
        .emp-profile {
            padding: 3%;
            margin-top: 3%;
            margin-bottom: 3%;
            border-radius: 0.5rem;
            background: #fff;
        }

        .profile-img {
            text-align: center;
        }

        .profile-img img {
            width: 70%;
            height: 100%;
        }

        .profile-img .file {
            position: relative;
            overflow: hidden;
            margin-top: -20%;
            width: 70%;
            border: none;
            border-radius: 0;
            font-size: 15px;
            background: #212529b8;
        }

        .profile-img .file input {
            position: absolute;
            opacity: 0;
            right: 0;
            top: 0;
        }

        .profile-head h5 {
            color: #333;
        }

        .profile-head h6 {
            color: #0062cc;
        }

        .profile-edit-btn {
            border: none;
            border-radius: 1.5rem;
            width: 70%;
            padding: 2%;
            font-weight: 600;
            color: #6c757d;
            cursor: pointer;
        }

        .proile-rating {
            font-size: 12px;
            color: #818182;
            margin-top: 5%;
        }

        .proile-rating span {
            color: #495057;
            font-size: 15px;
            font-weight: 600;
        }

        .profile-head .nav-tabs {
            margin-bottom: 5%;
        }

        .profile-head .nav-tabs .nav-link {
            font-weight: 600;
            border: none;
        }

        .profile-head .nav-tabs .nav-link.active {
            border: none;
            border-bottom: 2px solid #0062cc;
        }

        .profile-work {
            padding: 14%;
            margin-top: -15%;
        }

        .profile-work p {
            font-size: 12px;
            color: #818182;
            font-weight: 600;
            margin-top: 10%;
        }

        .profile-work a {
            text-decoration: none;
            color: #495057;
            font-weight: 600;
            font-size: 14px;
        }

        .profile-work ul {
            list-style: none;
        }

        .profile-tab label {
            font-weight: 600;
        }

        .profile-tab p {
            font-weight: 600;
            color: #0062cc;
        }
    </style>
</head>

<body>


<!--**********************************
    Main wrapper start
***********************************-->
<div id="main-wrapper">
    <div class="nav-header">
        <div class="brand-logo">
            <a href="/nhanvien">
                <b class="logo-abbr"><img src="images/logo.png" alt=""> </b>
                <span class="logo-compact"><img
                        src="https://seeklogo.com/images/A/as-roma-logo-61DF23CC37-seeklogo.com.png" alt=""></span>
                <span class="brand-title">
                        <img style="width: 150px; height: 90px; object-fit: cover; margin-top: -30px"
                             src="https://seeklogo.com/images/A/as-roma-logo-61DF23CC37-seeklogo.com.png" alt="">
                    </span>
            </a>
        </div>
    </div>

    <div class="header">
        <div class="header-content clearfix">

            <div class="nav-control">
                <div class="hamburger">
                    <span class="toggle-icon"><i class="icon-menu"></i></span>
                </div>
            </div>
            <div class="header-left">
                <div class="input-group icons">
                    <div class="input-group-prepend">
                        <span class="input-group-text bg-transparent border-0 pr-2 pr-sm-3" id="basic-addon1"><i
                                class="mdi mdi-magnify"></i></span>
                    </div>
                    <form action="/nhanvien" class="row" method="post">
                        <input name="search" type="search" class="form-control col-8" placeholder="Search Dashboard"
                               aria-label="Search Dashboard">
                        <button class="btn-primary col-4" type="submit">Search</button>
                    </form>
                </div>
            </div>
            <div class="header-right">
                <ul class="clearfix">
                    <li class="icons dropdown d-none d-md-flex">
                        <a href="javascript:void(0)" class="log-user" data-toggle="dropdown">
                            <span>${sessionScope.account.username}</span> <i class="fa fa-angle-down f-s-14"
                                                                             aria-hidden="true"></i>
                        </a>
                    </li>
                    <li class="icons dropdown">
                        <div class="user-img c-pointer position-relative" data-toggle="dropdown">
                            <span class="activity active"></span>
                            <img src="${sessionScope.account.avatar}" height="40" width="40" alt="">
                        </div>
                        <div class="drop-down dropdown-profile animated fadeIn dropdown-menu">
                            <div class="dropdown-content-body">
                                <ul>
                                    <li>
                                        <a href="app-profile.html"><i class="icon-user"></i> <span>Profile</span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)">
                                            <i class="icon-envelope-open"></i> <span>Inbox</span>
                                            <div class="badge gradient-3 badge-pill gradient-1">3</div>
                                        </a>
                                    </li>

                                    <hr class="my-2">
                                    <li>
                                        <a href="page-lock.html"><i class="icon-lock"></i> <span>Lock Screen</span></a>
                                    </li>
                                    <li><a href="page-login.html"><i class="icon-key"></i> <span>Logout</span></a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="nk-sidebar">
        <div class="nk-nav-scroll">
            <ul class="metismenu" id="menu">
                <li class="nav-label">Dashboard</li>
                <li>
                    <a class="has-arrow" href="javascript:void(0)" aria-expanded="false">
                        <i class="icon-user menu-icon"></i><span class="nav-text">Nhân viên</span>
                    </a>
                    <ul aria-expanded="false">
                        <li><a href="/nhanvien">Tất cả</a></li>
                        <li><a href="/nhanvien?contract=false">Biên chế</a></li>
                        <li><a href="/nhanvien?contract=true">Hợp đồng</a></li>
                    </ul>
                </li>
                <li>
                    <br>
                    <a style="width: 80%; margin-left: 20px;" href="/createStaff" type="button" class="btn btn-success">Create
                        Staff</a>
                </li>


            </ul>
        </div>
    </div>

    <div class="content-body">
        <div class="container emp-profile">

            <div class="row">
                <div class="col-md-4">
                    <div class="profile-img">
                        <img src="${nhanVien.getAvatar()}" alt="" class="fixed-size-img"
                             style="width: 250px; height: 200px; object-fit: cover; "/>
                        <div class="file btn btn-lg btn-primary">
                            Change Photo
                            <input type="file" name="file"/>
                        </div>
                    </div>

                </div>
                <div class="col-md-6">
                    <div class="profile-head" style="padding-top: 40px">
                        <h4>
                            <c:out value="${nhanVien.getFullName()}"/>
                        </h4>
                        <c:forEach var="job" items="${jobs}">
                            <h5 style="color: #00cc66">Job Now : ${job.getJobDescription()}
                                - ${bangLuong.getContractType()}</h5>
                        </c:forEach>
                        <h5>
                            <c:out value="${nhanVien.getJobTitle()}"/>
                        </h5>
                        <h4 style="color: #1c75bc">Số ngày làm việc : ${checkins.size()}</h4>
                        <%
                            // Lấy giá trị từ Java
                            double estimatedSalary = ((List<ChamCong>) request.getAttribute("checkins")).size() * ((BangLuong) request.getAttribute("bangLuong")).getSalary() * ((BangLuong) request.getAttribute("bangLuong")).getSalaryGrade() * ((BangLuong) request.getAttribute("bangLuong")).getSalaryCoefficient() + ((BangLuong) request.getAttribute("bangLuong")).getAllowances() - ((BangLuong) request.getAttribute("bangLuong")).getInsurance();

                            // Định dạng số tiền
                            java.text.DecimalFormat df = new java.text.DecimalFormat("#,##0");
                            String formattedSalary = df.format(estimatedSalary);
                        %>
                        <h4 style="color: #1c75bc">Lương ước tính: <%= formattedSalary %> VND</h4>
                    </div>
                </div>
            </div>
            <hr>
        </div>
        <div class="col-lg-12">
            <div class="card">
                <div class="card-body">
                    <div class="active-member">
                        <div class="table-responsive">
                            <h3>Bảng lương</h3>
                            <br>
                            <table class="table table-xs mb-0">
                                <thead>
                                <tr>
                                    <th>Nhân viên</th>
                                    <th>Loại hợp đồng</th>
                                    <th>Bậc lương</th>
                                    <th>Hệ số tiền lương</th>
                                    <th>Phụ cấp</th>
                                    <th>Bảo hiểm</th>
                                    <th>Lương theo ngày</th>
                                    <th>Acction</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${bangLuong.getSalaryID() == 0}">
                                    <button type="button" class="btn btn-success" data-toggle="modal"
                                            data-target="#myModalCreate">Create
                                    </button>
                                </c:if>
                                <c:if test="${bangLuong.getSalaryID() != 0}">
                                    <tr>
                                        <td><img src="${nhanVien.getAvatar()}" class=" rounded-circle mr-3"
                                                 alt=""><a style="color: #0e4cfd"
                                                           href="/profile?id=${nhanVien.getEmployeeID()}">${nhanVien.getFullName()}</a>
                                        </td>
                                        <td>${bangLuong.getContractType()}</td>
                                        <td>
                                            <span>${bangLuong.getSalaryGrade()}</span>
                                        </td>
                                        <td>
                                            <span>${bangLuong.getSalaryCoefficient()}</span>
                                        </td>
                                        <td>
                                            <span>${bangLuong.getAllowances()}</span>
                                        </td>
                                        <td>
                                            <span>${bangLuong.getInsurance()}</span>
                                        </td>
                                        <td>
                                            <span>${bangLuong.getSalary()}</span>
                                        </td>
                                        <td>
                                            <button class="btn btn-warning" data-toggle="modal" data-target="#myModal">
                                                Edit
                                            </button>
                                            </span>
                                        </td>
                                    </tr>
                                </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container-fluid mt-3">
            <div class="row">
                <div class="col-lg-6">
                    <div class="card">
                        <div class="card-body">
                            <h3>CheckIn Now</h3>
                            <c:choose>
                                <c:when test="${nhanVien.isCheckIn()}">
                                    <button type="submit" class="btn btn-success">Đã CheckIn</button>
                                </c:when>
                                <c:otherwise>
                                    <form method="post">
                                        <button type="submit" class="btn btn-success">CheckIn</button>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="card">
                        <div class="card-body">
                            <div class="active-member">
                                <div class="table-responsive">
                                    <h3>My CheckIn</h3>
                                    <table class="table table-xs mb-0">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Date</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="c" items="${checkins}" varStatus="loop">
                                            <tr>

                                                <td>${loop.count}</td>
                                                <td>
                                                    <span>${c.getAttendanceDate()}</span>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
        <!-- #/ container -->
    </div>

    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Modal Header</h4>
                </div>
                <form action="/bangCong" method="post">
                    <div class="modal-body">
                        <input name="EmployeeID" hidden="hidden" value="${nhanVien.getEmployeeID()}">
                        <input name="SalaryID" hidden="hidden" value="${bangLuong.getSalaryID()}">
                        ContractType: <select name="ContractType">
                        <option value="Biên chế">Biên chế</option>
                        <option value="Hợp đồng">Hợp đồng</option>
                    </select><br>
                        SalaryGrade : <input name="SalaryGrade" value="${bangLuong.getSalaryGrade()}"><br>
                        SalaryCoefficient: <input name="SalaryCoefficient"
                                                  value="${bangLuong.getSalaryCoefficient()}"><br>
                        Allowances: <input name="Allowances" value="${bangLuong.getAllowances()}"><br>
                        Insurance: <input name="Insurance" value="${bangLuong.getInsurance()}"><br>
                        SalaryDay :<input name="Salary" value="${bangLuong.getSalary()}"><br>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-warning">Edit</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>

        </div>
    </div>

    <div class="modal fade" id="myModalCreate" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Modal Create</h4>
                </div>
                <form action="/bangCong" method="post">
                    <div class="modal-body">
                        <input name="EmployeeID" hidden="hidden" value="${nhanVien.getEmployeeID()}">
                        ContractType: ContractType: <select name="ContractType">
                        <option value="Biên chế">Biên chế</option>
                        <option value="Hợp đồng">Hợp đồng</option>
                    </select><br>
                        SalaryGrade : <input name="SalaryGrade"><br>
                        SalaryCoefficient: <input name="SalaryCoefficient"><br>
                        Allowances: <input name="Allowances"><br>
                        Insurance: <input name="Insurance"><br>
                        SalaryDay :<input name="Salary"><br>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-success">Create</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
    <div class="footer">
        <div class="copyright">
            <p>Copyright &copy; Designed & Developed by <a href="https://themeforest.net/user/quixlab">Quixlab</a> 2018
            </p>
        </div>
    </div>
</div>


<!--**********************************
    Scripts
***********************************-->
<script src="/plugins/common/common.min.js"></script>
<script src="/js/custom.min.js"></script>
<script src="/js/settings.js"></script>
<script src="/js/gleek.js"></script>
<script src="/js/styleSwitcher.js"></script>

<!-- Chartjs -->
<script src="/plugins/chart.js/Chart.bundle.min.js"></script>
<!-- Circle progress -->
<script src="/plugins/circle-progress/circle-progress.min.js"></script>
<!-- Datamap -->
<script src="/plugins/d3v3/index.js"></script>
<script src="/plugins/topojson/topojson.min.js"></script>
<script src="/plugins/datamaps/datamaps.world.min.js"></script>
<!-- Morrisjs -->
<script src="/plugins/raphael/raphael.min.js"></script>
<script src="/plugins/morris/morris.min.js"></script>
<!-- Pignose Calender -->
<script src="/plugins/moment/moment.min.js"></script>
<script src="/plugins/pg-calendar/js/pignose.calendar.min.js"></script>
<!-- ChartistJS -->
<script src="/plugins/chartist/js/chartist.min.js"></script>
<script src="/plugins/chartist-plugin-tooltips/js/chartist-plugin-tooltip.min.js"></script>


<script src="/js/dashboard/dashboard-1.js"></script>

</body>

</html>
