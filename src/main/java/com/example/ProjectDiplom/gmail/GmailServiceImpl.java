package com.example.ProjectDiplom.gmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class GmailServiceImpl implements GmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment environment;


    @Override
    public Boolean send(String toGmail, String subject, String text) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            message.setSubject(subject, "UTF-8");

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true, "UTF-8");
            mimeMessageHelper.setFrom(environment.getProperty("spring.mail.username"));
            mimeMessageHelper.setTo(toGmail);
            mimeMessageHelper.setText(text, true);
            javaMailSender.send(message);
            return true;
        } catch (Exception e) {
            System.out.println("MailService.send: " + e.getMessage());
            return false;
        }
    }
}
