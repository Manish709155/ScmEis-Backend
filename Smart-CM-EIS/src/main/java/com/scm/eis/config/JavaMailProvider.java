package com.scm.eis.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class JavaMailProvider {


    @Value("${spring.mail.username}")
    private String emailId;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private int port;

    public void configureMailSender(JavaMailSenderImpl mailSender) {
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(emailId);
        mailSender.setPassword(password);
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.enable", "true");
    }
}
