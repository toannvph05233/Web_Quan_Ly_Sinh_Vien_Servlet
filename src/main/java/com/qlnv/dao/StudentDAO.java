package com.qlnv.dao;

import com.qlnv.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Student student) {
        String sql = "INSERT INTO Student (name, birthday, gender, avatar, idCardNumber, address, status,major,IdKhoa) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setDate(2, new java.sql.Date(student.getBirthday().getTime()));
            stmt.setString(3, student.getGender());
            stmt.setString(4, student.getAvatar());
            stmt.setString(5, student.getIdCardNumber());
            stmt.setString(6, student.getAddress());
            stmt.setBoolean(7, student.isStatus());
            stmt.setString(8, student.getMajor());
            stmt.setString(9, student.getIdKhoa());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        String sql = "UPDATE Student SET name = ?, birthday = ?, gender = ?, avatar = ?, idCardNumber = ?, address = ?, status = ?, major = ?, gpa = ? , IdKhoa = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setDate(2, new java.sql.Date(student.getBirthday().getTime()));
            stmt.setString(3, student.getGender());
            stmt.setString(4, student.getAvatar());
            stmt.setString(5, student.getIdCardNumber());
            stmt.setString(6, student.getAddress());
            stmt.setBoolean(7, student.isStatus());
            stmt.setString(8, student.getMajor());
            stmt.setDouble(9, student.getGpa());
            stmt.setString(10, student.getIdKhoa());
            stmt.setInt(11, student.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dismissal(int id) {
        String sql = "DELETE FROM Student WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> search(String keyword) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student WHERE name LIKE ? OR idCardNumber LIKE ? OR address LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            stmt.setString(3, "%" + keyword + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setBirthday(rs.getDate("birthday"));
                    student.setGender(rs.getString("gender"));
                    student.setIdKhoa(rs.getString("idKhoa"));
                    student.setAvatar(rs.getString("avatar"));
                    student.setIdCardNumber(rs.getString("idCardNumber"));
                    student.setAddress(rs.getString("address"));
                    student.setMajor(rs.getString("major"));
                    student.setGpa(rs.getDouble("gpa"));
                    student.setStatus(rs.getBoolean("status"));
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student findByID(int studentId) {
        Student student = null;
        String sql = "SELECT * FROM Student WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setBirthday(rs.getDate("birthday"));
                    student.setIdKhoa(rs.getString("idKhoa"));
                    student.setGender(rs.getString("gender"));
                    student.setAvatar(rs.getString("avatar"));
                    student.setIdCardNumber(rs.getString("idCardNumber"));
                    student.setAddress(rs.getString("address"));
                    student.setStatus(rs.getBoolean("status"));
                    student.setMajor(rs.getString("major"));
                    student.setGpa(rs.getDouble("gpa"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public Student findByIdCardNumber(String idCardNumber) {
        Student student = null;
        String sql = "SELECT * FROM Student WHERE idCardNumber = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idCardNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setBirthday(rs.getDate("birthday"));
                    student.setIdKhoa(rs.getString("idKhoa"));
                    student.setGender(rs.getString("gender"));
                    student.setAvatar(rs.getString("avatar"));
                    student.setIdCardNumber(rs.getString("idCardNumber"));
                    student.setAddress(rs.getString("address"));
                    student.setStatus(rs.getBoolean("status"));
                    student.setMajor(rs.getString("major"));
                    student.setGpa(rs.getDouble("gpa"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public List<Student> findByIdKhoaAndStatus(String idKhoa, boolean status) {
        String sql = "SELECT * FROM Student WHERE idKhoa = ? and status = ?";
        List<Student> students = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idKhoa);
            stmt.setBoolean(2, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setBirthday(rs.getDate("birthday"));
                student.setGender(rs.getString("gender"));
                student.setIdKhoa(rs.getString("idKhoa"));
                student.setAvatar(rs.getString("avatar"));
                student.setIdCardNumber(rs.getString("idCardNumber"));
                student.setAddress(rs.getString("address"));
                student.setStatus(rs.getBoolean("status"));
                student.setMajor(rs.getString("major"));
                student.setGpa(rs.getDouble("gpa"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setBirthday(rs.getDate("birthday"));
                student.setGender(rs.getString("gender"));
                student.setIdKhoa(rs.getString("idKhoa"));
                student.setAvatar(rs.getString("avatar"));
                student.setIdCardNumber(rs.getString("idCardNumber"));
                student.setAddress(rs.getString("address"));
                student.setStatus(rs.getBoolean("status"));
                student.setMajor(rs.getString("major"));
                student.setGpa(rs.getDouble("gpa"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<Student> getAllByType(boolean status) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student WHERE status = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBoolean(1, status);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setBirthday(rs.getDate("birthday"));
                    student.setIdKhoa(rs.getString("idKhoa"));
                    student.setGender(rs.getString("gender"));
                    student.setAvatar(rs.getString("avatar"));
                    student.setIdCardNumber(rs.getString("idCardNumber"));
                    student.setAddress(rs.getString("address"));
                    student.setStatus(rs.getBoolean("status"));
                    student.setMajor(rs.getString("major"));
                    student.setGpa(rs.getDouble("gpa"));
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
