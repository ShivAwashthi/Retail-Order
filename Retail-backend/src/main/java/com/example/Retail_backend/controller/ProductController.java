package com.example.Retail_backend.controller;

<<<<<<< HEAD
import com.example.Retail_backend.model.Product;
import com.example.Retail_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

=======
>>>>>>> c873bf8e5f687ef79e9ece0037bd1e04d7ef9dd4
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

<<<<<<< HEAD
    @PreAuthorize("hasRole('ADMIN')")
=======
>>>>>>> c873bf8e5f687ef79e9ece0037bd1e04d7ef9dd4
    @PostMapping("/{categoryId}")
    public Product create(@RequestBody Product p,
                          @PathVariable Long categoryId){
        return service.create(p, categoryId);
    }

<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
=======
>>>>>>> c873bf8e5f687ef79e9ece0037bd1e04d7ef9dd4
    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }

<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
=======
>>>>>>> c873bf8e5f687ef79e9ece0037bd1e04d7ef9dd4
    @GetMapping("/category/{id}")
    public List<Product> byCategory(@PathVariable Long id){
        return service.byCategory(id);
    }

<<<<<<< HEAD
    @PreAuthorize("hasRole('ADMIN')")
=======
>>>>>>> c873bf8e5f687ef79e9ece0037bd1e04d7ef9dd4
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}