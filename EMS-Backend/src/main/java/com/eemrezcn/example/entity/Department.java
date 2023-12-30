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
@Table(name="departments") // @Table is used to define the table name.
public class Department
{
    @Id // @Id is used to define the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue is used to define the primary key generation strategy.
    private Long id; // @Id is used to define the primary key.

    @Column(name="department_name") // @Column is used to define the column name.
    private String departmentName; // @Column is used to define the column name.

    @Column(name="department_description") // @Column is used to define the column name.
    private String departmentDescription; // @Column is used to define the column name.
}
