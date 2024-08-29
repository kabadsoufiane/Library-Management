package com.library.libraryManagement.repositories;

import com.library.libraryManagement.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findByAuthor(String author);

    List<Book> findByIsAvailable(boolean available);
}
