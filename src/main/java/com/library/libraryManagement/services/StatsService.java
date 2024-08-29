package com.library.libraryManagement.services;

import com.library.libraryManagement.entities.Book;
import com.library.libraryManagement.entities.Loan;
import com.library.libraryManagement.entities.User;
import com.library.libraryManagement.repositories.BookRepository;
import com.library.libraryManagement.repositories.LoanRepository;
import com.library.libraryManagement.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatsService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;

    public StatsService(LoanRepository loanRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<Book> getMostPopularBooks() {
        return loanRepository.findAll().stream()
                .collect(Collectors.groupingBy(Loan::getBook, Collectors.counting()))
                .entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Book> getLeastPopularBooks() {
        return loanRepository.findAll().stream()
                .collect(Collectors.groupingBy(Loan::getBook, Collectors.counting()))
                .entrySet().stream()
                .sorted((a, b) -> a.getValue().compareTo(b.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<User> getMostActiveUsers() {
        return userRepository.findAll().stream()
                .sorted((u1,u2) -> Integer.compare(u2.getLoans().size(), u1.getLoans().size()))
                .collect(Collectors.toList());
    }
}
