package com.example.demo_tss.service;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to) throws MailException, MessagingException {
        String from = "forjob.leconghieu@gmail.com";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("V-league Ticket Order");
        helper.setFrom(from);
        helper.setTo(to);

        boolean html = true;
        helper.setText("<b>Dear " + to + "</b>,<br>Thank you for choosing V-league Ticket.<br>We hope you enjoy your football match!.<br>Here is your QR Code Ticket.<br>Please save it in your phone or show it when you are checking in.<br>Thank you and Best regard.", html);
        javaMailSender.send(mimeMessage);
    }
}
