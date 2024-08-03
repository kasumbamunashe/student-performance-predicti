package com.zw.jimfish.service.jwt;

import com.zw.jimfish.domain.enums.auth.Notification;
import com.zw.jimfish.service.jwt.exceptions.EmailException;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service

@Resource
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

@Async
    public void sendEmail(Notification notification) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("noreply@afrosoft.co.zw");
            message.setTo(notification.getRecipient().getEmail());
            message.setSubject(notification.getSubject());
            message.setText(notification.getContent());
            mailSender.send(message);
        } catch (MailException e) {
            throw new EmailException("Failed to send email.", e);
        }
    }
}
