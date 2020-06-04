package com.apple.repositories.cms;

import com.apple.models.cms.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
    //User findByUs_email(String email);

}
