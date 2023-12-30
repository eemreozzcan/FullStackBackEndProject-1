package com.eemrezcn.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) // this annotation is used to map the exception class to the specified HTTP status code
public class ResourceNotFoundException extends RuntimeException{ // extends RuntimeException because we want to throw this exception at runtime

    // Constructor
    public ResourceNotFoundException(String message) {
        super(message);
    }
}