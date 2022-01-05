package com.example.project2.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @GetMapping(path = "/books/")
    public String getBooks() {
        return "get all books";
    }

    @GetMapping(path = "/books/{booksId}")
    public String getBook(@PathVariable Long bookId) {
        return "getting the category with the id of " + bookId;

    }

    @PostMapping("/books/")
    public String createBook(@RequestBody String body) {
        return "creating a book " + body;
    }

    @PutMapping("/books/{bookId}")
    public String updateBook(@PathVariable(value = "bookId") Long bookId, @RequestBody String body) {
        return "updating the book with the id of " + bookId + body;

    }

    @DeleteMapping("/books/{booksId}")
    public String deleteBook(@PathVariable(value = "bookId") Long bookId) {
        return "deleting the book with the id of " + bookId;

}}


