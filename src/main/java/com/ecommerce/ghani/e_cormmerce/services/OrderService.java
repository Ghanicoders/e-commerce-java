package com.ecommerce.ghani.e_cormmerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ghani.e_cormmerce.model.Order;
import com.ecommerce.ghani.e_cormmerce.model.Product;
import com.ecommerce.ghani.e_cormmerce.model.User;
import com.ecommerce.ghani.e_cormmerce.repository.OrderRepository;

@Service
public class OrderService {

    private OrderRepository orderRepo;
    private UserService userService;
    private ProductService productService;

    public OrderService(OrderRepository orderRep, UserService userService, ProductService productService) {
        this.orderRepo = orderRep;
        this.userService = userService;
        this.productService = productService;
    }

    // Implement order related methods or order crud operations

    public List<Order> getOrders() {
        return orderRepo.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElse(new Order());
    }

    // order creation methods
    public Product createOrder(Long uid, Long pid) {

        // User user = userService.getUserById(uid);
        // System.out.println(user.toString());
        Product p1 = productService.findById(pid);
        // System.out.println(p1.toString());
        // if (user.getId() == null || product.contains(p1) == false) {
        // throw new RuntimeException("User or product not found");
        // } else {
        // order.setUser(user);
        // order.setProducts(product);
        // order.setCreat_at(new java.util.Date());
        // order.setTotap_privce(p1.getPrice()); // assuming price is in cents for
        // simplicity
        // System.out.println(order.toString());

        // // return orderRepo.save(order);
        // return order;
        // }
        return p1;

    }

    public Order updateOrder(Order order) {
        return orderRepo.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }

}
