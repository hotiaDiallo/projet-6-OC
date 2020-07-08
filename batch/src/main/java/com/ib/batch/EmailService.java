package com.ib.batch;

import org.springframework.mail.SimpleMailMessage;

public class EmailService extends MailSenderConfiguration {
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        getJavaMailSender().send(message);
    }
}
