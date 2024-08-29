package com.library.libraryManagement.services;

import com.library.libraryManagement.entities.Book;
import com.library.libraryManagement.entities.Loan;
import com.library.libraryManagement.entities.User;
import com.library.libraryManagement.exceptions.BookExceptions;
import com.library.libraryManagement.exceptions.LoanExceptions;
import com.library.libraryManagement.repositories.BookRepository;
import com.library.libraryManagement.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Loan createLoan(Long bookId, Long userId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookExceptions.BookNotFoundException("Book not found with id: " + bookId));

        if (!book.isAvailable()) {
            throw new BookExceptions.BookNotAvailableException("Book is not available for loan.");
        }

        book.setAvailable(false);
        bookRepository.save(book);

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setUser(new User(userId));
        loan.setDateOfLoan(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusWeeks(2));
        return loanRepository.save(loan);
    }

    @Transactional
    public void returnLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanExceptions.LoanNotFoundException("Loan not found with id: " + loanId));

        Book book = loan.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        loan.setReturnDate(LocalDate.now());
        
        if (LocalDate.now().isAfter(loan.getDueDate())) {
            long daysLate = ChronoUnit.DAYS.between(loan.getDueDate(), LocalDate.now());
            loan.setPenalty(calculatePenalty(daysLate)); // Calculate and set the penalty
        }
        
        loanRepository.save(loan);
    }

    private double calculatePenalty(long daysLate) {
        final double dailyRate = 0.50; // Penalty rate per day
        return daysLate * dailyRate;
    }

    @Transactional(readOnly = true)
    public List<Loan> findAllLoans() {
        return loanRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Loan> findLoansByUserId(Long userId) {
        return loanRepository.findByUserId(userId);
    }
}
