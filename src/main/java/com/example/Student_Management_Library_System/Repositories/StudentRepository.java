package com.example.Student_Management_Library_System.Repositories;

import com.example.Student_Management_Library_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
//    Student findByEmail(String emailId);

}
