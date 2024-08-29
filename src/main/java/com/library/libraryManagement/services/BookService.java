package com.library.libraryManagement.services;

import com.library.libraryManagement.entities.Book;
import com.library.libraryManagement.exceptions.BookExceptions;
import com.library.libraryManagement.repositories.BookRepository;
import com.library.libraryManagement.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;

    @Autowired
    public BookService(BookRepository bookRepository, LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
    }

    @Transactional
    public Book addBook(Book book) {
        if (bookRepository.findByIsbn(book.getIsbn()).isPresent()
                || bookRepository.findByTitle(book.getTitle()).isPresent()) {
            throw new BookExceptions.BookAlreadyExists("A book with the same ISBN or title already exists.");
        }
        return bookRepository.save(book);
    }

    @Transactional
    public Book updateBook(Long bookId, Book updatedBook) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookExceptions.BookNotFoundException("No book found with ID: " + bookId));

        if (loanRepository.existsByBookAndReturnDateIsNull(book)) {
            throw new BookExceptions.BookCurrentlyLoanedException("Cannot update a book that is currently on loan.");
        }

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setPublicationYear(updatedBook.getPublicationYear());
        book.setSummary(updatedBook.getSummary());
        book.setAvailable(updatedBook.isAvailable());
        return bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Long bookId) {
        if (loanRepository.existsByBookAndReturnDateIsNull(new Book(bookId))) {
            throw new BookExceptions.BookCurrentlyLoanedException("Cannot delete a book that is currently on loan.");
        }
        bookRepository.deleteById(bookId);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
    public Optional<Book> getBookISBN(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public Optional<Book> getBookByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Transactional(readOnly = true)
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Book> findAvailableBooks() {
        return bookRepository.findByIsAvailable(true);
    }


}
