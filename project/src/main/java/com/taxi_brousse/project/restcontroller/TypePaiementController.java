package com.taxi_brousse.project.restcontroller;

import com.taxi_brousse.project.entity.TypePaiement;
import com.taxi_brousse.project.services.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/type-paiements")
public class TypePaiementController {
    @Autowired
    private TypePaiementService typePaiementService;

    @GetMapping
    public ResponseEntity<List<TypePaiement>> getAllTypePaiements() {
        List<TypePaiement> typePaiements = typePaiementService.getAllTypePaiements();
        return ResponseEntity.ok(typePaiements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypePaiement> getTypePaiementById(@PathVariable Integer id) {
        Optional<TypePaiement> typePaiement = typePaiementService.getTypePaiementById(id);
        return typePaiement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TypePaiement> createTypePaiement(@RequestBody TypePaiement typePaiement) {
        TypePaiement createdTypePaiement = typePaiementService.createTypePaiement(typePaiement);
        return ResponseEntity.ok(createdTypePaiement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypePaiement> updateTypePaiement(@PathVariable Integer id,
            @RequestBody TypePaiement typePaiement) {
        TypePaiement updatedTypePaiement = typePaiementService.updateTypePaiement(id, typePaiement);
        if (updatedTypePaiement != null) {
            return ResponseEntity.ok(updatedTypePaiement);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypePaiement(@PathVariable Integer id) {
        typePaiementService.deleteTypePaiement(id);
        return ResponseEntity.noContent().build();
    }
}
