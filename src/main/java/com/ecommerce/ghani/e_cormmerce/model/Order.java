package com.ecommerce.ghani.e_cormmerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private long totap_privce;
    private String order_status;
    private Date creat_at;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "orders_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<>();

    public Order(Long id, User user, long totap_privce, String order_status, Date creat_at, List<Product> products) {
        this.id = id;
        this.user = user;
        this.totap_privce = totap_privce;
        this.order_status = order_status;
        this.creat_at = creat_at;
        this.products = products;
    }

    // default constructor
    public Order() {
    }

    // getters and setters for fields
    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTotap_privce(long totap_privce) {
        this.totap_privce = totap_privce;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public void setCreat_at(Date creat_at) {
        this.creat_at = creat_at;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public long getTotap_privce() {
        return totap_privce;
    }

    public String getOrder_status() {
        return order_status;
    }

    public Date getCreat_at() {
        return creat_at;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
