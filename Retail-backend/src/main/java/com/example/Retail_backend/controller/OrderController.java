package com.example.Retail_backend.controller;

<<<<<<< HEAD
import com.example.Retail_backend.DTO.OrderRequest;
import com.example.Retail_backend.model.Order;
import com.example.Retail_backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

=======
import com.example.Retail_backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

>>>>>>> c873bf8e5f687ef79e9ece0037bd1e04d7ef9dd4
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

<<<<<<< HEAD
    @PreAuthorize("hasRole('User')")
=======
>>>>>>> c873bf8e5f687ef79e9ece0037bd1e04d7ef9dd4
    @PostMapping
    public Order placeOrder(@RequestBody OrderRequest req){
        return service.placeOrder(req);
    }

<<<<<<< HEAD
    @PreAuthorize("hasRole('ADMIN')")
=======
>>>>>>> c873bf8e5f687ef79e9ece0037bd1e04d7ef9dd4
    @GetMapping
    public List<Order> all(){
        return service.all();
    }

<<<<<<< HEAD
    @PreAuthorize("hasRole('ADMIN')")
=======
>>>>>>> c873bf8e5f687ef79e9ece0037bd1e04d7ef9dd4
    @GetMapping("/user/{id}")
    public List<Order> byUser(@PathVariable Long id){
        return service.byUser(id);
    }
}