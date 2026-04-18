package com.example.Retail_backend.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private double totalAmount;
    private String status;
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
