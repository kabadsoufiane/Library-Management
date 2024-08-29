package com.library.libraryManagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class LoanExceptions {
    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "Book is not available for loan.")
    public static class LoanNotFoundException extends RuntimeException {
        public LoanNotFoundException(String message){

        }

    }
}
