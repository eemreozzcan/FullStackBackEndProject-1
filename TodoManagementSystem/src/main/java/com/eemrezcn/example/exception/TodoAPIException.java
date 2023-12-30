package com.eemrezcn.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter // Getter methods for all fields
@AllArgsConstructor // Constructor with all arguments
public class TodoAPIException extends RuntimeException{ // Custom exception class
    private HttpStatus status; // HTTP status code
    private String message; // Message of the exception
}