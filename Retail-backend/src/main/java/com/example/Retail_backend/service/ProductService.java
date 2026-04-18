package com.example.Retail_backend.service;


import com.example.Retail_backend.model.Category;
import com.example.Retail_backend.model.Product;
import com.example.Retail_backend.respository.CategoryRepository;
import com.example.Retail_backend.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;

    public Product create(Product p, Long categoryId){
        Category c = categoryRepo.findById(categoryId).orElseThrow();
        p.setCategory(c);
        return productRepo.save(p);
    }

    public List<Product> getAll(){ return productRepo.findAll(); }

    public List<Product> byCategory(Long id){
        return productRepo.findByCategoryCategoryId(id);
    }

    public void delete(Long id){ productRepo.deleteById(id); }
}