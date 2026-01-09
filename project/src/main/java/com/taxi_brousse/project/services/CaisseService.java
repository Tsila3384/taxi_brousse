package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Caisse;
import com.taxi_brousse.project.repository.CaisseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CaisseService {
    @Autowired
    private CaisseRepository caisseRepository;

    public List<Caisse> getAllCaisses() {
        return caisseRepository.findAll();
    }

    public Optional<Caisse> getCaisseById(Integer id) {
        return caisseRepository.findById(id);
    }

    public Caisse createCaisse(Caisse caisse) {
        return caisseRepository.save(caisse);
    }

    public Caisse updateCaisse(Integer id, Caisse caisse) {
        if (caisseRepository.existsById(id)) {
            caisse.setIdCaisse(id);
            return caisseRepository.save(caisse);
        }
        return null;
    }

    public void deleteCaisse(Integer id) {
        caisseRepository.deleteById(id);
    }
}
