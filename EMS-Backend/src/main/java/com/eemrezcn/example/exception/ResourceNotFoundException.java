package com.eemrezcn.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND) //It is used to specify the HTTP response status code in case of an exception.
public class ResourceNotFoundException extends RuntimeException //It is a subclass of the RuntimeException class.
{
    public ResourceNotFoundException(String message)    //It is a constructor that takes a String message as a parameter.
    {
        super(message);
    }
}
