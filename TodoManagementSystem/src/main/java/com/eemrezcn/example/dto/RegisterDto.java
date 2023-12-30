package com.eemrezcn.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Getter methods for all fields
@Setter // Setter methods for all fields
@NoArgsConstructor // Constructor with no arguments
@AllArgsConstructor // Constructor with all arguments
public class RegisterDto {
    private String name;
    private String username;
    private String email;
    private String password;
}