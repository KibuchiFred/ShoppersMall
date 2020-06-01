package com.apple.services.cms;

import com.apple.models.cms.User;
import com.apple.repositories.cms.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        user.setRoles(user.getRoles());
       // user.setCreated_by(user.getId());
        user.setUuid((UUID.randomUUID().toString()));
        user.setUs_enabled("N");
        userRepository.save(user);

    }

//    public User findByEmail(String email){
//      //  User user = userRepository.findByUs_email(email);
//        return user;
//
//    }
}
