package com.example.Retail_backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public Category create(@RequestBody Category c){
        return service.create(c);
    }

    @GetMapping
    public List<Category> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}