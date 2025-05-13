package org.example.inchiriazausor.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlaskService {

    public ResponseEntity<String> get(String uri) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:5000/%s".formatted(uri);
    
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return response;
    }

    
    // public ResponseEntity<String> post(String uri) {
    //     RestTemplate restTemplate = new RestTemplate();

    //     String url = "http://localhost:5000/%s".formatted(uri);
    
    //     ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

    //     return response;
    // }
}