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
    ResponseEntity<String> getEmail(@RequestParam("email") @NotBlank @Email(message = "provide a valid email address") @Min(value = 12, message = "email must be equal to or greater than 12")
                                           @Max(value = 24, message = "email has to be less than or equal to 24") String email){
        return ResponseEntity.ok("valid Email");
    }

    @PostMapping("/emailValidator")
    ResponseEntity<String> postEmail(@RequestParam("email") @NotBlank @Email(message = "provide a valid email address")  @Min(value = 12, message = "email must be equal to or greater than 12")
                                     @Max(value = 24, message = "email has to be less than or equal to 24") String email){
        return ResponseEntity.ok("valid Email");
    }

    @GetMapping("/passwordValidator")
    ResponseEntity<String> getPasword(@RequestParam("password") @NotBlank(message = "password can not be empty") @Min(value = 6, message = "password must be equal to or greater than 6")
                                      @Max(value = 18, message = "password has to be less than or equal to 18")  String password){
        return ResponseEntity.ok("valid Password");
    }

    @PostMapping("/passwordValidator")
    ResponseEntity<String> postPasword(@RequestParam("password") @NotBlank(message = "password can not be empty") @Min(value = 6, message = "password must be equal to or greater than 6")
                                       @Max(value = 18, message = "password has to be less than or equal to 18") String password){
        return ResponseEntity.ok("valid Password");
    }


}
