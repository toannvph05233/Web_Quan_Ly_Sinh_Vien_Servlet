package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.KhoaDAO;
import com.qlnv.dao.StudentDAO;
import com.qlnv.model.Khoa;
import com.qlnv.model.Student;

import javax.servlet.RequestDispatcher;
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

@WebServlet(urlPatterns = "/createStudent")
@MultipartConfig
public class CreateStudentServlet extends HttpServlet {
    StudentDAO studentDAO = new StudentDAO(ConnectMysql.getConnection());
    KhoaDAO khoaDAO = new KhoaDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("khoaList", khoaDAO.getAllKhoa());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/createStudent.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = request.getParameter("FullName");
        Date dateOfBirth = parseDate(request.getParameter("DateOfBirth"));
        String gender = request.getParameter("Gender");
        String idKhoa = request.getParameter("idKhoa");
        String idCardNumber = request.getParameter("IDCardNumber");
        String address = request.getParameter("Address");
        boolean status = Boolean.parseBoolean(request.getParameter("Status"));

        // Create a Student object and populate it with the data
        Student student = new Student();
        student.setName(fullName);
        student.setBirthday(dateOfBirth);
        student.setGender(gender);
        student.setIdCardNumber(idCardNumber);
        student.setAddress(address);
        student.setIdKhoa(idKhoa);
        student.setStatus(status);
        Khoa khoa = khoaDAO.getKhoaById(Integer.parseInt(idKhoa));
        student.setMajor(khoa.getName());
        Part avatarPart = request.getPart("Avatar");
        String avatarFileName = null;

        if (avatarPart != null && avatarPart.getSize() > 0) {
            avatarFileName = extractFileName(avatarPart);
            String savePath = "/Users/johntoan98gmail.com/Desktop/quan_ly/web_quan_ly_nhan_vien_servlet/src/main/webapp/images/" + avatarFileName;
            avatarPart.write(savePath);
        }
        student.setAvatar("/images/"+ avatarFileName);

        // Add the student to the database
        studentDAO.add(student);

        // Redirect to the students page after successful creation
        resp.sendRedirect("/students");
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
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
