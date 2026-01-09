package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Statut;
import com.taxi_brousse.project.repository.StatutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StatutService {
    @Autowired
    private StatutRepository statutRepository;

    public List<Statut> getAllStatuts() {
        return statutRepository.findAll();
    }

    public Optional<Statut> getStatutById(Integer id) {
        return statutRepository.findById(id);
    }

    public Statut createStatut(Statut statut) {
        return statutRepository.save(statut);
    }

    public Statut updateStatut(Integer id, Statut statut) {
        if (statutRepository.existsById(id)) {
            statut.setIdStatut(id);
            return statutRepository.save(statut);
        }
        return null;
    }

    public void deleteStatut(Integer id) {
        statutRepository.deleteById(id);
    }
}
