package com.example.Retail_backend.service;

<<<<<<< HEAD
import com.example.Retail_backend.DTO.OrderItemRequest;
import com.example.Retail_backend.DTO.OrderRequest;
import com.example.Retail_backend.model.Order;
import com.example.Retail_backend.model.OrderItem;
import com.example.Retail_backend.model.Product;
import com.example.Retail_backend.model.User;
import com.example.Retail_backend.respository.OrderItemRepository;
import com.example.Retail_backend.respository.OrderRepository;
import com.example.Retail_backend.respository.ProductRepository;
import com.example.Retail_backend.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

=======
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

>>>>>>> c873bf8e5f687ef79e9ece0037bd1e04d7ef9dd4
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;
    private final OrderItemRepository itemRepo;
    private final UserRepository userRepo;

    public Order placeOrder(OrderRequest req){

        User user = userRepo.findById(req.getUserId()).orElseThrow();

        Order order = new Order();
        order.setUser(user);
        order.setStatus("PENDING");
        order.setOrderDate(LocalDateTime.now());

        order = orderRepo.save(order);

        double total = 0;

        for(OrderItemRequest i : req.getItems()){

            Product p = productRepo.findById(i.getProductId()).orElseThrow();

            if(p.getStockQuantity() < i.getQuantity()){
                throw new RuntimeException("Out of stock");
            }

            p.setStockQuantity(p.getStockQuantity() - i.getQuantity());
            productRepo.save(p);

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(p);
            item.setQuantity(i.getQuantity());
            item.setPriceAtPurchase(p.getPrice());

            total += p.getPrice() * i.getQuantity();

            itemRepo.save(item);
        }

        order.setTotalAmount(total);
        return orderRepo.save(order);
    }

    public List<Order> all(){ return orderRepo.findAll(); }

    public List<Order> byUser(Long userId){
        return orderRepo.findByUserUserId(userId);
    }
}