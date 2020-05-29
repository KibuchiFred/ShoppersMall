package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/register")
    public String getHomePage(){
        return "fragments/sign_up";
    }

    @GetMapping("/login")
    public String login(){
        return "fragments/sign_in";
    }
}
