package com.eemrezcn.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // @Getter is used to generate getter methods for the properties in the class.
@Setter // @Setter is used to generate setter methods for the properties in the class.
@NoArgsConstructor // @NoArgsConstructor is used to generate a constructor with no parameters.
@AllArgsConstructor  // @AllArgsConstructor is used to generate a constructor with all properties in the class.
@Entity // @Entity is used to mark the class as an entity bean.
@Table(name="employees") // @Table is used to define the table name.
public class Employee
{
    @Id // @Id is used to define the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue is used to define the primary key generation strategy.
    private Long id; // @Id is used to define the primary key.

    @Column(name="first_name") // @Column is used to define the column name.
    private String firstName; // @Column is used to define the column name.

    @Column(name="last_name") // @Column is used to define the column name.
    private String lastName;    // @Column is used to define the column name.

    @Column(name="email", nullable=false, unique = true) // @Column is used to define the column name.
    private String email;   // @Column is used to define the column name.
}
