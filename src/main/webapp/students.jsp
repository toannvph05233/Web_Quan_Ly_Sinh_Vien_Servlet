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

  <title>Student Management Dashboard</title>
  <!-- Favicon icon -->
  <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
  <!-- Pignose Calender -->
  <link href="/plugins/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
  <!-- Chartist -->
  <link rel="stylesheet" href="/plugins/chartist/css/chartist.min.css">
  <link rel="stylesheet" href="/plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
  <!-- Custom Stylesheet -->
  <link href="/css/style.css" rel="stylesheet">

</head>

<body>

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
          <form action="/search" method="get" class="row">
            <input name="keyword" type="search" class="form-control col-8" placeholder="Search Students"
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
      <ul class="metismenu" id="menu">
        <li class="nav-label">Dashboard</li>
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
    </div>
  </div>

  <div class="content-body">
    <div class="container-fluid mt-3">
      <h1>Quản lý học viên của khoa : ${khoa.name}</h1>
      <div class="row">
        <div class="col-lg-12">
          <div class="card">
            <div class="card-body">
              <div class="active-member">
                <div class="table-responsive">
                  <h3>All Students</h3>
                  <br>
                  <table class="table table-xs mb-0">
                    <thead>
                    <tr>
                      <th>Name</th>
                      <th>SBD</th>
                      <th>Gender</th>
                      <th>Major</th>
                      <th>GPA</th>
                      <th>Birthday</th>
                      <th>Address</th>
                      <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="student" items="${students}">
                      <tr>
                        <td><img src="${student.avatar}" class="rounded-circle mr-3" alt=""
                                 height="50" width="60"><a href="/profile?id=${student.id}"> ${student.name}</a></td>
                        <td style="color: blue">${student.idCardNumber}</td>
                        <td>${student.gender}</td>
                        <td>${student.major}</td>
                        <td>${student.gpa}</td>
                        <td>${student.birthday}</td>
                        <td>${student.address}</td>
                        <td>
                          <c:choose>
                            <c:when test="${student.status}">
                              <span class="text-success">Active</span>
                            </c:when>
                            <c:otherwise>
                              <span class="text-danger">Inactive</span>
                            </c:otherwise>
                          </c:choose>
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
