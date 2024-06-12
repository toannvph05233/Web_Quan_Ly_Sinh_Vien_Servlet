package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.StudentDAO;
import com.qlnv.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/admin/student")
public class AdminServlet extends HttpServlet {

    StudentDAO studentDAO = new StudentDAO(ConnectMysql.getConnection());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        if (search == null){
            search = "";
        }
        String status = req.getParameter("status");
        List<Student> students = new ArrayList<>();
        if (status == null){
            students = studentDAO.getAll(search);
        }else if (status.equals("true")){
            students = studentDAO.getAllByType(true);
        }else {
            students = studentDAO.getAllByType(false);
        }
        req.setAttribute("students", students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<NhanVien> nhanVienCheckIns = new ArrayList<>();
//        List<NhanVien> nhanVienNoCheckIns = new ArrayList<>();
//        List<NhanVien> nhanViens = new ArrayList<>();
//        String search = req.getParameter("search");
//        nhanViens = studentDAO.searchNhanVien(search);
//        filterStaff(nhanVienCheckIns,nhanVienNoCheckIns,nhanViens);
//
//        req.setAttribute("nhanVienCheckIns", nhanVienCheckIns);
//        req.setAttribute("nhanVienNoCheckIns", nhanVienNoCheckIns);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
//        dispatcher.forward(req, resp);

    }


//    public void filterStaff(List<NhanVien> nhanVienCheckIns,List<NhanVien> nhanVienNoCheckIns, List<NhanVien> nhanViens){
//        for (NhanVien nv : nhanViens) {
//            if (chamCongDAO.getChamCongByEmployeeIDAndDate(nv.getEmployeeID(), new Date()) != null) {
//                nv.setCheckIn(true);
//                nhanVienCheckIns.add(nv);
//            } else {
//                nhanVienNoCheckIns.add(nv);
//            }
//        }
//    }
}
