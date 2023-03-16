package com.example.Student_Management_Library_System.DTOs;

public class AuthorEntryDto {
     //this is just an object which is used to take request from postman
     //it will contain the parameter that we want to send from postman
     //id is not passed becoz we dont want to send it from the postman

    private String name;

    private int age;
    private String country;
    private double rating;
    //here also we will make getter and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public AuthorEntryDto() {
    }
}
