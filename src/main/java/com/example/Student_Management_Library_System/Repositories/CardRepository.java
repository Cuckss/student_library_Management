package com.example.Student_Management_Library_System.Repositories;

import com.example.Student_Management_Library_System.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {


}
