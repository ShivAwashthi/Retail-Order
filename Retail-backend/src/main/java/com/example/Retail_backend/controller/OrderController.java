package com.example.Retail_backend.controller;

import com.example.Retail_backend.DTO.OrderRequest;
import com.example.Retail_backend.model.Order;
import com.example.Retail_backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public Order placeOrder(@RequestBody OrderRequest req){
        return service.placeOrder(req);
    }

    @GetMapping
    public List<Order> all(){
        return service.all();
    }

    @GetMapping("/user/{id}")
    public List<Order> byUser(@PathVariable Long id){
        return service.byUser(id);
    }
}