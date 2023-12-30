package com.eemrezcn.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter // Setter methods for all fields
@Getter // Getter methods for all fields
@NoArgsConstructor // Constructor with no arguments
@AllArgsConstructor // Constructor with all arguments
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "todos") // This tells Hibernate to name the table as `todos`
public class Todo {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private Long id; // Long is a 64-bit integer

    @Column(nullable = false) // This column is required
    private String title; // String is a sequence of characters

    @Column(nullable = false) // This column is required
    private String description; // String is a sequence of characters
    private boolean completed;
}