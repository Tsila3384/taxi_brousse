package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.Parametre;
import com.taxi_brousse.project.repository.ParametreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ParametreService {
    @Autowired
    private ParametreRepository parametreRepository;

    public List<Parametre> getAllParametres() {
        return parametreRepository.findAll();
    }

    public Optional<Parametre> getParametreById(Integer id) {
        return parametreRepository.findById(id);
    }

    public Parametre createParametre(Parametre parametre) {
        return parametreRepository.save(parametre);
    }

    public Parametre updateParametre(Integer id, Parametre parametre) {
        if (parametreRepository.existsById(id)) {
            parametre.setIdParametre(id);
            return parametreRepository.save(parametre);
        }
        return null;
    }

    public void deleteParametre(Integer id) {
        parametreRepository.deleteById(id);
    }
}
