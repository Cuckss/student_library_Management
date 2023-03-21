package com.example.Student_Management_Library_System.Services;

import com.example.Student_Management_Library_System.DTOs.IssueBookRequestDto;
import com.example.Student_Management_Library_System.Enums.CardStatus;
import com.example.Student_Management_Library_System.Enums.TransactionStatus;
import com.example.Student_Management_Library_System.Models.Book;
import com.example.Student_Management_Library_System.Models.Card;
import com.example.Student_Management_Library_System.Models.Transactions;
import com.example.Student_Management_Library_System.Repositories.BookRepository;
import com.example.Student_Management_Library_System.Repositories.CardRepository;
import com.example.Student_Management_Library_System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    private JavaMailSender emailSender;
    public String issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception{
      int bookId=issueBookRequestDto.getBookId();
      int cardId= issueBookRequestDto.getCardId();
     //Get the book Entity and card entity?? why we need this.../
        //becoz we are setting transaction attributes.

      Book book=bookRepository.findById(bookId).get();
      Card card=cardRepository.findById(cardId).get();
      //now we have to convert it into entity
        Transactions transaction=new Transactions();

        //now we are setting attribute
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setIssueOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);

        //attribute left is success or failure...
         //checking for validation.
        if(book==null || book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");
        }
        if(card==null || (card.getCardStatus()!= CardStatus.ACTIVATED)){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception ("card is not valid");
        }
        //now we have reached success status
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        //setting book attributes
        book.setIssued(true);
        List<Transactions>listOfTransactionForBook=book.getListOfTransaction();
        listOfTransactionForBook.add(transaction);
        book.setListOfTransaction(listOfTransactionForBook);
        //need to make changes in the card
        List<Book>issuedBooksForTheCard=card.getBooksIssued();
        issuedBooksForTheCard.add(book);

        //i need to make changes for the transaction in the card;
        List<Transactions>transactionListForTheCard=card.getTransactionList();
        transactionListForTheCard.add(transaction);

        //save the parent only
        cardRepository.save(card);
        //and automatically by cascading book and transaction will be saved
        String text="Congrats!! "+card.getStudentVariableName().getName()+" you have been issued"+book.getName()+" book.";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("librastudent123@gmail.com");
        message.setTo(card.getStudentVariableName().getEmailId());
        message.setSubject("Issue book notification");
        message.setText(text);
        emailSender.send(message);
        return"Book Issued Scuccessfully";
    }
    public String getTransactions(int bookId,int cardId){

        List<Transactions> transactionsList = transactionRepository.getTransactionsForBookAndCard(bookId,cardId);

        String transactionId = transactionsList.get(0).getTransactionId();

        return transactionId;
    }
}
