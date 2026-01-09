package com.taxi_brousse.project.restcontroller;

import com.taxi_brousse.project.entity.Etat;
import com.taxi_brousse.project.services.EtatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etats")
public class EtatController {
    @Autowired
    private EtatService etatService;

    @GetMapping
    public ResponseEntity<List<Etat>> getAllEtats() {
        List<Etat> etats = etatService.getAllEtats();
        return ResponseEntity.ok(etats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etat> getEtatById(@PathVariable Integer id) {
        Optional<Etat> etat = etatService.getEtatById(id);
        return etat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Etat> createEtat(@RequestBody Etat etat) {
        Etat createdEtat = etatService.createEtat(etat);
        return ResponseEntity.ok(createdEtat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etat> updateEtat(@PathVariable Integer id, @RequestBody Etat etat) {
        Etat updatedEtat = etatService.updateEtat(id, etat);
        if (updatedEtat != null) {
            return ResponseEntity.ok(updatedEtat);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtat(@PathVariable Integer id) {
        etatService.deleteEtat(id);
        return ResponseEntity.noContent().build();
    }
}
