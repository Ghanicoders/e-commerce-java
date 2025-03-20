package com.ecommerce.ghani.e_cormmerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ghani.e_cormmerce.model.Product;
import com.ecommerce.ghani.e_cormmerce.services.ProductService;

@RestController
public class ProductController {

    // This is product Service Object for run bussines logic
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getprducts")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/product/{id}")
    public ResponseEntity<Product> addProduct(@RequestBody Product product, @PathVariable Long id) {
        return new ResponseEntity<>(productService.addProduct(product, id), HttpStatus.OK);
    }

    @PutMapping("/product")
    ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }

    // delete product a product
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable Long id) {
        productService.deleteProduct(id);

        return new ResponseEntity<>("the product is removed ", HttpStatus.OK);
    }

}
