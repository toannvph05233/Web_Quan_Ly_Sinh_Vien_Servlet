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

@WebServlet(urlPatterns = "/tracuu")
public class TraCuuServlet  extends HttpServlet {
    StudentDAO studentDAO = new StudentDAO(ConnectMysql.getConnection());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sbd = req.getParameter("sbd");
        Student student = studentDAO.findByIdCardNumber(sbd);
        req.setAttribute("student", student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("tracuu.jsp");
        dispatcher.forward(req, resp);
    }
}
