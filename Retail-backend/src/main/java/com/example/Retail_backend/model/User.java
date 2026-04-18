package com.example.Retail_backend.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long  userId;

    private String name;
    private String email;
    private String password;
}
