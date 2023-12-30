package com.eemrezcn.example.service.impl;

import com.eemrezcn.example.dto.JwtAuthResponse;
import com.eemrezcn.example.dto.LoginDto;
import com.eemrezcn.example.dto.RegisterDto;
import com.eemrezcn.example.entity.Role;
import com.eemrezcn.example.entity.User;
import com.eemrezcn.example.exception.TodoAPIException;
import com.eemrezcn.example.repository.RoleRepository;
import com.eemrezcn.example.repository.UserRepository;
import com.eemrezcn.example.security.JwtTokenProvider;
import com.eemrezcn.example.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {


    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String register(RegisterDto registerDto) {

        // check username is already exists in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }

        // check email is already exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        // create new user
        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        // set user roles
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        // save user
        user.setRoles(roles);

        // save user
        userRepository.save(user);

        return "User Registered Successfully!.";
    }

    @Override
    public JwtAuthResponse login(LoginDto loginDto) {

        //authenticate user
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));

        //set authentication in security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //generate jwt token
        String token = jwtTokenProvider.generateToken(authentication);

        //get user details
        Optional<User> userOptional=userRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(),
                                                                         loginDto.getUsernameOrEmail());

        String role = null;

        if(userOptional.isPresent()){
            User loggedInUser = userOptional.get();
            Optional<Role> optionalRole = loggedInUser.getRoles().stream().findFirst();

            if(optionalRole.isPresent()){
                Role userRole = optionalRole.get();
                role = optionalRole.get().getName();

            }
        }
        //create jwt auth response
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        jwtAuthResponse.setRole(role);

        return jwtAuthResponse;
    }
}