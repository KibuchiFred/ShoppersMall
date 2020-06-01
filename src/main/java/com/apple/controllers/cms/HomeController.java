package com.apple.controllers.cms;

import com.apple.models.cms.Role;
import com.apple.models.cms.User;
import com.apple.repositories.cms.RoleRepository;
import com.apple.services.cms.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/register")
    public String getHomePage(Model model) {
        model.addAttribute("user", new User());
        return "fragments/CMS/sign_up";
    }

    @ModelAttribute("roles")
    public List<Role> roleSelector(){
    List<Role> rolesFound = roleRepository.findAll();
    return rolesFound;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){

        //User ifExists = userService.findByEmail(user.getUs_email());
      if (bindingResult.hasErrors()){

          return "fragments/CMS/sign_up";
      }
      else {
          userService.saveUser(user);
          return "fragments/CMS/sign_in_username";
      }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "fragments/CMS/sign_in_username";
    }

    @PostMapping("/login")
    public String login() {

        return "fragments/CMS/sign_in_password";
    }

    @GetMapping("/forgot-password")
    public String passwordReset() {
        return "fragments/CMS/forgot_password";
    }

    @PostMapping("/forgot-password")
    public String resetPassword() {
        return "fragments/CMS/sign_in_username";
    }

}