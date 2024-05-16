package com.task.remindme.service;

import com.task.remindme.entity.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    public  void sendEmail(EmailRequest emailRequest){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(emailRequest.getEmailTo());
        msg.setSubject(emailRequest.getSubject());
        msg.setText(emailRequest.getMessage());
        javaMailSender.send(msg);
    }
}
