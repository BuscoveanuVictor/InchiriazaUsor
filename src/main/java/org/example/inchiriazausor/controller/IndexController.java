package org.example.inchiriazausor.controller;

import org.example.inchiriazausor.service.FlaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/")
public class IndexController{

    @Autowired
    FlaskService flaskService;

    @GetMapping
    public String showIndexPage() {
        return "index"; // Returnează numele fișierului HTML fără extensie
    }

    @GetMapping("/flask/**")
    public ResponseEntity<String> callFlask() {

        return ResponseEntity.ok("Flask a răspuns: " + flaskService.get("app").getBody());
    }

}
