package com.ecommerce.ghani.e_cormmerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ghani.e_cormmerce.model.Product;

@Repository
public interface ProductJpa extends JpaRepository<Product, Long> {

}
