package com.example.Student_Management_Library_System.Controllers;

import com.example.Student_Management_Library_System.DTOs.AuthorEntryDto;
import com.example.Student_Management_Library_System.DTOs.AuthorResponseDto;
import com.example.Student_Management_Library_System.Models.Author;
import com.example.Student_Management_Library_System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
 @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorEntryDto authorEntryDto){

return authorService.addAuthor(authorEntryDto);
 }
 @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId") Integer authorId){
 return authorService.getAuthor(authorId);
 }
}
