package com.example.Student_Management_Library_System.Repositories;

import com.example.Student_Management_Library_System.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

}
