package com.apple.services.cms;

import com.apple.models.cms.Role;
import com.apple.models.cms.User;
import com.apple.models.shop.Shop;
import com.apple.repositories.cms.UserRepository;
import com.apple.services.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShopService shopService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public String passwordEncoder(String password){
       return  bCryptPasswordEncoder.encode(password);
    }

    @Transactional(isolation=Isolation.SERIALIZABLE)
    public void saveUser(User user) {


        user.setUsPassword(passwordEncoder(user.getUsPassword()));
        user.setId(0);
        user.setUuid((UUID.randomUUID().toString()));
        user.setUsEnabled("N");
        user.setCreatedBy(user.getUuid());
        userRepository.save(user);
    }

    //this method finds a user by username from the database.
    public User loadByUsername(String username){
        Optional<User> user = userRepository.findByUsUsername(username);
        if (user == null)
            System.out.print("The username was not found");

        return user.get();
    }
    //A method check if passwords match.
    public boolean passwordMatcher(String passOne, String passTwo){
        return bCryptPasswordEncoder.matches(passOne, passTwo);
    }

    @Transactional
    public User findByEmail(String usEmail) {
        Optional<User> user = userRepository.findByUsEmail(usEmail);
        if (user == null)
            System.out.print("User with that email does not exist"+ usEmail);

        return user.get();
    }

    @Transactional
    public void updatePassword(String password, String email){

        userRepository.updatePassword(passwordEncoder(password),email);
    }

//    @Transactional
//    public List<Object[]> findShopAndRoleByUserEmail(String email){
//        return userRepository.findShopAndRoleByUserEmail(email);
//    }

    @Transactional
    public Map<Shop, Role> getMyShops(String email){
        return userRepository.findByUsEmail(email)
                .map(User::getShopRoleMap)
                .orElse(new HashMap<>());
    }
    }
