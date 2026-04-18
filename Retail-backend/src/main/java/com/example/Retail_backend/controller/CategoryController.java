package com.example.Retail_backend.controller;

<<<<<<< HEAD
import com.example.Retail_backend.model.Category;
import com.example.Retail_backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

=======
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

>>>>>>> c873bf8e5f687ef79e9ece0037bd1e04d7ef9dd4
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;
<<<<<<< HEAD
    @PreAuthorize("hasRole('ADMIN')")
=======

>>>>>>> c873bf8e5f687ef79e9ece0037bd1e04d7ef9dd4
    @PostMapping
    public Category create(@RequestBody Category c){
        return service.create(c);
    }

<<<<<<< HEAD

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
=======
>>>>>>> c873bf8e5f687ef79e9ece0037bd1e04d7ef9dd4
    @GetMapping
    public List<Category> getAll(){
        return service.getAll();
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