package com.example.project2.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//exception model classes
//handles runtime errors
//purpose: maintain the normal flow of the application
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InformationNotFoundException extends RuntimeException{
    public InformationNotFoundException(String message){
        super(message);
}}
