package com.eemrezcn.example.service;

import com.eemrezcn.example.dto.JwtAuthResponse;
import com.eemrezcn.example.dto.LoginDto;
import com.eemrezcn.example.dto.RegisterDto;

public interface AuthService
{

    String register(RegisterDto registerDto);

    JwtAuthResponse login(LoginDto loginDto);

}
