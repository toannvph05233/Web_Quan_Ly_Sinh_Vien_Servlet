package com.qlnv.dao;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.model.Khoa;
import com.qlnv.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhoaDAO {

    // Câu lệnh SQL cho việc thêm một khoa mới
    private static final String INSERT_SQL = "INSERT INTO Khoa (name) VALUES (?)";

    // Phương thức này sẽ thêm một khoa mới vào cơ sở dữ liệu
    public void addKhoa(String tenKhoa) {
        try (Connection conn = ConnectMysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, tenKhoa);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Câu lệnh SQL cho việc lấy tất cả các khoa từ cơ sở dữ liệu
    private static final String SELECT_ALL_SQL = "SELECT * FROM Khoa";

    // Phương thức này sẽ trả về một ResultSet chứa tất cả các khoa
    public List<Khoa> getAllKhoa() {
        List<Khoa> khoaList = new ArrayList<>();
        try {
            Connection conn = ConnectMysql.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Khoa khoa = new Khoa();
                    khoa.setId(rs.getInt("id"));
                    khoa.setName(rs.getString("name"));
                    khoaList.add(khoa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khoaList;
    }

    // Câu lệnh SQL cho việc lấy một khoa dựa trên id
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM Khoa WHERE id = ?";

    // Phương thức này sẽ trả về một ResultSet chứa thông tin của một khoa dựa trên id
    public Khoa getKhoaById(int id) {
        try {
            Connection conn = ConnectMysql.getConnection();
            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL);
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                Khoa khoa = new Khoa();
                khoa.setId(rs.getInt("id"));
                khoa.setName(rs.getString("name"));
                return khoa;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
