package org.example.demo.controller;
import org.example.demo.repository.AllatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Vezerlo {
    @Autowired private AllatRepo allatRepo;     // Dependency injection
    @GetMapping("/adatbazis")
    public String adatbazis(Model model) {
        model.addAttribute("allatok", allatRepo.findAllByOrderByNev());
        return "adatbazis";
    }
}
