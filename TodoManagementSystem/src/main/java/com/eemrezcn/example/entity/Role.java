package com.eemrezcn.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Getter methods for all fields
@Setter // Setter methods for all fields
@NoArgsConstructor // Constructor with no arguments
@AllArgsConstructor  // Constructor with all arguments
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "roles") // This tells Hibernate to name the table as `roles`
public class Role {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private Long id; // Long is a 64-bit integer
    private String name; // String is a sequence of characters
}