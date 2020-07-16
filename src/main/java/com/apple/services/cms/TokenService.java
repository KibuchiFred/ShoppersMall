package com.apple.services.cms;

import com.apple.models.cms.ConfirmationToken;
import com.apple.models.cms.User;
import com.apple.repositories.cms.ConfirmationTokenReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private ConfirmationTokenReposiroty confirmationTokenReposiroty;
    @Autowired
    EmailService emailService;

    public void createToken (User user){
        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenReposiroty.save(confirmationToken);
        emailService.sendEmail(user.getUsEmail(), confirmationToken.getConfirmationToken());
    }

}
