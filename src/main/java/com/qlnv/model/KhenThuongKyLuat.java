package com.qlnv.model;

import java.util.Date;

public class KhenThuongKyLuat {
    private int id;
    private int studentId;
    private String type;
    private Date date;
    private String content;

    public KhenThuongKyLuat() {
    }

    public KhenThuongKyLuat(int id, int studentId, String type, Date date, String content) {
        this.id = id;
        this.studentId = studentId;
        this.type = type;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
