package com.apple.repositories.cms;

import com.apple.models.cms.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
     User findByUsUsername(String username);
     User findByUsEmail(String email);

     @Modifying
     @Query("update User u set u.usPassword =?1 where u.usUsername =?2")
     void updatePassword(String password, String username);

}
