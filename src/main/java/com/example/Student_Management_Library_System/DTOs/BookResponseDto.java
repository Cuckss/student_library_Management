package com.example.Student_Management_Library_System.DTOs;

import com.example.Student_Management_Library_System.Enums.Genere;

public class BookResponseDto {
    private String name;
    private int pages;
    private Genere genere;

    public BookResponseDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }
}
