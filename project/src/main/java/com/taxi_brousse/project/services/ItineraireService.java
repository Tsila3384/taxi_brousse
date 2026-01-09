package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Itineraire;
import com.taxi_brousse.project.repository.ItineraireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItineraireService {
    @Autowired
    private ItineraireRepository itineraireRepository;

    public List<Itineraire> getAllItineraires() {
        return itineraireRepository.findAll();
    }

    public Optional<Itineraire> getItineraireById(Integer id) {
        return itineraireRepository.findById(id);
    }

    public Itineraire createItineraire(Itineraire itineraire) {
        return itineraireRepository.save(itineraire);
    }

    public Itineraire updateItineraire(Integer id, Itineraire itineraire) {
        if (itineraireRepository.existsById(id)) {
            itineraire.setIdItineraire(id);
            return itineraireRepository.save(itineraire);
        }
        return null;
    }

    public void deleteItineraire(Integer id) {
        itineraireRepository.deleteById(id);
    }
}
