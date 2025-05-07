package org.example.inchiriazausor.controller;

import org.example.inchiriazausor.model.Terms;
import org.example.inchiriazausor.repository.TermsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TermsController {

    private final TermsRepository termsRepository;

    public TermsController(TermsRepository termsRepository) {
        this.termsRepository = termsRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/terms")
    public String showTerms(Model model) {
        List<Terms> termsList = termsRepository.findAll();
        // Assuming you have only one set of terms, you can retrieve the first one.
        if (!termsList.isEmpty()) {
            model.addAttribute("terms", termsList.get(0).getContent());
        } else {
            model.addAttribute("terms", "No terms and conditions available.");
        }
        return "terms";
    }

    @GetMapping("/admin/add-terms")
    public String showAddTermsForm() {
        return "add-terms";
    }

    @PostMapping("/admin/save-terms")
    public String saveTerms(@RequestParam("content") String content) {
        termsRepository.deleteAll(); // Clear existing terms (for simplicity)
        Terms terms = new Terms();
        terms.setContent(content);
        termsRepository.save(terms);
        return "redirect:/terms";
    }
}