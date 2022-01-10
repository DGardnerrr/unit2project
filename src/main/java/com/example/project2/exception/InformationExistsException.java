package com.example.project2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//exception model classes

@ResponseStatus(HttpStatus.CONFLICT)
public class InformationExistsException extends RuntimeException {
    public InformationExistsException(String message){
        super(message);
}}
