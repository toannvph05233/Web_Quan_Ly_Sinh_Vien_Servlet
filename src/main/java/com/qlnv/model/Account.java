package com.qlnv.model;

public class Account {
    private int id;
    private String username;
    private String password;
    private String role;
    private String avatar;
    private String idKhoa;

    public Account(int id, String username, String password, String role, String avatar) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.avatar = avatar;
    }

    public String getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(String idKhoa) {
        this.idKhoa = idKhoa;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
