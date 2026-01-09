package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Voyage;
import com.taxi_brousse.project.repository.VoyageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VoyageService {
    @Autowired
    private VoyageRepository voyageRepository;

    public List<Voyage> getAllVoyages() {
        return voyageRepository.findAll();
    }

    public Optional<Voyage> getVoyageById(Integer id) {
        return voyageRepository.findById(id);
    }

    public Voyage createVoyage(Voyage voyage) {
        return voyageRepository.save(voyage);
    }

    public Voyage updateVoyage(Integer id, Voyage voyage) {
        if (voyageRepository.existsById(id)) {
            voyage.setIdVoyage(id);
            return voyageRepository.save(voyage);
        }
        return null;
    }

    public void deleteVoyage(Integer id) {
        voyageRepository.deleteById(id);
    }
}
