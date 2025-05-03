package org.example.inchiriazausor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class Auth {
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Returnează numele fișierului HTML fără extensie
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Returnează numele fișierului HTML fără extensie
    }   
}
