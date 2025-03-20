package com.ecommerce.ghani.e_cormmerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ghani.e_cormmerce.model.Category;
import com.ecommerce.ghani.e_cormmerce.services.CategoryService;
import com.ecommerce.ghani.e_cormmerce.services.ProductService;

@RestController
public class Home {

    private ProductService productService;
    private CategoryService categoryService;

    public Home(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/")
    public String home() {
        return "well Come to E-commerce system";
    }

    @GetMapping("/getcategorys")
    public ResponseEntity<List<Category>> getCategorys() {
        return new ResponseEntity<>(categoryService.getCategory(), HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
    }

}
