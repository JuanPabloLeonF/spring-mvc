package com.company.books.service.book;

import com.company.books.models.Book;
import com.company.books.response.book.ResponseBookRestBook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface IBookService {

    ResponseEntity<ResponseBookRestBook> findAllBooks();
    ResponseEntity<ResponseBookRestBook> findById(Long idBook);
    ResponseEntity<ResponseBookRestBook> saveBook(Book book);
    ResponseEntity<ResponseBookRestBook> updateBook(Book book, Long idBook);
    ResponseEntity<ResponseBookRestBook> deleteByIdBook(Long idBook);
}
