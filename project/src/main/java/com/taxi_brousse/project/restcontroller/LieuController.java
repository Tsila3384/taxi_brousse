package com.taxi_brousse.project.restcontroller;

import com.taxi_brousse.project.entity.Lieu;
import com.taxi_brousse.project.services.LieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lieux")
public class LieuController {
    @Autowired
    private LieuService lieuService;

    @GetMapping
    public ResponseEntity<List<Lieu>> getAllLieux() {
        List<Lieu> lieux = lieuService.getAllLieux();
        return ResponseEntity.ok(lieux);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lieu> getLieuById(@PathVariable Integer id) {
        Optional<Lieu> lieu = lieuService.getLieuById(id);
        return lieu.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Lieu> createLieu(@RequestBody Lieu lieu) {
        Lieu createdLieu = lieuService.createLieu(lieu);
        return ResponseEntity.ok(createdLieu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lieu> updateLieu(@PathVariable Integer id, @RequestBody Lieu lieu) {
        Lieu updatedLieu = lieuService.updateLieu(id, lieu);
        if (updatedLieu != null) {
            return ResponseEntity.ok(updatedLieu);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLieu(@PathVariable Integer id) {
        lieuService.deleteLieu(id);
        return ResponseEntity.noContent().build();
    }
}
