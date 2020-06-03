package com.apple.controllers.cms.user_management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResetPassword {
    @GetMapping("/forgot-password")
    public String passwordReset() {
        return "fragments/CMS/authentication/forgot_password";
    }

    @PostMapping("/forgot-password")
    public String resetPassword() {
        return "fragments/CMS/authentication/sign_in_username";
    }
}
