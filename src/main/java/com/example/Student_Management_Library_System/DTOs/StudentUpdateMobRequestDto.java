package com.example.Student_Management_Library_System.DTOs;

public class StudentUpdateMobRequestDto {
    private int id;
    private int mobile;
//DTOs depend on api called
    public StudentUpdateMobRequestDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
}
