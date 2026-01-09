package com.taxi_brousse.project.restcontroller;

import com.taxi_brousse.project.entity.Statut;
import com.taxi_brousse.project.services.StatutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/statuts")
public class StatutController {
    @Autowired
    private StatutService statutService;

    @GetMapping
    public ResponseEntity<List<Statut>> getAllStatuts() {
        List<Statut> statuts = statutService.getAllStatuts();
        return ResponseEntity.ok(statuts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statut> getStatutById(@PathVariable Integer id) {
        Optional<Statut> statut = statutService.getStatutById(id);
        return statut.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Statut> createStatut(@RequestBody Statut statut) {
        Statut createdStatut = statutService.createStatut(statut);
        return ResponseEntity.ok(createdStatut);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Statut> updateStatut(@PathVariable Integer id, @RequestBody Statut statut) {
        Statut updatedStatut = statutService.updateStatut(id, statut);
        if (updatedStatut != null) {
            return ResponseEntity.ok(updatedStatut);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatut(@PathVariable Integer id) {
        statutService.deleteStatut(id);
        return ResponseEntity.noContent().build();
    }
}
