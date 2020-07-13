package com.apple.services.cms;

import com.apple.models.cms.User;
import com.apple.repositories.cms.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(isolation=Isolation.SERIALIZABLE)
    public void saveUser(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setUsPassword( bCryptPasswordEncoder.encode(user.getUsPassword()));
        user.setId(0);
        user.setUuid((UUID.randomUUID().toString()));
        user.setUsEnabled("N");
        user.setCreatedBy(user.getUuid());
        userRepository.save(user);
    }

    //this method finds a user by username from the database.
    public User loadByUsername(String username){
        User user = userRepository.findByUsUsername(username);
        if (user == null)
            System.out.print("The username was not found");

        return user;
    }

    public User findByEmail(String usEmail) {
        return userRepository.findByUsEmail(usEmail);
    }
}
