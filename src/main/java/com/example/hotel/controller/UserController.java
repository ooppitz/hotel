package com.example.hotel.controller;


import com.example.hotel.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private User currentUser = new User("John Doe"); // Example stored name

    @GetMapping("/edit-name")
    public String editName(Model model) {
        model.addAttribute("user", currentUser);
        return "editName"; // This is the name of the HTML template
    }

    @PostMapping("/update-name")
    public String updateName(@RequestParam("name") String name) {
        currentUser.setName(name); // Update the user's name
        System.out.println("Setting name: " + name);
        return "redirect:/success"; // Redirect back to the edit page
    }

    @GetMapping("/success")
    public String success(Model model) {
        model.addAttribute("user", currentUser);
        return "success"; // This is the name of the HTML template
    }
}