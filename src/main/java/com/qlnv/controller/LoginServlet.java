package com.qlnv.controller;

import com.qlnv.dao.AccountDao;
import com.qlnv.model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    AccountDao accountDao = new AccountDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mess = req.getParameter("mess");
        if (mess != null){
            mess = "Sai tài khoản or mật khẩu";
            req.setAttribute("mess", mess);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = accountDao.checklogin(username,password);
        if (account!= null){
            HttpSession session = req.getSession();
            session.setAttribute("account",account);
            resp.sendRedirect("/nhanvien");
        } else {
            resp.sendRedirect("/login?mess=error");

        }
    }
}
