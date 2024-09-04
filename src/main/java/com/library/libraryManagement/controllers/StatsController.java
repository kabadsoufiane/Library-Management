package com.library.libraryManagement.controllers;

import com.library.libraryManagement.entities.Book;
import com.library.libraryManagement.entities.User;
import com.library.libraryManagement.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/books/popular")
    public ResponseEntity<List<Book>> getMostPopularBooks() {
        List<Book> books = statsService.getMostPopularBooks();
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/least-popular")
    public ResponseEntity<List<Book>> getLeastPopularBooks() {
        List<Book> books = statsService.getLeastPopularBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/users/active")
    public ResponseEntity<List<User>> getMostActiveUsers() {
        List<User> users = statsService.getMostActiveUsers();
        return ResponseEntity.ok(users);
    }
}
