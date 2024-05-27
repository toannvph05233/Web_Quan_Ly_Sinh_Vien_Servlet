//package com.qlnv.controller;
//
//import com.qlnv.connectSQL.ConnectMysql;
//import com.qlnv.dao.StudentDAO;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/dismissal")
//public class DismissalStudentServlet extends HttpServlet {
//    StudentDAO studentDAO = new StudentDAO(ConnectMysql.getConnection());
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int idNV = Integer.parseInt(req.getParameter("id"));
//        studentDAO.dismissalNhanVien(idNV);
//        resp.sendRedirect("/nhanvien");
//    }
//}
