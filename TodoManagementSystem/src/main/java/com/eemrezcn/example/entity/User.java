package com.eemrezcn.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter // Setter methods for all fields
@Getter // Getter methods for all fields
@NoArgsConstructor // Constructor with no arguments
@AllArgsConstructor // Constructor with all arguments
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users") // This tells Hibernate to name the table as `users`
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private Long id;
    private String name;
    @Column(nullable = false, unique = true) // This column is required
    private String username; // String is a sequence of characters
    @Column(nullable = false, unique = true) // This column is required
    private String email; // String is a sequence of characters
    @Column(nullable = false) // This column is required
    private String password; // String is a sequence of characters

    /*This code establishes a ManyToMany relationship and associates users with roles. The relationship is loaded eagerly,
     meaning that when a user is loaded, their roles are immediately fetched using fetch = FetchType.EAGER.
     The cascade = CascadeType.ALL ensures that any changes made to the user (persist, merge, remove, refresh) are also applied to their roles.*/
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;
}