package com.example.demo_tss.controller;

import com.example.demo_tss.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/mail")
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping( "/{username}")
    public ResponseEntity<String> sendEmail(@PathVariable String username) {
        try {
            emailService.sendEmail(username);
            return new ResponseEntity<>("Sending successful", HttpStatus.OK);
        } catch (MailException | MessagingException e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("Can not send email", HttpStatus.BAD_REQUEST);
    }
}
