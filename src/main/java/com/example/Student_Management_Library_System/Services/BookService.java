package com.example.Student_Management_Library_System.Services;

import com.example.Student_Management_Library_System.DTOs.BookRequestDto;
import com.example.Student_Management_Library_System.Models.Author;
import com.example.Student_Management_Library_System.Models.Book;
import com.example.Student_Management_Library_System.Repositories.AuthorRepository;
import com.example.Student_Management_Library_System.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    public String addBook(BookRequestDto bookRequestDto){
        // now I will be needed authorid
        int authorId=bookRequestDto.getAuthorId();

        //now i will be fetching author entity for this i hve to autowire Authorrepositry
         Author author=authorRepository.findById(authorId).get();
        Book book=new Book();
        //basic book attribute are being set;
        book.setGenere(bookRequestDto.getGenere());
        book.setIssued(false);
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());

        //basic attributes are now already set fromg postman
        //set the foreign key attribute
        book.setAuthor(author);
        //we need to set the listof books writtrn in parent also
        List<Book>currentBook=author.getBooksWritten();
        currentBook.add(book);
        //now set the no.of books and put
        author.setBooksWritten(currentBook);


        //now the book is to saved and author is also to be saved
        authorRepository.save(author);
        //.save function act both as a save function as well as update function
        return "book added Successfully";
    }
}
