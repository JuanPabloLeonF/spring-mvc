package com.mvc.spring.persistence.errors.handler;

import com.mvc.spring.persistence.errors.ErrorMessagesApi;
import com.mvc.spring.persistence.errors.exception.NotFoundPerson;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionsConfiguration extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundPerson.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessagesApi> notFoundPerson(NotFoundPerson exception) {
        ErrorMessagesApi message = new ErrorMessagesApi(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
