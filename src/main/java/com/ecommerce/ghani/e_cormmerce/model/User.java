package com.ecommerce.ghani.e_cormmerce.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Long phoneNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<Order>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    public User(
            Long id, String name, String email, String password, Long phoneNumber, List<Order> orders, Cart cart) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
        this.cart = cart;

    }

    public User() {
    } // default constructor

    // setter methods for fields
    public void SetId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void SetOrdenrs(List<Order> orders) {

        this.orders = orders;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    // getter methods for fields

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getPhoneNumber() {
        return phoneNumber;

    }

    public List<Order> getOrders() {

        return orders;
    }

    public Cart getCart() {
        return cart;
    }
}
