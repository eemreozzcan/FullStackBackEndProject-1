package com.eemrezcn.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Getter methods for all fields
@Setter // Setter methods for all fields
@NoArgsConstructor // Constructor with no arguments
@AllArgsConstructor // Constructor with all arguments
public class JwtAuthResponse {
    private String accessToken; // JWT token
    private String tokenType = "Bearer"; // Token type
    private String role; // Role of the user
}