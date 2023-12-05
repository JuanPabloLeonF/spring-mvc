package com.company.books.response.book;

import com.company.books.models.Book;

import java.util.List;

public class ResponseBook {

    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
