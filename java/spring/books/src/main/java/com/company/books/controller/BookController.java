package com.company.books.controller;

import com.company.books.models.Book;
import com.company.books.response.book.ResponseBookRestBook;
import com.company.books.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    public BookController(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<ResponseBookRestBook> findAllBook() {
        return iBookService.findAllBooks();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseBookRestBook> findById(@PathVariable("id") Long idBook) {
        return iBookService.findById(idBook);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseBookRestBook> saveBook(@RequestBody Book book) {
        return iBookService.saveBook(book);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseBookRestBook> updateBook(@RequestBody Book book, @PathVariable("id") Long idBook) {
        return iBookService.updateBook(book, idBook);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseBookRestBook> deleteByIdBook(@PathVariable("id") Long idBook) {
        return iBookService.deleteByIdBook(idBook);
    }
}
