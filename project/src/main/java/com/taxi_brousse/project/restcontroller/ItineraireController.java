package com.taxi_brousse.project.restcontroller;

import com.taxi_brousse.project.entity.Itineraire;
import com.taxi_brousse.project.services.ItineraireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/itineraires")
public class ItineraireController {
    @Autowired
    private ItineraireService itineraireService;

    @GetMapping
    public ResponseEntity<List<Itineraire>> getAllItineraires() {
        List<Itineraire> itineraires = itineraireService.getAllItineraires();
        return ResponseEntity.ok(itineraires);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Itineraire> getItineraireById(@PathVariable Integer id) {
        Optional<Itineraire> itineraire = itineraireService.getItineraireById(id);
        return itineraire.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Itineraire> createItineraire(@RequestBody Itineraire itineraire) {
        Itineraire createdItineraire = itineraireService.createItineraire(itineraire);
        return ResponseEntity.ok(createdItineraire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Itineraire> updateItineraire(@PathVariable Integer id, @RequestBody Itineraire itineraire) {
        Itineraire updatedItineraire = itineraireService.updateItineraire(id, itineraire);
        if (updatedItineraire != null) {
            return ResponseEntity.ok(updatedItineraire);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItineraire(@PathVariable Integer id) {
        itineraireService.deleteItineraire(id);
        return ResponseEntity.noContent().build();
    }
}
