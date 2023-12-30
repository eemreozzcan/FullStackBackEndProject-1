package com.eemrezcn.example.config;

import com.eemrezcn.example.security.JwtAuthenticationEntryPoint;
import com.eemrezcn.example.security.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // this is a configuration class
@EnableMethodSecurity // this enables method level security based on annotations
@AllArgsConstructor // this is a lombok annotation to create AllArgsConstructor
public class SpringSecurityConfig {

    //this is a bean to create a user
    private UserDetailsService userDetailsService;

    //this is a bean to create a password encoder
    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    //this is a bean to create a JwtAuthenticationFilter
    private JwtAuthenticationFilter authenticationFilter;

    //this is a bean to create a password encoder
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable()) //Disables CSRF protection.
                .authorizeHttpRequests((authorize) -> { //Applies authorization headers to HTTP requests.
                    authorize.requestMatchers("/api/auth/**").permitAll(); //Grants access to requests made to the URL pattern '/api/auth/**' for everyone.
                    authorize.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll(); //Grants access to requests made with the OPTIONS method for everyone.
                    authorize.anyRequest().authenticated(); //Indicates that authentication is required for all other requests.
                }).httpBasic(Customizer.withDefaults()); //Configures HTTP Basic authentication.

        //Adds a filter before other SecurityContextRepository filters to apply the JwtAuthenticationFilter.
        http.exceptionHandling( exception -> exception
                .authenticationEntryPoint(authenticationEntryPoint));
        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}