package com.apple.controllers.cms.login_register;

import com.apple.models.cms.ConfirmationToken;
import com.apple.models.cms.User;
import com.apple.repositories.cms.ConfirmationTokenReposiroty;
import com.apple.services.cms.TokenService;
import com.apple.services.cms.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    //inject user service bean that has a method for finding user by username
    @Autowired
    UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    ConfirmationTokenReposiroty confirmationTokenReposiroty;

    //get the login page with username field.
    @GetMapping("/loginForm")
    public String loginForm(Model model, User user) {
        model.addAttribute("user", user);
        return "fragments/CMS/authentication/sign_in_username";
    }

    //on post request get the username from the form and put it on the current session
    //then return the page containing password field
    @PostMapping("/loginUsername")
    public String login(@ModelAttribute User user, HttpServletRequest httpSession) throws UsernameNotFoundException {

        //find user from the database using the username supplied by the user
        User foundUser = userService.loadByUsername(user.getUsUsername());

        //if username was not found, throw a username not found exception
        if (foundUser == null) {
            //to do:- create an @Exception handler to throw the exception and
            //return the user to the error page
            throw new UsernameNotFoundException("The user was not found");
        }

        HttpSession session = httpSession.getSession();
        session.setAttribute("dbPassword", foundUser.getUsPassword());
        session.setAttribute("userName", user.getUsUsername());
        session.setAttribute("userEmail", foundUser.getUsEmail());

        System.out.println("User passed db password: "+ foundUser.getUsPassword());

        return "fragments/CMS/authentication/sign_in_password";
    }

    //on the login form when the post request is made
    @PostMapping(value = "/loginPassword")
    public String loginPassword(@ModelAttribute User user, HttpSession session, Model model) {

        //select password for this username from the database
        String correctPassword = (String) session.getAttribute("dbPassword");
        //hash login passed from the view to get the same hash
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        System.out.println("Password from database is: "+correctPassword);
        boolean result = bCryptPasswordEncoder.matches(user.getUsPassword(), correctPassword);

        //check if the password supplied is equal to the password from the db.
        //if equals method returns true, direct the user on the index page
        //if equals method returns false, return user to username field to supply correct details.
       // System.out.println("Check results for password comparison: "+correctPassword.equals(userPassedPassword));
        if (result == true){
            System.out.println("Password is correct");
            return "fragments/CMS/authentication/forgot_password.html";
        }

        model.addAttribute("error", "Username and password don't match");
            System.out.println("The password is  not correct..");
            return "fragments/CMS/authentication/sign_in_username";

    }
//get the forget password page
    @GetMapping("/forgot-password")
    public String passwordReset(@ModelAttribute("user") User user) {
        return "fragments/CMS/authentication/forgot_password";
    }
//user inputs email and a link is sent with user token appended at the end
    @PostMapping("/forgot-password")
    public String sendResetLink(@ModelAttribute("user") User user, Model model){

        User dbUser = userService.findByEmail(user.getUsEmail());
        if (dbUser != null ) {
            model.addAttribute("success","Check your email for the password reset link");
            tokenService.createToken(dbUser);
            return "fragments/CMS/authentication/sign_in_username";
        }

        return "error";

    }

    @GetMapping("/confirm-reset")
    public String resetPassword(Model model,@ModelAttribute("user") User user,
                                @RequestParam("token") String confirmationToken) {
        ConfirmationToken token = confirmationTokenReposiroty.findConfirmationTokenByConfirmationToken(confirmationToken);

        //get user from token table and fetch email to update password
        if (token == null) {
            System.out.println("User was not found....");

            model.addAttribute("message", "Something went wrong!");
            return "The link is broken";
        }
            return "fragments/CMS/authentication/new_password";

        }

        @PostMapping("/update-password")
        public String updatePassword(@ModelAttribute("user") User user, HttpSession httpSession){
        String email = (String) httpSession.getAttribute("userEmail");
        userService.updatePassword(user.getUsPassword(),email );
        return "fragments/CMS/authentication/sign_in_username";
        }

    }


