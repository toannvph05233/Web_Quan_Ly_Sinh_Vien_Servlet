package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.KhenThuongKyLuatDAO;
import com.qlnv.dao.StudentDAO;
import com.qlnv.model.KhenThuongKyLuat;
import com.qlnv.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/tracuu")
public class TraCuuServlet  extends HttpServlet {
    KhenThuongKyLuatDAO khenThuongKyLuatDAO = new KhenThuongKyLuatDAO(ConnectMysql.getConnection());
    StudentDAO studentDAO = new StudentDAO(ConnectMysql.getConnection());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sbd = req.getParameter("sbd");
        Student student = studentDAO.findByIdCardNumber(sbd);
        List<KhenThuongKyLuat> khenThuongList = khenThuongKyLuatDAO.getKhenThuongKyLuatByStudentId(student.getId(),"kt");
        List<KhenThuongKyLuat> kyLuatList = khenThuongKyLuatDAO.getKhenThuongKyLuatByStudentId(student.getId(),"kl");
        req.setAttribute("khenThuongList", khenThuongList);
        req.setAttribute("kyLuatList", kyLuatList);
        req.setAttribute("student", student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("tracuu.jsp");
        dispatcher.forward(req, resp);
    }
}
