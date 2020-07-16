package com.apple.services.cms;

import com.apple.models.cms.ConfirmationToken;
import com.apple.models.cms.User;
import com.apple.repositories.cms.ConfirmationTokenReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private ConfirmationTokenReposiroty confirmationTokenReposiroty;

    JavaMailSender javaMailSender;
    @Autowired
    public TokenService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void createToken (User user){
        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenReposiroty.save(confirmationToken);

        //compose email sending
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getUsEmail());
        mailMessage.setSubject("Password Reset Request");
        mailMessage.setText("To complete password reset process, click this link: "
        +"http://localhost:8080/confirm-reset?token="+confirmationToken.getConfirmationToken());

        //send the email here
        sendEmail(mailMessage);
    }
@Async
    public void sendEmail(SimpleMailMessage simpleMailMessage){
        javaMailSender.send(simpleMailMessage);
}

}
