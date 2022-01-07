package com.example.project2.controller;



import com.example.project2.exception.InformationExistsException;
import com.example.project2.model.Publisher;
import com.example.project2.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//create single publisher
@PostMapping(path = "/books/{bookid}/publishers/{publisherid}")
public Publisher createPublisher(@RequestBody Publisher publisherObject){
    LOGGER.info("calling createPublisher method from publisher controller");
    Publisher publisher = publisherRepository.findByName(publisherObject.getName());
    if (publisher != null) {
        throw new InformationExistsException("publisher with name " + publisher.getName() + " already exists");
    } else {
        return publisherRepository.save(publisherObject);
    }
}








}

