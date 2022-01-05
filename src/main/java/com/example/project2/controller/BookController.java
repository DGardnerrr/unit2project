package com.example.project2.controller;

import org.springframework.web.bind.annotation.*;

@RestController
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
    git pull


    Read More:
    Pull is not possible because you have unmerged files
    Pull is not possible because you have unmerged files. Please, fix them up in the work tree, and then
    Error: You have not concluded your merge (MERGE_HEAD exists)
    Git pull undo misoperation
    You have not concluded your merge (MERGE_HEAD exists)
    How to cancel the commit, how to cancel the commit after git commit, and how to change the submitted content
    Error: failed to push some refs to ‘xxx’
    Git failed to submit data error: failed to push some refs to’https://github.com/XXXXXXX/gif.git’
    How to Fix GIT Push Error
    Git solves pull origin error: the following untracked working tree files would be rewritten by merge
    You need to resolve your current index first
[Git & GitHub] Solution: error: failed to push some refs to’https://github.com/xxxx.git’
    Bad default revision ‘head’
    Solve github :error: failed to push some refs to problem
[Git] git pull pull remote git push to remote git commit submit reject
    Leetcode-234: palindrome linked list
[FAQ] after git merge, the push to Gerrit fails, indicating no new changes?
    error: Your local changes to the following files would be overwritten by merge
    Resolving fatal: reusing to merge unrelated histories in Git


    This entry was posted in How to Fix and tagged Go on 2020-11-04.
    Post navigation← error: ‘::main’ must return ‘int’Install wampserver and prompt could not execute menu item internal error →


    Search for:

    RECENT POSTS
    Vue Project Error: Error from chokidar [How to Solve]
            [Solved] Matlab 2021b install activate Error: License manager error – 103
            [Solved] xml/apr_xml.c:35:19: fatal error: expat.h: No such file or directory #include ＜expat.h＞
    NameError: name ‘_C‘ is not defined [How to Solve]
    How to Solve Geopy library Error: Configurationerror Error
    TAGS
& View Android Android studio back-end Big data bug c++ database Deep learning development language docker eclipse error front end git Hadoop idea java javascript linux maven mybatis mysql node.js note Npm OpenCV OpenGL Operation and maintenance php ProgrammerAH python pytorch qt report errors solution spring spring boot SQL tensorflow The database tomcat ubuntu View.js windows

    Proudly powered by WordPress


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


