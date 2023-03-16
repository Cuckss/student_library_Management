package com.example.Student_Management_Library_System.Services;

import com.example.Student_Management_Library_System.DTOs.StudentUpdateMobRequestDto;
import com.example.Student_Management_Library_System.Enums.CardStatus;
import com.example.Student_Management_Library_System.Models.Card;
import com.example.Student_Management_Library_System.Models.Student;
import com.example.Student_Management_Library_System.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String createStudent(Student student){
        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVariableName(student);

        // lets go to the students
        student.setCard(card);

        /*if this was unidirectionl then we have to save both of them but here we are using bidirectional
         so child will automatically set*/
        studentRepository.save(student);
        // by cascading effect child will automaticallyu be saved

        return"Student and Card Added";
    }
//    public String findNameByEmail(String emailId){
//       Student student=studentRepository.findByEmail(emailId);
//       return student.getName();
//    }
    public String updateMob(StudentUpdateMobRequestDto studentReq){
        //Now we have to convert the dto into entity

        //first we will try to fetch original data
        Student originalStudent=studentRepository.findById(studentReq.getId()).get();

        //now we will keep other properties as it is and only change the required parameters
        originalStudent.setMobile(studentReq.getMobile());
        //now we will save originalStudent
        studentRepository.save(originalStudent);
        return "updated mobilenumber successfully";

        //If I directly save the newStudent then other attributes will become null
    }
}
