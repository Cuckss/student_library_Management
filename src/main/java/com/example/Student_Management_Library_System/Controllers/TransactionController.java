package com.example.Student_Management_Library_System.Controllers;

import com.example.Student_Management_Library_System.DTOs.IssueBookRequestDto;
import com.example.Student_Management_Library_System.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
@PostMapping("/issue_book")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto){
    try{
        return transactionService.issueBook(issueBookRequestDto);
    }catch(Exception e){
        return e.getMessage();
    }
    }
    @GetMapping("/getTxnInfo")
    public String getTransactionEntry(@RequestParam("bookId")Integer bookId,@RequestParam
            ("cardId")Integer cardId){

        return transactionService.getTransactions(bookId,cardId);
    }
}
