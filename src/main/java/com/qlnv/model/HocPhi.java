package com.qlnv.model;

import java.util.Date;

public class HocPhi {
    private int id;
    private int studentId;
    private Date date;

    public HocPhi(int id, int studentId, Date date) {
        this.id = id;
        this.studentId = studentId;
        this.date = date;
    }

    public HocPhi() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
