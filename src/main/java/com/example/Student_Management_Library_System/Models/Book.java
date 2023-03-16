package com.example.Student_Management_Library_System.Models;

import com.example.Student_Management_Library_System.Enums.Genere;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean issued;
    private String name;
    private int pages;
    @Enumerated(value= EnumType.STRING)
    private Genere genere;
   //now book is child of author so we have to set foreign key
    @ManyToOne
    @JoinColumn
    Author author;


    //now we are setting another foreign key between book and card as book a child and card as parent
    @ManyToOne
    @JoinColumn
    Card card;

    //setting child class into parent
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transactions> listOfTransaction=new ArrayList<>();

    public List<Transactions> getListOfTransaction() {
        return listOfTransaction;
    }

    public void setListOfTransaction(List<Transactions> listOfTransaction) {
        this.listOfTransaction = listOfTransaction;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Book() {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
