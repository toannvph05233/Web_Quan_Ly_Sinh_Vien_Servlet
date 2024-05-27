package com.qlnv;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy đường dẫn của ảnh từ URL
        String imagePath = request.getPathInfo();
        if (imagePath == null || imagePath.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // Xây dựng đường dẫn thực tế đến tệp ảnh trên hệ thống tệp
        String imageDirectory = "/Users/johntoan98gmail.com/Desktop/quan_ly/web_quan_ly_nhan_vien_servlet/src/main/webapp/images";
        String realPath = imageDirectory + imagePath;
        File file = new File(realPath);

        // Kiểm tra sự tồn tại của tệp ảnh
        if (!file.exists() || !file.isFile()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // Set Content-Type header để trình duyệt hiểu loại dữ liệu của ảnh
        String contentType = getServletContext().getMimeType(imagePath);
        response.setContentType(contentType);

        // Đọc dữ liệu từ tệp ảnh và ghi vào HttpServletResponse
        try (FileInputStream in = new FileInputStream(file);
             ServletOutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
