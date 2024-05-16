package com.task.remindme.controller;

import com.task.remindme.entity.EmailRequest;
import com.task.remindme.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    EmailService emailService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        log.info("sending  notification email");
        emailService.sendEmail(emailRequest);
        return "Notification email sent successfully";
    }

}
