package com.library.libraryManagement.controllers;

import com.library.libraryManagement.entities.Loan;
import com.library.libraryManagement.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        Loan newLoan = loanService.createLoan(loan.getBook().getId(), loan.getUser().getId());
        return ResponseEntity.ok(newLoan);
    }

    @PutMapping("/{loanId}/return")
    public ResponseEntity<Loan> returnLoan(@PathVariable Long loanId) {
        loanService.returnLoan(loanId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.findAllLoans();
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Loan>> getLoansByUser(@PathVariable Long userId) {
        List<Loan> loans = loanService.findLoansByUserId(userId);
        return ResponseEntity.ok(loans);
    }
}
