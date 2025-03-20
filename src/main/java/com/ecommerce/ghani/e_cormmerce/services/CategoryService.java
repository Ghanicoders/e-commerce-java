package com.ecommerce.ghani.e_cormmerce.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ghani.e_cormmerce.model.Category;
import com.ecommerce.ghani.e_cormmerce.repository.CategoryRepository;

@Service
public class CategoryService {

    private CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(new Category());
    }

    public List<Category> getCategory() {
        return categoryRepo.findAll();
    }

    public Category updCategory(Category category) {
        return categoryRepo.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }
}
