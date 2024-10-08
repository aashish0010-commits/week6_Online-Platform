package com.Aashish.online_platform.project.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Aashish.online_platform.project.dto.UserDto;
import com.Aashish.online_platform.project.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register"; 
    }
    @PostMapping("/save") 
    public String handleRegistration(@Valid @ModelAttribute("user") UserDto userDto,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register"; 
        }

        userService.saveUser(userDto); 
        model.addAttribute("success", true); 
        return "redirect:/register?success=true"; 
    }
}
