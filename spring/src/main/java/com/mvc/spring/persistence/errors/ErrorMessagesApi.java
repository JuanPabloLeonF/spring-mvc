package com.mvc.spring.persistence.errors;

import org.springframework.http.HttpStatus;

public class ErrorMessagesApi {

    private HttpStatus httpStatus;
    private String message;

    public ErrorMessagesApi() {
    }

    public ErrorMessagesApi(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
