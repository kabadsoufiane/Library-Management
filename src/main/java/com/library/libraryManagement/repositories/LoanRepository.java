package com.library.libraryManagement.repositories;

import com.library.libraryManagement.entities.Book;
import com.library.libraryManagement.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    boolean existsByBookAndReturnDateIsNull(Book book);

    List<Loan> findByUserId(Long userId);
}