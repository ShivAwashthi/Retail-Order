package com.example.Retail_backend.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long  productId;

    private String name;
    private String description;
    private Double price;
    private int stockQuantity;

@ManyToOne
@JoinColumn(name="category_id")
private Category category;

}