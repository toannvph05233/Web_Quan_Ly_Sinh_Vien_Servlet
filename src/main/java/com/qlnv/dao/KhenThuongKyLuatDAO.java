package com.qlnv.dao;

import com.qlnv.model.KhenThuongKyLuat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhenThuongKyLuatDAO {
    private Connection connection;

    public KhenThuongKyLuatDAO(Connection connection) {
        this.connection = connection;
    }

    public void addKhenThuongKyLuat(KhenThuongKyLuat khenThuongKyLuat) {
        String insertQuery = "INSERT INTO KhenThuongKyLuat (studentId, Type, Date, Content) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, khenThuongKyLuat.getStudentId());
            preparedStatement.setString(2, khenThuongKyLuat.getType());
            preparedStatement.setDate(3, new java.sql.Date(khenThuongKyLuat.getDate().getTime()));
            preparedStatement.setString(4, khenThuongKyLuat.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateKhenThuongKyLuat(KhenThuongKyLuat khenThuongKyLuat) {
        String updateQuery = "UPDATE KhenThuongKyLuat SET studentId = ?, Type = ?, Date = ?, Content = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, khenThuongKyLuat.getStudentId());
            preparedStatement.setString(2, khenThuongKyLuat.getType());
            preparedStatement.setDate(3, new java.sql.Date(khenThuongKyLuat.getDate().getTime()));
            preparedStatement.setString(4, khenThuongKyLuat.getContent());
            preparedStatement.setInt(5, khenThuongKyLuat.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteKhenThuongKyLuat(int id) {
        String deleteQuery = "DELETE FROM KhenThuongKyLuat WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<KhenThuongKyLuat> getKhenThuongKyLuatByStudentId(int studentId, String type) {
        List<KhenThuongKyLuat> khenThuongKyLuats = new ArrayList<>();
        String selectQuery = "SELECT * FROM KhenThuongKyLuat WHERE studentId = ? and type = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, studentId);
            preparedStatement.setString(2, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                KhenThuongKyLuat khenThuongKyLuat = new KhenThuongKyLuat();
                khenThuongKyLuat.setId(resultSet.getInt("id"));
                khenThuongKyLuat.setStudentId(resultSet.getInt("studentId"));
                khenThuongKyLuat.setType(resultSet.getString("type"));
                khenThuongKyLuat.setDate(resultSet.getDate("date"));
                khenThuongKyLuat.setContent(resultSet.getString("content"));
                khenThuongKyLuats.add(khenThuongKyLuat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khenThuongKyLuats;
    }
}

