package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.KhenThuongKyLuatDAO;
import com.qlnv.model.KhenThuongKyLuat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/khenThuongKyLuat")
public class KhenThuongKyLuatServlet extends HttpServlet {
    KhenThuongKyLuatDAO khenThuongKyLuatDAO = new KhenThuongKyLuatDAO(ConnectMysql.getConnection());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStudent = req.getParameter("idStudent");
        String type = req.getParameter("type");
        String content = req.getParameter("content");
        KhenThuongKyLuat khenThuongKyLuat = new KhenThuongKyLuat();
        khenThuongKyLuat.setStudentId(Integer.parseInt(idStudent));
        khenThuongKyLuat.setType(type);
        khenThuongKyLuat.setContent(content);
        khenThuongKyLuat.setDate(new Date());
        khenThuongKyLuatDAO.addKhenThuongKyLuat(khenThuongKyLuat);
        resp.sendRedirect("/profile?id="+idStudent);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String idStudent = req.getParameter("idStudent");
        khenThuongKyLuatDAO.deleteKhenThuongKyLuat(Integer.parseInt(id));
        resp.sendRedirect("/profile?id="+idStudent);
    }
}
