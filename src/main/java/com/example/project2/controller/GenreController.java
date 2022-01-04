package com.example.project2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {
    @GetMapping("/genre")  //url
    public String theGenre() { return "genre"; }
}