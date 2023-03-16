package com.example.Student_Management_Library_System.Models;

import jakarta.persistence.*;

@Entity
@Table(name="Student_info")
public class Student {
@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
private String name;
@Column(unique = true)
private String emailId;
private int mobile;
private String age;
private String country;
// palin syntax for bidirectional mapping
    //name of the variable of parent entity that we have writtn in child class foreign key attribute
    @OneToOne(mappedBy = "studentVariableName",cascade=CascadeType.ALL)
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Student() {

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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
