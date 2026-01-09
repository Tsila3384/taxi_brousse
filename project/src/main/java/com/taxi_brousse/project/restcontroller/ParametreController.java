package com.taxi_brousse.project.restcontroller;

import com.taxi_brousse.project.entity.Parametre;
import com.taxi_brousse.project.services.ParametreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parametres")
public class ParametreController {
    @Autowired
    private ParametreService parametreService;

    @GetMapping
    public ResponseEntity<List<Parametre>> getAllParametres() {
        List<Parametre> parametres = parametreService.getAllParametres();
        return ResponseEntity.ok(parametres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parametre> getParametreById(@PathVariable Integer id) {
        Optional<Parametre> parametre = parametreService.getParametreById(id);
        return parametre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Parametre> createParametre(@RequestBody Parametre parametre) {
        Parametre createdParametre = parametreService.createParametre(parametre);
        return ResponseEntity.ok(createdParametre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parametre> updateParametre(@PathVariable Integer id, @RequestBody Parametre parametre) {
        Parametre updatedParametre = parametreService.updateParametre(id, parametre);
        if (updatedParametre != null) {
            return ResponseEntity.ok(updatedParametre);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParametre(@PathVariable Integer id) {
        parametreService.deleteParametre(id);
        return ResponseEntity.noContent().build();
    }
}
