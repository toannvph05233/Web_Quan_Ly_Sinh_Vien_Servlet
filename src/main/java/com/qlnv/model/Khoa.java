package com.qlnv.model;

import java.util.Date;

public class Khoa {
    private int id;
    private String name;

    public Khoa(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Khoa() {
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
}
