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
    <link href="./plugins/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
    <!-- Chartist -->
    <link rel="stylesheet" href="./plugins/chartist/css/chartist.min.css">
    <link rel="stylesheet" href="./plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
    <!-- Custom Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
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

<!--*******************
    Preloader start
********************-->
<div id="preloader">
    <div class="loader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10"/>
        </svg>
    </div>
</div>
<!--*******************
    Preloader end
********************-->


<!--**********************************
    Main wrapper start
***********************************-->
<div id="main-wrapper">


    <div class="nav-header">
        <div class="brand-logo">
            <!-- Logo can be added here -->
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
                    <form action="/students" method="get" class="row">
                        <input name="search" type="search" class="form-control col-8" placeholder="Search Students"
                               aria-label="Search Students">
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
                                    <li><a href="app-profile.html"><i class="icon-user"></i> <span>Profile</span></a>
                                    </li>
                                    <li><a href="javascript:void(0)"><i class="icon-envelope-open"></i>
                                        <span>Inbox</span></a></li>
                                    <hr class="my-2">
                                    <li><a href="page-lock.html"><i class="icon-lock"></i> <span>Lock Screen</span></a>
                                    </li>
                                    <li><a href="/login"><i class="icon-key"></i> <span>Logout</span></a></li>
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
            <c:if test="${sessionScope.account.role == 'admin'}">
                <ul class="metismenu" id="menu">
                    <li class="nav-label">Dashboard Admin</li>
                    <li>
                        <a class="has-arrow" href="javascript:void(0)" aria-expanded="false">
                            <i class="icon-user menu-icon"></i><span class="nav-text">Students</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="/admin/student">All Students</a></li>
                            <li><a href="/admin/student?status=true">Active</a></li>
                            <li><a href="/admin/student?status=false">Inactive</a></li>
                        </ul>
                    </li>
                    <li>
                        <br>
                        <a style="width: 80%; margin-left: 20px;" href="/createStudent" type="button"
                           class="btn btn-success">Create Student</a>
                    </li>


                </ul>
            </c:if>
            <c:if test="${sessionScope.account.role == 'gv'}">
                <ul class="metismenu" id="menu">
                    <li class="nav-label">Dashboard Giảng Viên</li>
                    <li>
                        <a class="has-arrow" href="javascript:void(0)" aria-expanded="false">
                            <i class="icon-user menu-icon"></i><span class="nav-text">Students</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="/students?status=true">Active</a></li>
                            <li><a href="/students?status=false">Inactive</a></li>
                        </ul>
                    </li>
                </ul>
            </c:if>
        </div>
    </div>

    <div class="content-body">

        <div class="container emp-profile">

            <div class="row">
                <div class="col-md-4">
                    <div class="profile-img">
                        <img src="${student.getAvatar()}" alt="" class="fixed-size-img"
                             style="width: 250px; height: 250px; object-fit: cover;"/>
                        <%--                        <div class="file btn btn-lg btn-primary">--%>
                        <%--                            Change Photo--%>
                        <%--                            <input type="file" name="file"/>--%>
                        <%--                        </div>--%>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="profile-head">
                        <h5>
                            Họ Tên :${student.getName()}
                        </h5>
                        <h6>
                            Ngành Học : ${student.getMajor()}
                        </h6>
                        <p class="proile-rating">GPA : <span>${student.getGpa()}</span></p>
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab"
                                   aria-controls="home" aria-selected="true">About</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-2">
                    <c:if test="${sessionScope.account.role == 'admin'}">
                        <button class="profile-edit-btn" name="btnAddMore">Edit Profile</button>
                    </c:if>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">

                </div>
                <div class="col-md-8">
                    <div class="tab-content profile-tab" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Số báo danh</label>
                                </div>
                                <div class="col-md-6">
                                    <p>${student.getIdCardNumber()}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Họ và tên</label>
                                </div>
                                <div class="col-md-6">
                                    <p>${student.getName()}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Giới tính</label>
                                </div>
                                <div class="col-md-6">
                                    <p>${student.getGender()}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Ngày sinh</label>
                                </div>
                                <div class="col-md-6">
                                    <p>${student.getBirthday()}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Chuyên ngành</label>
                                </div>
                                <div class="col-md-6">
                                    <p>${student.getMajor()}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Địa chỉ</label>
                                </div>
                                <div class="col-md-6">
                                    <p>${student.getAddress()}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Edit Student Modal -->
                    <div class="modal fade" id="editStudentModal" tabindex="-1" role="dialog"
                         aria-labelledby="editStudentModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <form action="/editStudent" method="post" enctype="multipart/form-data">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="editStudentModalLabel">Edit Student</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <input type="hidden" name="id" value="${student.getId()}">
                                        <div class="form-group">
                                            <label for="name">Name</label>
                                            <input type="text" class="form-control" id="name" name="name"
                                                   value="${student.getName()}" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="idCardNumber">ID Card Number</label>
                                            <input type="text" class="form-control" id="idCardNumber"
                                                   name="idCardNumber" value="${student.getIdCardNumber()}" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="gender">Gender</label>
                                            <input type="text" class="form-control" id="gender" name="gender"
                                                   value="${student.getGender()}" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="birthday">Birthday</label>
                                            <input type="date" class="form-control" id="birthday" name="birthday"
                                                   value="${student.getBirthday()}" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="idKhoa">Khoa</label>
                                            <select name="idKhoa" id="idKhoa">
                                                <c:forEach var="khoa" items="${khoaList}">
                                                    <option value="${khoa.id}">${khoa.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label for="address">Address</label>
                                            <input type="text" class="form-control" id="address" name="address"
                                                   value="${student.getAddress()}" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="gpa">GPA</label>
                                            <input type="number" step="0.01" class="form-control" id="gpa" name="gpa"
                                                   value="${student.getGpa()}" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="status">Status</label>
                                            <select class="form-control" id="status" name="status" required>
                                                <option value="true" ${student.isStatus() ? "selected" : ""}>Active
                                                </option>
                                                <option value="false" ${!student.isStatus() ? "selected" : ""}>
                                                    Inactive
                                                </option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="avatar">Avatar</label>
                                            <input type="file" class="form-control-file" id="avatar" name="avatar">
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                        </button>
                                        <button type="submit" class="btn btn-primary">Save changes</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>


        <div class="container emp-profile">
            <div class="row">
                <h3 style="color: #00cc66">Danh sách khen thưởng</h3>
                <c:if test="${sessionScope.account.role == 'admin'}">
                    <button data-toggle="modal" data-target="#myModal" style="margin-left:50px" type="button" class="btn btn-primary">Create</button>
                </c:if>
                <div class="col-md-1"></div>
                <div class="col-md-10">
                    <div class="tab-content profile-tab">
                        <hr>
                        <c:forEach items="${khenThuongList}" var="ktkl">
                            <div class="row mb-3">
                                <div class="col-md-3">
                                    <strong>Ngày:</strong>
                                </div>
                                <div class="col-md-9">
                                    <p>${ktkl.getDate()}</p>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-3">
                                    <strong>Nội dung:</strong>
                                </div>
                                <div class="col-md-9">
                                    <p>${ktkl.getContent()}</p>
                                </div>
                            </div>
                            <a href="/khenThuongKyLuat?id=${ktkl.id}&&idStudent=${student.id}">Delete</a>
                            <hr>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-1"></div>
            </div>
        </div>


        <div class="container emp-profile">
            <div class="row">
                <h3 style="color: red">Danh sách kỷ luật</h3>
                <c:if test="${sessionScope.account.role == 'admin'}">
                    <button data-toggle="modal" data-target="#myModal" style="margin-left:50px" type="button" class="btn btn-primary">Create</button>
                </c:if>
                <div class="col-md-1"></div>
                <div class="col-md-10">
                    <div class="tab-content profile-tab">
                        <hr>
                        <c:forEach items="${kyLuatList}" var="ktkl">
                            <div class="row mb-3">
                                <div class="col-md-3">
                                    <strong>Ngày:</strong>
                                </div>
                                <div class="col-md-9">
                                    <p>${ktkl.getDate()}</p>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-3">
                                    <strong>Nội dung:</strong>
                                </div>
                                <div class="col-md-9">
                                    <p>${ktkl.getContent()}</p>
                                </div>
                            </div>
                            <a href="/khenThuongKyLuat?id=${ktkl.id}&&idStudent=${student.id}">Delete</a>
                            <hr>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-1"></div>
            </div>
        </div>
        <div class="modal" id="myModal">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form action="/khenThuongKyLuat" method="post" >
                        <div class="modal-header">
                            <h5 class="modal-title">Tạo Khen Thưởng Kỷ Luật</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" name="idStudent" value="${student.getId()}">

                            <div class="form-group">
                                <label for="type">Khoa</label>
                                <select name="type" id="type">
                                        <option value="kt">Khen thưởng</option>
                                        <option value="kl">Kỷ luật</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="content">Nội dung</label>
                                <input type="text" class="form-control" id="content" name="content"
                                       placeholder="nhập nội dung">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                            </button>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<!--**********************************
    Main wrapper end
***********************************-->

<!--**********************************
    Scripts
***********************************-->
<script src="./plugins/common/common.min.js"></script>
<script src="./js/custom.min.js"></script>
<script src="./js/settings.js"></script>
<script src="./js/gleek.js"></script>
<script src="./js/styleSwitcher.js"></script>
<script>
    document.querySelector('.profile-edit-btn').addEventListener('click', function () {
        $('#editStudentModal').modal('show');
    });
</script>

</body>
</html>
