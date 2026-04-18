package com.example.Retail_backend.DTO;

import lombok.Data;
import java.util.Set;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private Set<String> roles; // USER / ADMIN
}