package org.example.inchiriazausor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendConfirmationEmail(String toEmail, String subject, String content) 
        throws MailException, MessagingException
    {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
      
        helper.setFrom("confirm-account@inchiriazausor.site"); // Adresa de la care trimiti emailul
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(content, true); // true pentru a trimite emailul în format HTML
        mailSender.send(message);
    }
}
