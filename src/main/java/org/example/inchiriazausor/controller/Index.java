package org.example.inchiriazausor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/hello")
public class Index {
    @GetMapping("/salut")
    public String showIndexPage() {
        return "index"; // Returnează numele fișierului HTML fără extensie
    }
}
