package com.example.project2.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class GenreController {
    //Get all Genres
    // http://localhost:9092/api/books/1/genres
    @GetMapping(path = "/genre/")
    public String getGenres() {
        return "get all genres";
    }

    // http://localhost:9092/api/genres/1
    // Get a single genre
    @GetMapping(path = "/genres/{genresId}")
    public String getGenre(@PathVariable Long genreId) {
        return "getting the genre with the id of " + genreId;
    }


    //Creating a Single genre
    // http://localhost:9092/api/books/1/genres/1
    @PostMapping("/genres/")
    public String creatGenre(@RequestBody String body) {
        return "creating a genre " + body;
    }


    //Updating Single Genre
    //   http://localhost:9092/api/books/1/genres/1
    @PutMapping("/genres/{genresId}")
    public String updateGenre(@PathVariable(value = "genreId") Long genreId, @RequestBody String body) {
        return "updating the genre with the id of " + genreId + body;

    }

    //Delete single genre
    // http://localhost:9092/api/books/1/genres/1
    @DeleteMapping("/genres/{genresId}")
    public String deleteGenre(@PathVariable(value = "genreId") Long genreId) {
        return "deleting the genre with the id of " + genreId;
}}
