package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;

@Controller
@Validated
public class AuthController {
    @GetMapping("/emailValidator")
    ResponseEntity<String> getEmail(@RequestParam("email") @NotBlank @Email(message = "provide a valid email address")
                                    @Size(min = 12, max = 36, message = "the size must be between 12 and 36") String email){
        return ResponseEntity.ok("valid Email");
    }

    @PostMapping("/emailValidator")
    ResponseEntity<String> postEmail(@RequestParam("email") @NotBlank @Email(message = "provide a valid email address")
                                             @Size(min = 12, max = 36, message = "the size must be between 12 and 36") String email){
        return ResponseEntity.ok("valid Email");
    }

    @GetMapping("/passwordValidator")
    ResponseEntity<String> getPasword(@RequestParam("password") @NotBlank(message = "password can not be empty")
                                      @Size(min = 6, max = 12, message = "the size must be between 6 and 12") String password){
        return ResponseEntity.ok("valid Password");
    }

    @PostMapping("/passwordValidator")
    ResponseEntity<String> postPasword(@RequestParam("password") @NotBlank(message = "password can not be empty")
                                       @Size(min = 6, max = 12, message = "the size must be between 6 and 12") String password){
        return ResponseEntity.ok("valid Password");
    }


}
