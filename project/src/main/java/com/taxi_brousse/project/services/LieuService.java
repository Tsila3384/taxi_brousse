package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Lieu;
import com.taxi_brousse.project.repository.LieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LieuService {
    @Autowired
    private LieuRepository lieuRepository;

    public List<Lieu> getAllLieux() {
        return lieuRepository.findAll();
    }

    public Optional<Lieu> getLieuById(Integer id) {
        return lieuRepository.findById(id);
    }

    public Lieu createLieu(Lieu lieu) {
        return lieuRepository.save(lieu);
    }

    public Lieu updateLieu(Integer id, Lieu lieu) {
        if (lieuRepository.existsById(id)) {
            lieu.setIdLieu(id);
            return lieuRepository.save(lieu);
        }
        return null;
    }

    public void deleteLieu(Integer id) {
        lieuRepository.deleteById(id);
    }
}
