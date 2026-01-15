package com.example.hotel.controller;


import com.example.hotel.model.User;
import com.example.hotel.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // Test-Link: http://localhost:8082/users/1

    @GetMapping("/{id}")
    String getUser(@PathVariable("id") Long id, Model model){

        User user = service.getUser(id);
        model.addAttribute("user", user);
        return "user";

   }

    // Test-Link: http://localhost:8082/users/edit/1
    @GetMapping("/edit/{id}")
    String editUser(@PathVariable("id") Long id, Model model){

        User user = service.getUser(id);
        model.addAttribute("user", user);
        return "user-edit";

    }

    @GetMapping("/all")
   String getAll(Model model) {

        List<User> users = service.getAll();
        model.addAttribute("users", users);
        return "user-list";

   }
}