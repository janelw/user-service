package com.user.user.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.user.user.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

// import software.amazon.awssdk.services.ses.*;
// import software.amazon.awssdk.services.ses.model.SendCustomVerificationEmailRequest;
// import software.amazon.awssdk.services.ses.model.SendCustomVerificationEmailResponse;


@Service
public class emailservice {

    





    
    @Autowired
    public JavaMailSender emailSender;

    public String sendSimpleEmail(String toAddress, String subject, String message){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("jgwsoftdev@gmail.com");
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        emailSender.send(simpleMailMessage);

        return "email sent";
    }
}


