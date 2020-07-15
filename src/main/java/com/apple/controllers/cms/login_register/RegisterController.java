package com.apple.controllers.cms.login_register;

import com.apple.models.cms.Role;
import com.apple.models.cms.User;
//import com.apple.repositories.cms.RoleRepository;
import com.apple.services.cms.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {


//    @Autowired
//    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "fragments/CMS/authentication/sign_up";
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                                     ModelAndView modelAndView){

        User ifExists = userService.findByEmail(user.getUsEmail());

        if (bindingResult.hasErrors()){

            modelAndView.setViewName("fragments/CMS/authentication/sign_up");

        }
        else if (ifExists != null){
            System.out.println(" \n A user with that email was found.");
            modelAndView.addObject("message","User with that email already exists");
            bindingResult.reject("usEmail");
            modelAndView.setViewName("fragments/CMS/authentication/sign_up");

        }else {

            userService.saveUser(user);
            modelAndView.setViewName("fragments/CMS/authentication/sign_in_username");
        }

            return modelAndView;
    }

}
