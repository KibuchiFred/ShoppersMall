package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @GetMapping("/register")
    public String getHomePage() {
        return "fragments/sign_up";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "fragments/sign_in_username";
    }

    @PostMapping("/login")
    public String login() {

        return "fragments/sign_in_password";
    }

    @GetMapping("/forgot-password")
    public String passwordReset() {
        return "fragments/forgot_password";
    }

    @PostMapping("/forgot-password")
    public String resetPassword() {
        return "fragments/sign_in_username";
    }

}