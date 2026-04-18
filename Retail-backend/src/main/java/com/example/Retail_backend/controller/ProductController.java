package com.example.Retail_backend.controller;

import com.example.Retail_backend.model.Product;
import com.example.Retail_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{categoryId}")
    public Product create(@RequestBody Product p,
                          @PathVariable Long categoryId){
        return service.create(p, categoryId);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/category/{id}")
    public List<Product> byCategory(@PathVariable Long id){
        return service.byCategory(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}