package org.example.inchiriazausor.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Configuration

@Controller 
@RequestMapping("/")
public class Index {
    @GetMapping
    public String showIndexPage() {
        return "index"; // Returnează numele fișierului HTML fără extensie
    }


}
