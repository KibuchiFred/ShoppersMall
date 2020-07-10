package com.apple.controllers.shop;

import com.apple.models.shop.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CreateSHop {

    @GetMapping("create_shop")
    public String createShop(Model model){
        model.addAttribute("shop", new Shop());
        return "registerShop";
    }

    @PostMapping("/create-shop")
    public String createShop(@ModelAttribute("shop") @Valid Shop shop, BindingResult bindingResult){

        return "something";
    }
}
