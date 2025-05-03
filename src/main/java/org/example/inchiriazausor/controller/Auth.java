package org.example.inchiriazausor.controller;

import org.example.inchiriazausor.model.User;
import org.example.inchiriazausor.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class Auth {
    private static final Logger logger = LoggerFactory.getLogger(Auth.class);

    @Autowired
    private UserRepository userRepository;

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
    public String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        logger.info("Cerere de inregistrare pentru utilizatorul: " + username);
    
        if (userRepository.findByUsername(username) != null) {
            logger.warn("Utilizatorul " + username + " exista deja.");
            return "redirect:/auth/register?error=exists";
        }
    
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password); 
        
        userRepository.save(newUser);
    
        return "redirect:/auth/register?success=true";
    }
}
