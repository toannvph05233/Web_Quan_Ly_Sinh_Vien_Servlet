package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.KhenThuongKyLuatDAO;
import com.qlnv.dao.KhoaDAO;
import com.qlnv.dao.StudentDAO;
import com.qlnv.model.KhenThuongKyLuat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/profile")
public class ProfileStudentServlet extends HttpServlet {
    StudentDAO studentDAO = new StudentDAO(ConnectMysql.getConnection());
    KhenThuongKyLuatDAO khenThuongKyLuatDAO = new KhenThuongKyLuatDAO(ConnectMysql.getConnection());
    KhoaDAO khoaDAO = new KhoaDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idS = Integer.parseInt(req.getParameter("id"));
        List<KhenThuongKyLuat> khenThuongList = khenThuongKyLuatDAO.getKhenThuongKyLuatByStudentId(idS,"kt");
        List<KhenThuongKyLuat> kyLuatList = khenThuongKyLuatDAO.getKhenThuongKyLuatByStudentId(idS,"kl");
        req.setAttribute("khenThuongList", khenThuongList);
        req.setAttribute("kyLuatList", kyLuatList);
        req.setAttribute("student", studentDAO.findByID(idS));
        req.setAttribute("khoaList", khoaDAO.getAllKhoa());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(req,resp);
    }
}
