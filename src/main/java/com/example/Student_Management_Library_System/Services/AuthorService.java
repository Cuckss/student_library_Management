package com.example.Student_Management_Library_System.Services;

import com.example.Student_Management_Library_System.DTOs.AuthorEntryDto;
import com.example.Student_Management_Library_System.DTOs.AuthorResponseDto;
import com.example.Student_Management_Library_System.DTOs.BookResponseDto;
import com.example.Student_Management_Library_System.Enums.Genere;
import com.example.Student_Management_Library_System.Models.Author;
import com.example.Student_Management_Library_System.Models.Book;
import com.example.Student_Management_Library_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
@Autowired
    AuthorRepository authorRepository;
 public String addAuthor(AuthorEntryDto authorEntryDto){
     //now imp thing is that here object is of type DTO and repository layer only interact with entity
     //so we have to convert it into the entity
    Author author=new Author();
    author.setName(authorEntryDto.getName());
    author.setAge(authorEntryDto.getAge());
    author.setCountry(authorEntryDto.getCountry());
    author.setRating(authorEntryDto.getRating());

    authorRepository.save(author);

    return "author added successfully";
}
public AuthorResponseDto getAuthor(Integer authorId){
    Author author=authorRepository.findById(authorId).get();
  AuthorResponseDto authorResponseDto=new AuthorResponseDto();
  //setting its Attributes
    //list<Book>into list<BookResponseDto>...
    List<Book> bookList=author.getBooksWritten();
    List<BookResponseDto>bookswrittenDto=new ArrayList<>();

       for(Book b:bookList){
       BookResponseDto bookResponseDto=new BookResponseDto();
       bookResponseDto.setGenere(b.getGenere());
       bookResponseDto.setName(b.getName());
       bookResponseDto.setPages(b.getPages());

       bookswrittenDto.add(bookResponseDto);
    }

    //set attributes for authorResponseDto
    authorResponseDto.setBooksWritten(bookswrittenDto);
   authorResponseDto.setAge(author.getAge());
   authorResponseDto.setName(author.getName());
    authorResponseDto.setRating(author.getRating());
  return authorResponseDto;
}
}
