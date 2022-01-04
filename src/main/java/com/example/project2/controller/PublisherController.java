package com.example.project2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
    @GetMapping("/publisher")  //url
    public String thePublisher() { return "publisher"; }
}
