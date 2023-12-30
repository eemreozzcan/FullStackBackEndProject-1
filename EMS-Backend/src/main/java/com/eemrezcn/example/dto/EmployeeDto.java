package com.eemrezcn.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // @Getter is used to generate getter methods for the properties in the class.
@Setter // @Setter is used to generate setter methods for the properties in the class.
@NoArgsConstructor // @NoArgsConstructor is used to generate a constructor with no parameters.
@AllArgsConstructor // @AllArgsConstructor is used to generate a constructor with all properties in the class.
public class EmployeeDto
{
    private Long id; // @Id is used to define the primary key.
    private String firstName;  // @Column is used to define the column name.
    private String lastName;  // @Column is used to define the column name.
    private String email; // @Column is used to define the column name.
}
