package com.example.Student_Management_Library_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"Controllers"})
public class StudentManagementLibrarySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementLibrarySystemApplication.class, args);
	}

}
