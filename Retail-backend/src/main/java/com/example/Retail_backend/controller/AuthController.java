package com.example.Retail_backend.controller;

import com.example.Retail_backend.DTO.LoginRequest;
import com.example.Retail_backend.DTO.LoginResponse;
import com.example.Retail_backend.DTO.SignupRequest;
import com.example.Retail_backend.jwt.JwtUtils;
import com.example.Retail_backend.model.Role;
import com.example.Retail_backend.model.User;
import com.example.Retail_backend.respository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private  final JwtUtils jwtUtils;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello for both admin and user";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String UserEndPoint(){
        return "Hello from user side";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String AdminEndPoint(){
        return "Hello from admin";
    }


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/api/auth/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest request) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Set<Role> roles = request.getRoles().stream()
                .map(role -> {
                    if (role.equalsIgnoreCase("admin")) return Role.ROLE_ADMIN;
                    else return Role.ROLE_USER;
                })
                .collect(Collectors.toSet());

        user.setRoles(roles);

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // ✅ Get user details from authentication
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // ✅ Generate JWT
            String jwt = jwtUtils.generateJwtToken(userDetails.getUsername());

            // ✅ Extract roles dynamically
            List<String> roles = userDetails.getAuthorities()
                    .stream()
                    .map(item -> item.getAuthority())
                    .toList();

            return ResponseEntity.ok(
                    new LoginResponse(jwt, userDetails.getUsername(), roles)
            );

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
    }

}

