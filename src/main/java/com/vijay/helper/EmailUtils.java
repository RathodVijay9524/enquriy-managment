package com.vijay.helper;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Configuration
public class EmailUtils {

    @Autowired
    private JavaMailSender mailSender;

    public boolean sendEmail(String to, String subject, String body){
       boolean isSent = false;
        try{
            MimeMessage mimeMessage=mailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            mailSender.send(mimeMessage);
            isSent=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSent;

    }
}