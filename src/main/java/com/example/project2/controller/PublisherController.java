package com.example.project2.controller;



import com.example.project2.exception.InformationExistsException;
import com.example.project2.exception.InformationNotFoundException;
import com.example.project2.model.Publisher;
import com.example.project2.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

//update a single publisher
@PutMapping(path = "/books/{bookid}/publishers/{publisherid}")
public Publisher updatePublisher(@PathVariable(value = "publisherID") Long publisherID, @RequestBody Publisher publisherObject) {
    LOGGER.info("calling updatePublisher method from publisher controller");
    Optional<Publisher> publisher= publisherRepository.findById(publisherID);
    if (publisher.isPresent()) {
        if (publisherObject.getName().equals(publisher.get().getName())) {
            LOGGER.warning("publisher name is equals to database object name");
            throw new InformationExistsException("publisher " + publisher.get().getName() + " already exists");
        } else {
            Publisher updatePublisher = publisherRepository.findById(publisherID).get();
            updatePublisher.setName(publisherObject.getName());
            updatePublisher.setNum_authors(publisherObject.getNum_authors());
            updatePublisher.setRevenue(publisherObject.getRevenue());
            return publisherRepository.save(updatePublisher);
        }
    } else {
        throw new InformationNotFoundException("publisher with id " + publisherID + " not found");
    }

}

//delete a single publisher
@DeleteMapping(path = "/books/{bookid}/publishers/{publisherid}")
public String deletePublisher(@PathVariable(value = "publisherID") Long publisherID) {
    LOGGER.info("calling deletePublisher method from publisher controller");
    Optional<Publisher> publisher = publisherRepository.findById(publisherID);
    if (publisher.isPresent()) {
        publisherRepository.deleteById(publisherID);
    } else {
        throw new InformationNotFoundException("publisher with id " + publisherID + " not found");
    }
    return "deleting publisher with id of " + publisherID;
}

}


