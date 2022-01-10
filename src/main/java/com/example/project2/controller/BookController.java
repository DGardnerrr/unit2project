package com.example.project2.controller;

import com.example.project2.model.Author;
import com.example.project2.model.Book;
import com.example.project2.model.Genre;
import com.example.project2.model.Publisher;
import com.example.project2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping(path="/api")
public class BookController {
    private static final Logger LOGGER = Logger.getLogger(BookController.class.getName());

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }


    //====Book====//
    //Get all Books
    //http://localhost:9092/api/books
    @GetMapping("/books")
    public List<Book> getBooks() {
        LOGGER.info("calling getBooks method from book controller");
        return bookService.getBooks();
    }


    //get a single book
    //http://localhost:9092/api/books/1
    @GetMapping("/books/{bookId}")
    public Optional getBook(@PathVariable Long bookId) {
        LOGGER.info("calling getBook method from controller");
        return bookService.getBook(bookId);
    }

    //create a single book
    //http://localhost:9092/api/books
    @PostMapping(path = "/books/")
    public Book createBook(@RequestBody Book bookObject) {
        LOGGER.info("calling createBook method from controller ");
        return bookService.createBook(bookObject);
    }

    //update a book
    // http://localhost:9092/api/books/1
    @PutMapping(path = "/books/{bookId}")
    public Book updateBook(@PathVariable(
            value = "bookId") Long bookId, @RequestBody Book bookObject) {
        LOGGER.info("calling updateBook method from controller");
        return bookService.updateBook(bookId, bookObject);
    }


    //Delete Single Book
    //http://localhost:9092/api/books/1
    @DeleteMapping(path = "/books/{bookId}")
    public Optional<Book> deleteBook(@PathVariable(value = "bookId") Long bookId) {
        LOGGER.info("calling deleteBook method from controller");
        return bookService.deleteBook(bookId);
    }


//====AUTHOR====//

    //get all authors
    // http://localhost:9092/api/authors
    @GetMapping("/authors")
    public List<Author> getAuthors() {
        LOGGER.info("calling getAuthors method from controller");
        return bookService.getAuthors();
    }

    //get a single author
    //http://localhost:9092/api/authors/1
    @GetMapping("/authors/{authorId}")
    public Optional getAuthor(@PathVariable Long authorId) {
        LOGGER.info("calling getAuthor method from controller");
        return bookService.getAuthor(authorId);
    }

    //create a book and add a author's info to the book
    //http://localhost:9092/api/books/1/authors
    @PostMapping(path = "/books/{bookId}/authors")
    public Author createAuthor(@PathVariable Long bookId, @RequestBody Author authorObject) {
        LOGGER.info("calling createAuthor method from controller");
        return bookService.createAuthor(bookId, authorObject);
    }

    //update a author
    //http://localhost:9092/api/authors/1
    @PutMapping(path = "/authors/{authorId}")
    public Author updateAuthor(@PathVariable(
            value = "authorId") Long authorId, @RequestBody Author authorObject) {
        LOGGER.info("calling updateAuthor method from controller");
        return bookService.updateAuthor(authorId, authorObject);
    }


    //delete a author
    //http://localhost:9092/api/authors/1
    @DeleteMapping(path = "/authors/{authorId}")
    public Optional<Author> deleteAuthor(@PathVariable(value = "authorId") Long authorId) {
        LOGGER.info("calling deleteAuthor method from controller");
        return bookService.deleteAuthor(authorId);
    }

    //====Genre======//
    //http://localhost:9092/api/genres
    //get all genres
    @GetMapping("/genres")
    public List<Genre> getGenres() {
        LOGGER.info("calling getGenres method from controller");
        return bookService.getGenres();
    }

    //get single genre
    //http://localhost:9092/api/genres/1
    @GetMapping("/genres/{genreId}")
    public Optional getGenre(@PathVariable Long genreId) {
        LOGGER.info("calling getGenre method from controller");
        return bookService.getGenre(genreId);
    }

    //create book and add genre info
    //http://localhost:9092/api/books/1/genres
    @PostMapping(path = "/books/{bookId}/genres")
    public Genre createGenre(@PathVariable Long bookId, @RequestBody Genre genreObject) {
        LOGGER.info("calling createGenre method from controller");
        return bookService.createGenre(bookId, genreObject);
    }

    //update a genre
    //http://localhost:9092/api/genres/1
    @PutMapping(path = "/genres/{genreId}")
    public Genre updateGenre(@PathVariable(
            value = "genreId") Long genreId, @RequestBody Genre genreObject) {
        LOGGER.info("calling updateGenre method from controller");
        return bookService.updateGenre(genreId, genreObject);
    }

    //delete a  genre
    //http://localhost:9092/api/genres/1
    @DeleteMapping(path = "/genres/{genreId}")
    public Optional<Genre> deleteGenre(@PathVariable(value = "genreId") Long genreId) {
        LOGGER.info("calling deleteGenre method from controller");
        return bookService.deleteGenre(genreId);
    }


    //=====Publisher=====//
    //get all publishers
    //http://localhost:9092/api/publishers
    @GetMapping("/publishers")
    public List<Publisher> getPublishers() {
        LOGGER.info("calling getPublishers method from controller");
        return bookService.getPublishers();
    }

    //get a single publisher
  //http://localhost:9092/api/publishers/1
    @GetMapping("/publishers/{publisherId}")
    public Optional getPublisher(@PathVariable Long publisherId) {
        LOGGER.info("calling getPublisher method from controller");
        return bookService.getPublisher(publisherId);
    }

    //create a book and add  publisher's info to the book
    //http://localhost:9092/api/books/1/publishers
    @PostMapping(path = "/books/{bookId}/publishers")
    public Publisher createPublisher(@PathVariable Long bookId, @RequestBody Publisher publisherObject) {
        LOGGER.info("calling createPublisher method from controller");
        return bookService.createPublisher(bookId, publisherObject);
    }

    //update publisher
    //http://localhost:9092/api/publishers/1
    @PutMapping(path = "/publishers/{publisherId}")
    public Publisher updatePublisher(@PathVariable(
            value = "publisherId") Long publisherId, @RequestBody Publisher publisherObject) {
        LOGGER.info("calling updatePublisher method from controller");
        return bookService.updatePublisher(publisherId, publisherObject);
    }


    //delete a  publisher
    //http://localhost:9092/api/publishers/1
    @DeleteMapping(path = "/publishers/{publisherId}")
    public Optional<Publisher> deletePublisher(@PathVariable(value = "publisherId") Long publisherId) {
        LOGGER.info("calling deletePublisher method from controller");
        return bookService.deletePublisher(publisherId);

    }


}










