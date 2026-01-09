package com.taxi_brousse.project.restcontroller;

import com.taxi_brousse.project.entity.Caisse;
import com.taxi_brousse.project.services.CaisseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/caisses")
public class CaisseController {
    @Autowired
    private CaisseService caisseService;

    @GetMapping
    public ResponseEntity<List<Caisse>> getAllCaisses() {
        List<Caisse> caisses = caisseService.getAllCaisses();
        return ResponseEntity.ok(caisses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caisse> getCaisseById(@PathVariable Integer id) {
        Optional<Caisse> caisse = caisseService.getCaisseById(id);
        return caisse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Caisse> createCaisse(@RequestBody Caisse caisse) {
        Caisse createdCaisse = caisseService.createCaisse(caisse);
        return ResponseEntity.ok(createdCaisse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Caisse> updateCaisse(@PathVariable Integer id, @RequestBody Caisse caisse) {
        Caisse updatedCaisse = caisseService.updateCaisse(id, caisse);
        if (updatedCaisse != null) {
            return ResponseEntity.ok(updatedCaisse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCaisse(@PathVariable Integer id) {
        caisseService.deleteCaisse(id);
        return ResponseEntity.noContent().build();
    }
}
