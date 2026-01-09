package com.taxi_brousse.project.restcontroller;

import com.taxi_brousse.project.entity.TypeMouvement;
import com.taxi_brousse.project.services.TypeMouvementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/type-mouvements")
public class TypeMouvementController {
    @Autowired
    private TypeMouvementService typeMouvementService;

    @GetMapping
    public ResponseEntity<List<TypeMouvement>> getAllTypeMouvements() {
        List<TypeMouvement> typeMouvements = typeMouvementService.getAllTypeMouvements();
        return ResponseEntity.ok(typeMouvements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeMouvement> getTypeMouvementById(@PathVariable Integer id) {
        Optional<TypeMouvement> typeMouvement = typeMouvementService.getTypeMouvementById(id);
        return typeMouvement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TypeMouvement> createTypeMouvement(@RequestBody TypeMouvement typeMouvement) {
        TypeMouvement createdTypeMouvement = typeMouvementService.createTypeMouvement(typeMouvement);
        return ResponseEntity.ok(createdTypeMouvement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeMouvement> updateTypeMouvement(@PathVariable Integer id,
            @RequestBody TypeMouvement typeMouvement) {
        TypeMouvement updatedTypeMouvement = typeMouvementService.updateTypeMouvement(id, typeMouvement);
        if (updatedTypeMouvement != null) {
            return ResponseEntity.ok(updatedTypeMouvement);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeMouvement(@PathVariable Integer id) {
        typeMouvementService.deleteTypeMouvement(id);
        return ResponseEntity.noContent().build();
    }
}
