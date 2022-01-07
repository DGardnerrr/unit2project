package com.example.project2.controller;


import com.example.project2.exception.InformationExistsException;
import com.example.project2.exception.InformationNotFoundException;
import com.example.project2.model.Genre;
import com.example.project2.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

//
//(2. Genres)
//        [GET] endpoint: "/api/books/1/genres" -
//        [POST] endpoint: "/api/books/1/genres/1 " -
//        [PUT] endpoint: "/api/books/1/genres/1" -
//        [DELETE] endpoint: "/api/books/1/genres/1" -

@RestController
@RequestMapping(path="/api")
public class GenreController {

    private GenreRepository genreRepository;

    private static final Logger LOGGER = Logger.getLogger(GenreController.class.getName());

    @Autowired
    public void GenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    //Get all Genres
    // http://localhost:9092/api/books/1/genres
    @GetMapping("/books/1/genres")
    public List<Genre> getGenres() {
        LOGGER.info("calling getGenres method from genre controller");
        return genreRepository.findAll();
    }



    //Creating a Single genre
    // http://localhost:9092/api/books/1/genres/1
    @PostMapping(path = "/books/{bookid}/genres/{genreid}")
    public Genre createGenre(@RequestBody Genre genreObject){
        LOGGER.info("calling createGenre method from genre controller");
        Genre genre = genreRepository.findByName(genreObject.getName());
        if (genre != null) {
            throw new InformationExistsException("genre with name " + genre.getName() + " already exists");
        } else {
            return genreRepository.save(genreObject);
        }
    }


    //Updating Single Genre
    //   http://localhost:9092/api/books/1/genres/1
    @PutMapping(path = "/books/{bookid}/genres/{genreid}")
    public Genre updateGenre(@PathVariable(value = "genreID") Long genreID, @RequestBody Genre genreObject) {
        LOGGER.info("calling updateGenre method from genre controller");
        Optional<Genre> genre= genreRepository.findById(genreID);
        if (genre.isPresent()) {
            if (genreObject.getName().equals(genre.get().getName())) {
                LOGGER.warning("genre name is equals to database object name");
                throw new InformationExistsException("genre " + genre.get().getName() + " already exists");
            } else {
                Genre updateGenre = genreRepository.findById(genreID).get();
                updateGenre.setName(genreObject.getName());
                updateGenre.setDescription(genreObject.getDescription());
                return genreRepository.save(updateGenre);
            }
        } else {
            throw new InformationNotFoundException("genre with id " + genreID + " not found");
        }

    }


    //Delete single genre
    //http://localhost:9092/api/books/1/genres/1
    @DeleteMapping(path = "/books/{bookid}/genres/{genreid}")
    public String deleteGenre(@PathVariable(value = "genreID") Long genreID) {
        LOGGER.info("calling deleteGenre method from genre controller");
        Optional<Genre> genre = genreRepository.findById(genreID);
        if (genre.isPresent()) {
            genreRepository.deleteById(genreID);
        } else {
            throw new InformationNotFoundException("genre with id " + genreID + " not found");
        }
        return "deleting genre with id of " + genreID;
    }

}
