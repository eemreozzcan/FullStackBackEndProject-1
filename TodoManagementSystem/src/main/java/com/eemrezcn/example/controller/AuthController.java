package com.eemrezcn.example.controller;

import com.eemrezcn.example.dto.JwtAuthResponse;
import com.eemrezcn.example.dto.LoginDto;
import com.eemrezcn.example.dto.RegisterDto;
import com.eemrezcn.example.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000") // allow to access from localhost:3000
@AllArgsConstructor // create constructor with all arguments
@RestController // create RESTful web services
@RequestMapping("/api/auth") // map web requests onto specific handler classes and/or handler methods
public class AuthController {

    private AuthService authService;

    // HTTP POST method for registering user
    // http://localhost:8080/api/auth/register
    // this method will be called when user clicks on register button
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // HTTP POST method for login
    // http://localhost:8080/api/auth/login
    // this method will be called when user clicks on login button
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        JwtAuthResponse jwtAuthResponse = authService.login(loginDto);
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

}