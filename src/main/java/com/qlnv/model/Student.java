package com.qlnv.model;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private Date birthday;
    private String gender;
    private String avatar;
    private String idCardNumber;
    private String address;
    private String major;
    private String idKhoa;
    private double gpa;
    private boolean status;

    public Student() {
    }

    public Student(int id, String name, Date birthday, String gender, String avatar, String idCardNumber, String address, boolean status) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.avatar = avatar;
        this.idCardNumber = idCardNumber;
        this.address = address;
        this.status = status;
    }
    public Student(int id, String name, Date birthday, String gender, String avatar, String major, String address, double gpa, String sbd, boolean status) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.avatar = avatar;
        this.idCardNumber = sbd;
        this.address = address;
        this.status = status;
        this.major = major;
        this.gpa = gpa;
    }

    public String getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(String idKhoa) {
        this.idKhoa = idKhoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}

