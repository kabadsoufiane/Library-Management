package com.library.libraryManagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BookExceptions {

    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "this book already exists")
    public static class BookAlreadyExists extends RuntimeException {
        public BookAlreadyExists(String message) {
            super(message);
        }
    }

    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "this book is noy available")
    public static class BookNotAvailable extends RuntimeException {
        public BookNotAvailable(String message) {
            super(message);
        }
    }

    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "this book is already in loan")
    public static class BookAlreadyInLoan extends RuntimeException {
        public BookAlreadyInLoan(String message) {
            super(message);
        }
    }

    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "this book is not found")
    public static class BookNotFoundException extends RuntimeException {
        public BookNotFoundException(String message) {
        }
    }

    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "Cannot update a book that is currently on loan.")
    public static class BookCurrentlyLoanedException extends RuntimeException {
        public BookCurrentlyLoanedException(String message) {
        }
    }

    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "Book is not available for loan.")
    public static class BookNotAvailableException extends RuntimeException {
        public BookNotAvailableException(String message) {
        }
    }
}
