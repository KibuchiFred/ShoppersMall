package com.apple.ErrorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Was Not Found")
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        throw new UsernameNotFoundException("The user was not found");

    }
}
