package com.example.project2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @GetMapping("/author")  //url
    public String theAuthor() { return "Author"; }
//test
}
