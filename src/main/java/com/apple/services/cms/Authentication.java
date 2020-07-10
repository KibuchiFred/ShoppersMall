//package com.apple.services.cms;
//
//import com.apple.models.cms.User;
//import com.apple.repositories.cms.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//
//@Service
//public class Authentication implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userRepository.findByUsUsername(s);
//
//        if(user == null){
//            throw new UsernameNotFoundException("Username not found "+s);
//           }
////        else {
////
////            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
////        }
//        return new org.springframework.security.core.userdetails.User(user.getUsUsername(),
//                user.getUsPassword(), new HashSet<GrantedAuthority>());
//    }
//}
//
