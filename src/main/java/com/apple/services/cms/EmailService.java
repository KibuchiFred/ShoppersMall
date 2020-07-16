package com.apple.services.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Async
    public  void sendEmail(String email, String token){
        //compose email sending
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Password Reset Request");
        mailMessage.setText("To complete password reset process, click this link: "
                +"http://localhost:8080/confirm-reset?token="+token);

        //send the email here
        javaMailSender.send(mailMessage);
    }
}
