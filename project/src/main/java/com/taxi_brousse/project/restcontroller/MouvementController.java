package com.taxi_brousse.project.restcontroller;

import com.taxi_brousse.project.entity.Mouvement;
import com.taxi_brousse.project.services.MouvementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mouvements")
public class MouvementController {
    @Autowired
    private MouvementService mouvementService;

    @GetMapping
    public ResponseEntity<List<Mouvement>> getAllMouvements() {
        List<Mouvement> mouvements = mouvementService.getAllMouvements();
        return ResponseEntity.ok(mouvements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mouvement> getMouvementById(@PathVariable Integer id) {
        Optional<Mouvement> mouvement = mouvementService.getMouvementById(id);
        return mouvement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mouvement> createMouvement(@RequestBody Mouvement mouvement) {
        Mouvement createdMouvement = mouvementService.createMouvement(mouvement);
        return ResponseEntity.ok(createdMouvement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mouvement> updateMouvement(@PathVariable Integer id, @RequestBody Mouvement mouvement) {
        Mouvement updatedMouvement = mouvementService.updateMouvement(id, mouvement);
        if (updatedMouvement != null) {
            return ResponseEntity.ok(updatedMouvement);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMouvement(@PathVariable Integer id) {
        mouvementService.deleteMouvement(id);
        return ResponseEntity.noContent().build();
    }
}
