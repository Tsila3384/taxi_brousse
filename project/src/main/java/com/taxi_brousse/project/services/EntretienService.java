package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Entretien;
import com.taxi_brousse.project.repository.EntretienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EntretienService {
    @Autowired
    private EntretienRepository entretienRepository;

    public List<Entretien> getAllEntretiens() {
        return entretienRepository.findAll();
    }

    public Optional<Entretien> getEntretienById(Integer id) {
        return entretienRepository.findById(id);
    }

    public Entretien createEntretien(Entretien entretien) {
        return entretienRepository.save(entretien);
    }

    public Entretien updateEntretien(Integer id, Entretien entretien) {
        if (entretienRepository.existsById(id)) {
            entretien.setIdEntretien(id);
            return entretienRepository.save(entretien);
        }
        return null;
    }

    public void deleteEntretien(Integer id) {
        entretienRepository.deleteById(id);
    }
}
