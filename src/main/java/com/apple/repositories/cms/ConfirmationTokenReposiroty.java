package com.apple.repositories.cms;

import com.apple.models.cms.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenReposiroty extends JpaRepository<ConfirmationToken, Long> {

    ConfirmationToken findConfirmationTokenByConfirmationToken(String confirmationToken);
}
