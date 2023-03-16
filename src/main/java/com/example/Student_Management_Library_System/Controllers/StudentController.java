package com.example.Student_Management_Library_System.Controllers;

import com.example.Student_Management_Library_System.DTOs.StudentUpdateMobRequestDto;
import com.example.Student_Management_Library_System.Models.Student;
import com.example.Student_Management_Library_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){
       return studentService.createStudent(student);
    }
//    @GetMapping("/get_user")
//    public String getNameByEmail(@RequestParam("email") String emailId){
//    return studentService.findNameByEmail(emailId);
//    }

    @PutMapping("/update_mobile")
    public String updateMob(@RequestBody StudentUpdateMobRequestDto studentUpdateMobRequestDto){

        return studentService.updateMob(studentUpdateMobRequestDto);
    }
}
