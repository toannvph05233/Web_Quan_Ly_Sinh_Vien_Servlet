package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.KhenThuongKyLuatDAO;
import com.qlnv.dao.KhoaDAO;
import com.qlnv.dao.StudentDAO;
import com.qlnv.model.Account;
import com.qlnv.model.KhenThuongKyLuat;
import com.qlnv.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/students")
public class StudentServlet extends HttpServlet {

    StudentDAO studentDAO = new StudentDAO(ConnectMysql.getConnection());
    KhoaDAO khoaDAO = new KhoaDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            resp.sendRedirect("/login");
            return;
        }
        String status = req.getParameter("status");
        List<Student> students = new ArrayList<>();
        if (status == null) {
            students = studentDAO.findByIdKhoaAndStatus(account.getIdKhoa(), true);
        } else if (status.equals("true")) {
            students = studentDAO.findByIdKhoaAndStatus(account.getIdKhoa(), true);
        } else {
            students = studentDAO.findByIdKhoaAndStatus(account.getIdKhoa(), false);
        }
        req.setAttribute("students", students);
        req.setAttribute("khoa", khoaDAO.getKhoaById(Integer.parseInt(account.getIdKhoa().trim())));
        RequestDispatcher dispatcher = req.getRequestDispatcher("students.jsp");
        dispatcher.forward(req, resp);
    }
}
