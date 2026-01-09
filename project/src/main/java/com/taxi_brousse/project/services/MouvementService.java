package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Mouvement;
import com.taxi_brousse.project.repository.MouvementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MouvementService {
    @Autowired
    private MouvementRepository mouvementRepository;

    public List<Mouvement> getAllMouvements() {
        return mouvementRepository.findAll();
    }

    public Optional<Mouvement> getMouvementById(Integer id) {
        return mouvementRepository.findById(id);
    }

    public Mouvement createMouvement(Mouvement mouvement) {
        return mouvementRepository.save(mouvement);
    }

    public Mouvement updateMouvement(Integer id, Mouvement mouvement) {
        if (mouvementRepository.existsById(id)) {
            mouvement.setIdMouvement(id);
            return mouvementRepository.save(mouvement);
        }
        return null;
    }

    public void deleteMouvement(Integer id) {
        mouvementRepository.deleteById(id);
    }
}
