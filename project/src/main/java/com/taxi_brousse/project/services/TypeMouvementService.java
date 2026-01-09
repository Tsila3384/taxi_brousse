package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.TypeMouvement;
import com.taxi_brousse.project.repository.TypeMouvementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TypeMouvementService {
    @Autowired
    private TypeMouvementRepository typeMouvementRepository;

    public List<TypeMouvement> getAllTypeMouvements() {
        return typeMouvementRepository.findAll();
    }

    public Optional<TypeMouvement> getTypeMouvementById(Integer id) {
        return typeMouvementRepository.findById(id);
    }

    public TypeMouvement createTypeMouvement(TypeMouvement typeMouvement) {
        return typeMouvementRepository.save(typeMouvement);
    }

    public TypeMouvement updateTypeMouvement(Integer id, TypeMouvement typeMouvement) {
        if (typeMouvementRepository.existsById(id)) {
            typeMouvement.setIdTypeMouvement(id);
            return typeMouvementRepository.save(typeMouvement);
        }
        return null;
    }

    public void deleteTypeMouvement(Integer id) {
        typeMouvementRepository.deleteById(id);
    }
}
