package com.apple.services.cms;

import com.apple.models.cms.User;
import com.apple.repositories.cms.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

        user.setId(0);
        user.setUuid((UUID.randomUUID().toString()));
        user.setUs_enabled("N");
        user.setCreated_by(user.getUuid()); userRepository.save(user);
    }
}
