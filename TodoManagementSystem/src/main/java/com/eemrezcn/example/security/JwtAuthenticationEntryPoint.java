package com.eemrezcn.example.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component // This annotation is used to mark a java class as a bean so the component-scanning mechanism of spring can pick it up and pull it into the application context
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, // This method is called whenever an exception is thrown due to an unauthenticated user trying to access a resource that requires authentication
                         HttpServletResponse response, // This method will send an error response with the specified status code and message
                         AuthenticationException authException)
                        throws IOException, ServletException {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage()); // Send error response
    }
}