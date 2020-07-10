package com.apple.services.login;

import com.apple.models.cms.User;
import com.apple.repositories.cms.UserRepository;
import com.apple.services.cms.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserService userService;

    public boolean userCredsCorrect(){
        return false;
    }
}
