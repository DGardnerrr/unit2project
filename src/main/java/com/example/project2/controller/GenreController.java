package com.example.project2.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GenreController {
    //Get all Genres
    // http://localhost:9092/api/books/1/genres
    @GetMapping(path = "/genre/")
    public String getGenres() {
        return "get all genres";
    }

    }