package com.apple.repositories.cms;

import com.apple.models.cms.Role;
import com.apple.models.cms.User;
import com.apple.models.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
     Optional<User> findByUsUsername(String username);
     Optional<User> findByUsEmail(String email);

     @Modifying
     @Query("update User u set u.usPassword =?1 where u.usEmail =?2")
     void updatePassword(String password, String userEmail);

     //@Query("SELECT m FROM User u join u.shopRoleMap m where u.usEmail= :email")
     //@Query("SELECT key(u.shopRoleMap), value(u.shopRoleMap)  FROM User u join u.shopRoleMap where u.usEmail = :email")
//     @Query("SELECT m FROM User u join u.shopRoleMap m" +
//             " where u.usEmail = :email")
//     List<Map<Shop,Role>> findByUserEmail(String email);

     //HQL at least gave something sensible
//     @Query("SELECT new map(key(m), value(m) ) from User u join u.shopRoleMap m where u.usEmail = :email")
//     List<Map<Shop,Role>> findByUserEmail(String email);

//     @Query("SELECT key(m), value(m) FROM User u join u.shopRoleMap m" +
//             " where u.usEmail = :email")
//     List<Object[]> findShopAndRoleByUserEmail(String email);
}
