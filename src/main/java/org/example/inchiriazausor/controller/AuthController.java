package org.example.inchiriazausor.controller;

import org.example.inchiriazausor.model.User;
import org.example.inchiriazausor.repository.UserRepository;
import org.example.inchiriazausor.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.mail.MailException;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService confirmationEmailService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Returnează numele fișierului HTML fără extensie
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Returnează numele fișierului HTML fără extensie
    }   

    @Transactional
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) 
        throws Exception
    {
        logger.info("Cerere de inregistrare pentru utilizatorul: " + username);
    
        if (userRepository.findByEmail(email) != null) {
            logger.warn("Exista un utilizator cu acest email: " + email);
            return "redirect:/auth/register?error=exists";
        }
    
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password); 
        
    
        String content =
        """
            <p> Te-ai inregistrat cu succes pe inchiriazausor.site</p>
        """;

        userRepository.save(newUser);
        
        try{
            confirmationEmailService.sendConfirmationEmail(email, "Confirmare inregistrare", content);
        } catch (MailException e) {
            logger.error("Eroare la trimiterea emailului de confirmare: " + e.getMessage());
            throw new Exception("Eroare la trimiterea emailului de confirmare");
        }

        return "redirect:/register?success=true";
    }
}
