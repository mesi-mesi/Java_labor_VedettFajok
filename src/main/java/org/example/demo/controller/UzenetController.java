package org.example.demo.controller;

import jakarta.validation.Valid;
import org.example.demo.entity.Uzenet;
import org.example.demo.repository.UzenetRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDateTime;

@Controller
public class UzenetController {

    private final UzenetRepo uzenetRepo;

    public UzenetController(UzenetRepo uzenetRepo) {
        this.uzenetRepo = uzenetRepo;
    }

    // Kapcsolat űrlap megjelenítése
    @GetMapping("/kapcsolat")
    public String kapcsolat(Model model) {
        model.addAttribute("uzenet", new Uzenet());
        return "kapcsolat";
    }

    // Űrlap feldolgozása: validáció, majd mentés
    @PostMapping("/kapcsolat")
    public String kuldes(@Valid @ModelAttribute("uzenet") Uzenet uzenet,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "kapcsolat";               // hibák esetén vissza az űrlapra, a beírt adatokkal
        }
        uzenet.setKuldesIdeje(LocalDateTime.now());
        uzenetRepo.save(uzenet);
        redirectAttributes.addFlashAttribute("siker", "Köszönjük, az üzenetedet elmentettük!");
        return "redirect:/kapcsolat";
    }
    // Üzenetek listája: legfrissebb elöl, csak bejelentkezett felhasználónak
    @GetMapping("/uzenetek")
    public String uzenetek(Model model) {
        model.addAttribute("uzenetek", uzenetRepo.findAllByOrderByKuldesIdejeDesc());
        return "uzenetek";
    }
}