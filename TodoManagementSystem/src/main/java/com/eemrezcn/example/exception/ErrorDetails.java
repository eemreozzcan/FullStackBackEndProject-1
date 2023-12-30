package com.eemrezcn.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter // Getter methods for all fields
@Setter // Setter methods for all fields
@NoArgsConstructor // Constructor with no arguments
@AllArgsConstructor // Constructor with all arguments
public class ErrorDetails {
    private LocalDateTime timeStamp; // Time stamp of the error
    private String message; // Message of the error
    private String details; // Details of the error
}