package com.eemrezcn.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice // allows to handle exceptions across the whole application
public class GlobalExceptionHandler {

    // Handle specific exceptions
    @ExceptionHandler(TodoAPIException.class)
    public ResponseEntity<ErrorDetails> handleTodoAPIException(TodoAPIException exception,
                                                               WebRequest webRequest){

        // Create error details
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );

        // Return ResponseEntity
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}