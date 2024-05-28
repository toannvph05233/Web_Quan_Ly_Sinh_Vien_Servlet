package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.StudentDAO;
import com.qlnv.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/editStudent")
@MultipartConfig
public class EditStudentServlet extends HttpServlet {
    private StudentDAO studentDAO; // Assume you have a DAO class to handle database operations

    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAO(ConnectMysql.getConnection());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String major = request.getParameter("major");
        String sbd = request.getParameter("idCardNumber");
        String status = request.getParameter("status");
        String address = request.getParameter("address");
        double gpa = Double.parseDouble(request.getParameter("gpa"));
        Part avatarPart = request.getPart("avatar");
        String avatarFileName = null;

        if (avatarPart != null && avatarPart.getSize() > 0) {
            avatarFileName = extractFileName(avatarPart);
            String savePath = "/Users/johntoan98gmail.com/Desktop/quan_ly/web_quan_ly_nhan_vien_servlet/src/main/webapp/images/" + avatarFileName;
            avatarPart.write(savePath);
            avatarFileName = "/images/" + avatarFileName;
        } else {
            Student student = studentDAO.findByID(id);
            avatarFileName = student.getAvatar();
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = new Date();
        try {
            parsed = format.parse(birthday);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Student student = new Student(id, name, parsed, gender, avatarFileName, major, address, gpa, sbd, status.isEmpty());
        studentDAO.update(student);

        response.sendRedirect("/admin/student?id=" + id); // Redirect back to the student's profile page
    }

    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String content : contentDisposition.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }
}

