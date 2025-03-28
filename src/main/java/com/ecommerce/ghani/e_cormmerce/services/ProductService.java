package com.ecommerce.ghani.e_cormmerce.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ghani.e_cormmerce.model.Category;
import com.ecommerce.ghani.e_cormmerce.model.Product;
import com.ecommerce.ghani.e_cormmerce.repository.ProductJpa;

@Service
public class ProductService {

    private ProductJpa productJpa;

    private CategoryService categoryService;

    public ProductService(ProductJpa productJpa, CategoryService categoryService) {

        this.productJpa = productJpa;
        this.categoryService = categoryService;
    }

    public List<Product> getAllProducts() {
        return productJpa.findAll();
    }

    // adding a Product
    public Product addProduct(Product product, Long id) {
        Category category = categoryService.getCategoryById(id);
        product.setCategory(category);
        return productJpa.save(product);
    }

    public Product findById(Long id) {
        return productJpa.findById(id).orElse(new Product());
    }

    public Product updateProduct(Product product) {
        return productJpa.save(product);
    }

    public void deleteProduct(Long id) {
        productJpa.deleteById(id);
    }

}
