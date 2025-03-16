package com.ecommerce.ghani.e_cormmerce.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.ghani.e_cormmerce.model.User;
import com.ecommerce.ghani.e_cormmerce.repository.UserJpa;

@Service
public class UserService {

    private UserJpa userJpa;

    public UserService(UserJpa userJpa) {
        this.userJpa = userJpa;
    }

    public User createUser(User user) {
        return userJpa.save(user);
    }

    public List<User> getUsers() {
        return userJpa.findAll();
    }

    public User getUserById(Long id) {
        return userJpa.findById(id).orElse(new User());
    }

    public User updateUser(User user) {
        return userJpa.save(user);
    }

    public void deleteUser(Long id) {
        userJpa.deleteById(id);
    }
}
