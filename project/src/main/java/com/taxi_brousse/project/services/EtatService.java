package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Etat;
import com.taxi_brousse.project.repository.EtatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EtatService {
    @Autowired
    private EtatRepository etatRepository;

    public List<Etat> getAllEtats() {
        return etatRepository.findAll();
    }

    public Optional<Etat> getEtatById(Integer id) {
        return etatRepository.findById(id);
    }

    public Etat createEtat(Etat etat) {
        return etatRepository.save(etat);
    }

    public Etat updateEtat(Integer id, Etat etat) {
        if (etatRepository.existsById(id)) {
            etat.setIdEtat(id);
            return etatRepository.save(etat);
        }
        return null;
    }

    public void deleteEtat(Integer id) {
        etatRepository.deleteById(id);
    }
}
