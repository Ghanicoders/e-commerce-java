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

import com.ecommerce.ghani.e_cormmerce.model.Category;
import com.ecommerce.ghani.e_cormmerce.services.CategoryService;

@RestController
public class CategoryController {

    private CategoryService categoryService; // injecting service layer to get category data from database

    // add categoyr end points
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;

    }

    @GetMapping("/getcategorys")
    public ResponseEntity<List<Category>> getCategorys() {
        return new ResponseEntity<>(categoryService.getCategory(), HttpStatus.OK);
    }

    @GetMapping("/getcategory/{id}")
    public ResponseEntity<Category> getCategorybyid(@PathVariable long id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
    }

    @PutMapping("/category")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.updateCategory(category), HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> removeCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);

        return new ResponseEntity<>("the category is removed ", HttpStatus.OK);
    }
}
