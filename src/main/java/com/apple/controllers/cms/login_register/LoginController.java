package com.apple.controllers.cms.login_register;


import com.apple.models.cms.User;
import com.apple.services.cms.UserService;
import com.apple.services.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    //inject user service bean that has a method for finding user by username
    @Autowired
    UserService userService;

    //get the login page with username field.
    @GetMapping("/loginForm")
    public String loginForm(Model model, User user) {
        model.addAttribute("user", user);
        return "fragments/CMS/authentication/sign_in_username";
    }

    //on post request get the username from the form and put it on the current session
    //then return the page containing password field
    @PostMapping("/loginUsername")
    public String login(@ModelAttribute User user, HttpServletRequest httpSession) throws UsernameNotFoundException{

        //find user from the database using the username supplied by the user
        User foundUser = userService.loadByUsername(user.getUsUsername());

        //if username was not found, throw a username not found exception
        if (foundUser == null) {
            throw new UsernameNotFoundException("The user was not found");
        }
        httpSession.getSession().setAttribute("foundUser", foundUser);
        System.out.println("User passed: "+user.getUsUsername());

        return "fragments/CMS/authentication/sign_in_password";
    }

    //on the login form when the post request is made
    @PostMapping(value = "/loginPassword")
    public String loginPassword(@ModelAttribute User user, HttpSession session) {

        //fetch the username from the session
        User passedUser = (User) session.getAttribute("foundUser");

        System.out.println("Check user was passed "+passedUser);
        System.out.println("Check password was passed "+user.getUsPassword());

        //else select password for this username from the database
        String correctPassword = passedUser.getUsPassword();

        System.out.println("Password from database is: "+correctPassword);
        session.setAttribute("username", passedUser.getUsUsername());

        //check if the password supplied is equal to the password from the db.
        //if equals method returns true, direct the user on the index page
        //if equals method returns false, return user to username field to supply correct details.
        if (correctPassword.equals(user.getUsPassword())){
            return "fragments/CMS/authentication/forgot_password.html";
        }else
        return "fragments/CMS/authentication/sign_in_username";

    }

}