package com.eemrezcn.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter  // Setter methods for all fields
@Getter // Getter methods for all fields
@NoArgsConstructor // Constructor with no arguments
@AllArgsConstructor // Constructor with all arguments
public class TodoDto {

    private Long id;
    private String title;
    private String description;
    private boolean completed;
}