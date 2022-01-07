package com.example.project2.controller;

import com.example.project2.exception.InformationExistsException;
import com.example.project2.exception.InformationNotFoundException;
import com.example.project2.model.Book;
import com.example.project2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


//
//(1.Books)
//        [GET] endpoint: "/api/books" -  Request Type: None
//        [POST] endpoint: "api/books/1/authors/1- Request Type: book information
//        [PUT] endpoint: "/api/books/1"- Request Type: book information
//        [DELETE] endpoint: "api/books/1 - Request Type: None


@RestController
@RequestMapping(path="/api")
public class BookController {

    private BookRepository bookRepository;

    private static final Logger LOGGER = Logger.getLogger(BookController.class.getName());

    @Autowired
    public void BookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Get all Books
    @GetMapping("/books")
    public List<Book> getBooks() {
        LOGGER.info("calling getBooks method from book controller");
        return bookRepository.findAll();
    }

    //Creating a Single Book

    @PostMapping(path = "/books/{bookid}")
    public Book createBook(@RequestBody Book bookObject){
        LOGGER.info("calling createBook method from book controller");
        Book book = bookRepository.findByName(bookObject.getName());
        if (book != null) {
            throw new InformationExistsException("book with name " + book.getName() + " already exists");
        } else {
            return bookRepository.save(bookObject);
        }
    }

    //Delete Single Book
    @DeleteMapping(path = "/books/{bookid}")
    public String Book(@PathVariable(value = "bookID") Long bookID) {
        LOGGER.info("calling deleteBook method from book controller");
        Optional<Book> book = bookRepository.findById(bookID);
        if (book.isPresent()) {
            bookRepository.deleteById(bookID);
        } else {
            throw new InformationNotFoundException("book with id " + bookID + " not found");
        }
        return "deleting book with id of " + bookID;
    }

    //Updating Single Book
    @PutMapping(path = "/books/{bookid}")
    public Book updateBook(@PathVariable(value = "bookID") Long bookID, @RequestBody Book bookObject) {
        LOGGER.info("calling updateBook method from book controller");
        Optional<Book> book = bookRepository.findById(bookID);
        if (book.isPresent()) {
            if (bookObject.getName().equals(book.get().getName())) {
                LOGGER.warning("book name is equals to database object name");
                throw new InformationExistsException("book " + book.get().getName() + " already exists");
            } else {
                Book updateBook = bookRepository.findById(bookID).get();
                updateBook.setName(bookObject.getName());
                updateBook.setRelease_date(bookObject.getRelease_date());
                return bookRepository.save(updateBook);
            }
        } else {
            throw new InformationNotFoundException("book with id " + bookID + " not found");
        }

    }
}










