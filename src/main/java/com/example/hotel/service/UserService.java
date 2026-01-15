package com.example.hotel.service;

import com.example.hotel.model.User;
import com.example.hotel.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User getUserProxy(Long id){
        User user = repository.getReferenceById(id);
        return user;
    }

    public List<User> getAll() {
        List<User> users = repository.findAll();
        return users;
    }

}


