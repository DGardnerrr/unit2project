package com.example.project2.controller;

import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping(path="/api")
public class BookController {

    // http://localhost:9092/api/books
    //Get all Books
    @GetMapping(path = "/books/")
    public String getBooks() {
        return "get all books";
    }


    // http://localhost:9092/api/books/1
    // Get a single book
    @GetMapping(path = "/books/{booksId}")
    public String getBook(@PathVariable Long bookId) {
        return "getting the book with the id of " + bookId;

    }


    // http://localhost:9092/api/books
    //Creating a Single Book
    @PostMapping("/books/")
    public String createBook(@RequestBody String body) {
        return "creating a book " + body;
    }

    // http://localhost:9092/api/books/1
    //Updating Single Book
    @PutMapping("/books/{bookId}")
    public String updateBook(@PathVariable(value = "bookId") Long bookId, @RequestBody String body) {
        return "updating the book with the id of " + bookId + body;

    }

    //Delete Single Book
    @DeleteMapping("/books/{booksId}")
    public String deleteBook(@PathVariable(value = "bookId") Long bookId) {
        return "deleting the book with the id of " + bookId;

}}


