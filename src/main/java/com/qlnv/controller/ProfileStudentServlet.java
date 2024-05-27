package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.KhoaDAO;
import com.qlnv.dao.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/profile")
public class ProfileStudentServlet extends HttpServlet {
    StudentDAO studentDAO = new StudentDAO(ConnectMysql.getConnection());
    KhoaDAO khoaDAO = new KhoaDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idNV = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("student", studentDAO.findByID(idNV));
        req.setAttribute("khoaList", khoaDAO.getAllKhoa());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(req,resp);
    }
}
