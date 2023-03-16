package com.example.Student_Management_Library_System.Models;

import com.example.Student_Management_Library_System.Enums.CardStatus;
import com.example.Student_Management_Library_System.Enums.TransactionStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="Transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value=EnumType.STRING)
    private TransactionStatus transactionStatus;
    private int fine;
    private String transactionId= UUID.randomUUID().toString();
    private Date transactionDate;
    private boolean issueOperation;

    //for connecting this to the book
    @ManyToOne
    @JoinColumn
    private Book book;

    //now connect this to the card
    @ManyToOne
    @JoinColumn
    private Card card;

    public Transactions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isIssueOperation() {
        return issueOperation;
    }

    public void setIssueOperation(boolean issueOperation) {
        this.issueOperation = issueOperation;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
