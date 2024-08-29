package com.library.libraryManagement.services;

import com.library.libraryManagement.entities.Book;
import com.library.libraryManagement.exceptions.BookExceptions;
import com.library.libraryManagement.repositories.BookRepository;
import com.library.libraryManagement.repositories.LoanRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;
    @Mock
    private LoanRepository loanRepository;
    @InjectMocks
    private BookService bookService;

    @Test
    void addBookSuccess(){
        Book book = new Book(null, "123456", "Effective Java", "Joshua Bloch", 2008,
                "Best practices", true, null);
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        Book savedBook = bookService.addBook(book);
        assertNotNull(savedBook);
        assertEquals("Effective Java", savedBook.getTitle());
    }

    @Test
    void addBookFailure() {
        Book book = new Book(null, "123456", "Effective Java", "Joshua Bloch", 2008, "Best practices", true, null);
        when(bookRepository.findByIsbn(anyString())).thenReturn(Optional.of(book));

        assertThrows(BookExceptions.BookAlreadyExists.class, () -> bookService.addBook(book));
    }
}
