package com.scm.eis.util;

import com.scm.eis.config.JavaMailProvider;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import java.nio.charset.StandardCharsets;
import java.util.Map;
@Component
public class EmailSenderUtil {

    @Autowired
    private JavaMailProvider javaMailProvider;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Value("${spring.mail.username}")
    private String senderEmailId;

    public void sendEmail(String emailId, Map<String, Object> model,String template, String subject) {
        try {
            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            javaMailProvider.configureMailSender(javaMailSender);
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            Context context = new Context();
            context.setVariables(model);
            String html = springTemplateEngine.process(template, context);
            mimeMessageHelper.setTo(emailId.split(","));
            mimeMessageHelper.setFrom(senderEmailId);
            mimeMessageHelper.setFrom(senderEmailId, "Smart-CM-EIS");
            mimeMessageHelper.setText(html, true);
            mimeMessageHelper.setSubject(subject);
            javaMailSender.send(mimeMessage);
        } catch (Exception exception) {
            throw new RuntimeException("Email Not Sent ");
        }
    }
}
