package com.example.project2.controller;

import com.example.project2.exception.InformationExistsException;
import com.example.project2.exception.InformationNotFoundException;
import com.example.project2.model.Author;
import com.example.project2.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


//(4. Author)
//        [GET] endpoint: "/api/books/1/authors" -  Request Type: None
//        [POST] endpoint: " /api/books/1/authors/1" - Request Type: author info
//        [PUT] endpoint: "/api/books/1/authors/1 - Request Type: author info
//        [DELETE] endpoint: "/api/books/1/authors/1" - Request Type: None

@RestController
@RequestMapping(path="/api")
public class AuthorController {


    private AuthorRepository authorRepository;

    private static final Logger LOGGER = Logger.getLogger(AuthorController.class.getName());

    @Autowired
    public void AuthorRepository(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }


    //Get all authors
    @GetMapping("/books/{bookid}/authors")
    public List<Author> getAuthors() {
        LOGGER.info("calling getAuthors method from author controller");
        return authorRepository.findAll();
    }

 //Get a single author
 @PostMapping(path = "/api/books/{bookid}/authors/{authorid}")
 public Optional<Author> getAuthor(@PathVariable Long authorID) {
     LOGGER.info("calling getAuthor method from author controller");
     Optional<Author> author = authorRepository.findById(authorID);
     if (author.isPresent()) {
         return author;
     } else {
         throw new InformationNotFoundException("author with id " + authorID + " not found");
     }

 }

 //	Delete a Single Author

    @DeleteMapping(path = "/books/{bookid}/authors/{authorid}")
    public String deleteAuthor(@PathVariable(value = "authorID") Long authorID) {
        LOGGER.info("calling deleteAuthor method from author controller");
        Optional<Author> author = authorRepository.findById(authorID);
        if (author.isPresent()) {
            authorRepository.deleteById(authorID);
        } else {
            throw new InformationNotFoundException("author with id " + authorID + " not found");
        }
        return "deleting author with id of " + authorID;
    }


    @PutMapping(path = " /books/{bookid}/authors/{authorid}")
    public Author updateAuthor(@PathVariable(value = "authorID") Long authorID, @RequestBody Author authorObject) {
        LOGGER.info("calling updateAuthor method from author controller");
        Optional<Author> author = authorRepository.findById(authorID);
        if (author.isPresent()) {
            if (authorObject.getName().equals(author.get().getName())) {
                LOGGER.warning("author name is equals to database object name");
                throw new InformationExistsException("author " + author.get().getName() + " already exists");
            } else {
                Author updateAuthor = authorRepository.findById(authorID).get();
                updateAuthor.setName(authorObject.getName());
                updateAuthor.setDescription(authorObject.getDescription());
                return authorRepository.save(updateAuthor);
            }
        } else {
            throw new InformationNotFoundException("author with id " + authorID + " not found");
        }

    }



 }










        
        
        
        














