package org.example.inchiriazausor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String showIndexPage() {
        return "home"; // Returnează numele fișierului HTML fără extensie
    }
    
}
