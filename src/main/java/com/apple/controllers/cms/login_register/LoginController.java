package com.apple.controllers.cms.login_register;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm() {
        return "fragments/CMS/authentication/sign_in_username";
    }

    @PostMapping("/login")
    public String login() {

        return "fragments/CMS/authentication/sign_in_password";
    }

}