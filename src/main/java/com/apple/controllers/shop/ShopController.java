package com.apple.controllers.shop;

import com.apple.models.cms.Role;
import com.apple.models.cms.User;
import com.apple.models.shop.Shop;
import com.apple.repositories.cms.RoleRepository;
import com.apple.services.cms.UserService;
import com.apple.services.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    private ShopService shopService;

    @Autowired
    private RoleRepository roleRepository;

//    @ModelAttribute("roles")
//    public List<Role> roleSelector(){
//        List<Role> rolesFound = roleRepository.findAll();
//        return rolesFound;
//    }

    @GetMapping("/create-shop")
    public String createShop(Model model){
        model.addAttribute("shop", new Shop());
        return "fragments/Shop/registerShop";
    }

    @Autowired
    private UserService userService;

    @PostMapping("/registerShop")
    public String createShop(@ModelAttribute("shop") @Valid Shop shop, BindingResult bindingResult, HttpSession httpSession){

        String createdByUser = (String) httpSession.getAttribute("username");

        User user = userService.loadByUsername(createdByUser);
        String createdBy = user.getUuid();

        shopService.createShop(shop, createdBy);

        return "fragments/CMS/authentication/sign_up";
    }
}
