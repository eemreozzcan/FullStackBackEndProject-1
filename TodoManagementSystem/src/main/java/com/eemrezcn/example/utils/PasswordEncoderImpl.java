package com.eemrezcn.example.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl
{
    public static void main(String[] args)
    {
        //this is a test class for password encoder
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        //this is a test class for password encoder
        System.out.println(passwordEncoder.encode("emre"));

        //this is a test class for password encoder
        System.out.println(passwordEncoder.encode("admin"));
    }
}
