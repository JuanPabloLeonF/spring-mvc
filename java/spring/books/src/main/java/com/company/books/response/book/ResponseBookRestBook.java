package com.company.books.response.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseBookRestBook extends ResponseRestBook{

    private ResponseBook responseBook = new ResponseBook();

    public ResponseBook getResponseBook() {
        return responseBook;
    }

    public void setResponseBook(ResponseBook responseBook) {
        this.responseBook = responseBook;
    }
}
