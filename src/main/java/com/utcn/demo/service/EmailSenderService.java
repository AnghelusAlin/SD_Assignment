package com.utcn.demo.service;

import com.utcn.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendBannedEmail(User user) {
        String toEmail = user.getEmail();
        String body = "You have been banned!";
        String subject = "You have been banned!";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("anghelusalin02@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Mail Send...");

    }

}
