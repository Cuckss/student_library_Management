package com.example.Student_Management_Library_System.Repositories;

import com.example.Student_Management_Library_System.Models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
