package org.example.demo.controller;

import org.example.demo.repository.AllatRepo;
import org.example.demo.repository.KategoriaRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller1 {

    private final KategoriaRepo kategoriaRepo;
    private final AllatRepo allatRepo;

    public Controller1(KategoriaRepo kategoriaRepo, AllatRepo allatRepo) {
        this.kategoriaRepo = kategoriaRepo;
        this.allatRepo = allatRepo;
    }

    // Főoldal: a kategóriák csempéi a fajok számával, és az összes faj száma
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("kategoriak", kategoriaRepo.kategoriakFajszammal());
        model.addAttribute("fajokSzama", allatRepo.count());
        return "home";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}