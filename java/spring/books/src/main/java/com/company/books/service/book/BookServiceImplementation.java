package com.company.books.service.book;

import com.company.books.models.Book;
import com.company.books.models.Category;
import com.company.books.repository.IBookRepository;
import com.company.books.response.book.ResponseBookRestBook;
import com.company.books.response.category.ResponseCategoryRestCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements IBookService{

    private static final Logger log = LoggerFactory.getLogger(BookServiceImplementation.class);

    @Autowired
    private IBookRepository iBookRepository;

    public BookServiceImplementation(IBookRepository iBookRepository) {
        this.iBookRepository = iBookRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ResponseBookRestBook> findAllBooks() {
        log.info("Inicio del metodo findAllBooks");

         ResponseBookRestBook responseBookRestBook = new ResponseBookRestBook();
        try {
            List<Book> bookList = iBookRepository.findAll();
            responseBookRestBook.getResponseBook().setBookList(bookList);
            responseBookRestBook.setMetaData("Respuesta OK", "00", "Respuesta exitosa");
        } catch (Exception e) {
            log.error("Error al consultar categorías: ", e.getMessage());
            responseBookRestBook.setMetaData("Respuesta nok", "-1", "Error al consultar libros");
            e.getStackTrace();
            return new ResponseEntity<>(responseBookRestBook, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseBookRestBook, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ResponseBookRestBook> findById(Long idBook) {
        log.info("Inici del metodo findById");
        ResponseBookRestBook responseBookRestBook = new ResponseBookRestBook();
        List<Book> bookList = new ArrayList<>();

        try {
            Optional<Book> book = iBookRepository.findById(idBook);
            if (book.isPresent()) {
                bookList.add(book.get());
                responseBookRestBook.getResponseBook().setBookList(bookList);
                responseBookRestBook.setMetaData("Respuesta OK", "00", "Respuesta exitosa");
            } else {
                log.error("Error en la consulta del libro");
                responseBookRestBook.setMetaData("Respuesta nok", "-1", "El libro no encontrado");
                return new ResponseEntity<>(responseBookRestBook, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error en la consulta categoria", e.getMessage());
            responseBookRestBook.setMetaData("Respuesta nok", "-1", "Error al consultar el libro");
            return new ResponseEntity<>(responseBookRestBook, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(responseBookRestBook, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = false)
    public ResponseEntity<ResponseBookRestBook> saveBook(Book book) {
        log.info("Inicio del metodo saveBook");
        ResponseBookRestBook responseBookRestBook = new ResponseBookRestBook();
        List<Book> bookList = new ArrayList<>();
        try {
            Book bookSave = iBookRepository.save(book);
            bookList.add(bookSave);
            responseBookRestBook.getResponseBook().setBookList(bookList);
            responseBookRestBook.setMetaData("Respuesta CREATE", "00", "Se creo el libro correctamente");
        } catch (Exception e) {
            log.error("Error al crear un libro", e.getMessage());
            responseBookRestBook.setMetaData("Respuesta noCreate", "-2", "Error al crear un libro");
            return new ResponseEntity<>(responseBookRestBook, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseBookRestBook,HttpStatus.CREATED);
    }

    @Override
    @Transactional(readOnly = false)
    public ResponseEntity<ResponseBookRestBook> updateBook(Book book, Long idBook) {
        log.info("Inicio del metodo updateBook");
        ResponseBookRestBook responseBookRestBook = new ResponseBookRestBook();
        List<Book> bookList = new ArrayList<>();
        try {
            Optional<Book> bookFind = iBookRepository.findById(idBook);
            if (bookFind.isPresent()) {
                bookFind.get().setName(book.getName());
                bookFind.get().setDescription(book.getDescription());
                Book bookUpdate = iBookRepository.save(bookFind.get());
                bookList.add(bookUpdate);
                responseBookRestBook.getResponseBook().setBookList(bookList);
                responseBookRestBook.setMetaData("Respuesta UPDATE", "00", "Se actualizo el libro correctamente");
            } else {
                log.error("Error al actualizar un libro");
                responseBookRestBook.setMetaData("Respuesta noUpdate", "-3", "Error al actualizar un libro");
                return new ResponseEntity<>(responseBookRestBook, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error("Error al actualizar una categoria", e.getMessage());
            responseBookRestBook.setMetaData("Respuesta noUpdate", "-3", "Error al actualizar la categoria");
            return new ResponseEntity<>(responseBookRestBook, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseBookRestBook,HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = false)
    public ResponseEntity<ResponseBookRestBook> deleteByIdBook(Long idBook) {
        log.info("Inicio del metodo deleteByIdBook");
        ResponseBookRestBook responseBookRestBook = new ResponseBookRestBook();
        List<Book> bookList = new ArrayList<>();

        try {
            iBookRepository.deleteById(idBook);
            responseBookRestBook.setMetaData("Respuesta DELETE", "00", "Se elimino el libro correctamente");
        } catch (Exception e) {
            log.error("Error al eliminar un libro", e.getMessage());
            responseBookRestBook.setMetaData("Respuesta noDelete", "-4", "Error al eliminar el libro");
            return new ResponseEntity<>(responseBookRestBook, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseBookRestBook, HttpStatus.OK);
    }
}
