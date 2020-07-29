package com.apple.repositories.cms;

import com.apple.models.cms.Role;
import com.apple.models.cms.User;
import com.apple.models.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Map;


@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
     User findByUsUsername(String username);
     User findByUsEmail(String email);

     @Modifying
     @Query("update User u set u.usPassword =?1 where u.usEmail =?2")
     void updatePassword(String password, String userEmail);

     @Query("SELECT m FROM User u join u.shopRoleMap m where u.usEmail= :email")
     public Map<Shop,Role> findbyUserEmail(String email);

}
