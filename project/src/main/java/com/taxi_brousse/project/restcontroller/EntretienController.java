package com.taxi_brousse.project.restcontroller;

import com.taxi_brousse.project.entity.Entretien;
import com.taxi_brousse.project.services.EntretienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/entretiens")
public class EntretienController {
    @Autowired
    private EntretienService entretienService;

    @GetMapping
    public ResponseEntity<List<Entretien>> getAllEntretiens() {
        List<Entretien> entretiens = entretienService.getAllEntretiens();
        return ResponseEntity.ok(entretiens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entretien> getEntretienById(@PathVariable Integer id) {
        Optional<Entretien> entretien = entretienService.getEntretienById(id);
        return entretien.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Entretien> createEntretien(@RequestBody Entretien entretien) {
        Entretien createdEntretien = entretienService.createEntretien(entretien);
        return ResponseEntity.ok(createdEntretien);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entretien> updateEntretien(@PathVariable Integer id, @RequestBody Entretien entretien) {
        Entretien updatedEntretien = entretienService.updateEntretien(id, entretien);
        if (updatedEntretien != null) {
            return ResponseEntity.ok(updatedEntretien);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntretien(@PathVariable Integer id) {
        entretienService.deleteEntretien(id);
        return ResponseEntity.noContent().build();
    }
}
