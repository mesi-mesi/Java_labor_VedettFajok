package org.example.demo.controller;
import org.example.demo.entity.Allat;
import org.example.demo.repository.AllatRepo;
import org.example.demo.repository.ErtekRepo;
import org.example.demo.repository.KategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class Vezerlo {
    @Autowired private AllatRepo allatRepo;     // Dependency injection
    @Autowired private KategoriaRepo kategoriaRepo;
    @Autowired private ErtekRepo ertekRepo;
    @GetMapping("/adatbazis")
    public String adatbazis(Model model) {
        model.addAttribute("allatok", allatRepo.findAllByOrderByNev());
        return "adatbazis";
    }
    @GetMapping("/diagram")
    public String diagram(Model model) {
        model.addAttribute("sorok", kategoriaRepo.fajokKategoriankent());
        return "diagram";
    }
    // CRUD – Read: a fajok listája
    @GetMapping("/crud")
    public String crud(Model model) {
        model.addAttribute("allatok", allatRepo.findAllByOrderByNev());
        return "crud";
    }
    // CRUD – Create: az új faj űrlapjának megnyitása
    @GetMapping("/crud/uj")
    public String ujAllatOldal(Model model) {
        model.addAttribute("allat", new Allat());
        model.addAttribute("kategoriak", kategoriaRepo.findAll());
        model.addAttribute("ertekek", ertekRepo.findAll());
        return "ujallat";
    }
    // CRUD – Create: mentés az adatbázisba
    @PostMapping("/crud/ment")
    public String mentAllat(@ModelAttribute Allat allat) {
        allatRepo.save(allat);
        return "redirect:/crud";
    }
}
