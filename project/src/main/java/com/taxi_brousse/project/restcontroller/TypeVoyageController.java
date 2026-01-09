package com.taxi_brousse.project.restcontroller;

import com.taxi_brousse.project.entity.TypeVoyage;
import com.taxi_brousse.project.services.TypeVoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/type-voyages")
public class TypeVoyageController {
    @Autowired
    private TypeVoyageService typeVoyageService;

    @GetMapping
    public ResponseEntity<List<TypeVoyage>> getAllTypeVoyages() {
        List<TypeVoyage> typeVoyages = typeVoyageService.getAllTypeVoyages();
        return ResponseEntity.ok(typeVoyages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeVoyage> getTypeVoyageById(@PathVariable Integer id) {
        Optional<TypeVoyage> typeVoyage = typeVoyageService.getTypeVoyageById(id);
        return typeVoyage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TypeVoyage> createTypeVoyage(@RequestBody TypeVoyage typeVoyage) {
        TypeVoyage createdTypeVoyage = typeVoyageService.createTypeVoyage(typeVoyage);
        return ResponseEntity.ok(createdTypeVoyage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeVoyage> updateTypeVoyage(@PathVariable Integer id, @RequestBody TypeVoyage typeVoyage) {
        TypeVoyage updatedTypeVoyage = typeVoyageService.updateTypeVoyage(id, typeVoyage);
        if (updatedTypeVoyage != null) {
            return ResponseEntity.ok(updatedTypeVoyage);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeVoyage(@PathVariable Integer id) {
        typeVoyageService.deleteTypeVoyage(id);
        return ResponseEntity.noContent().build();
    }
}
