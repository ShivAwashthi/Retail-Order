package com.example.Retail_backend.DTO;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Long productId;
    private int quantity;
}