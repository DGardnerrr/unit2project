package com.example.project2.controller;



import com.example.project2.model.Publisher;
import com.example.project2.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path="/api")
public class PublisherController {

    private PublisherRepository publisherRepository;

    private static final Logger LOGGER = Logger.getLogger(PublisherController.class.getName());

    @Autowired
    public void PublisherRepository(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    //Get all Publishers
    @GetMapping("/books/{bookid}/publishers")
    public List<Publisher> getPublishers() {
        LOGGER.info("calling getPublishers method from publisher controller");
        return publisherRepository.findAll();
    }










}

