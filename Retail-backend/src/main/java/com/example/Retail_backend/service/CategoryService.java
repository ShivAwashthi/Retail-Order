package com.example.Retail_backend.service;

import com.example.Retail_backend.model.Category;
import com.example.Retail_backend.respository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repo;

    public Category create(Category c){
        return repo.save(c);

    }
    public List<Category> getAll(){
        return repo.findAll();
    }
    public Category get(Long id){
        return repo.findById(id).orElseThrow();
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}