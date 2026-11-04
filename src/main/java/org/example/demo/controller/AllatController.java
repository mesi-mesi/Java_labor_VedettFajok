package org.example.demo.controller;
import org.example.demo.entity.Allat;
import org.example.demo.repository.AllatRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
class AllatController {
    private final AllatRepo repo;
    AllatController(AllatRepo repo) {     // Dependency injection kontrollerrel
        this.repo = repo;
    }
    // REST – az összes faj lekérdezése
    @GetMapping("/api/allatok")
    Iterable<Allat> olvasMind() {
        return repo.findAll();
    }
    // REST – egy faj lekérdezése ID alapján
    @GetMapping("/api/allatok/{id}")
    Allat olvasEgy(@PathVariable int id) {
        return repo.findById(id)
                .orElseThrow(() -> new AllatNotFoundException(id));
    }
    // REST – új faj felvétele
    @PostMapping("/api/allatok")
    Allat allatFeltolt(@RequestBody Allat ujAllat) {
        return repo.save(ujAllat);
    }
}
