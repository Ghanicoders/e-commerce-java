package com.ecommerce.ghani.e_cormmerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ghani.e_cormmerce.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
