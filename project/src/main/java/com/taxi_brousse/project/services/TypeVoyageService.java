package com.taxi_brousse.project.services;

import com.taxi_brousse.project.entity.TypeVoyage;
import com.taxi_brousse.project.repository.TypeVoyageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TypeVoyageService {
    @Autowired
    private TypeVoyageRepository typeVoyageRepository;

    public List<TypeVoyage> getAllTypeVoyages() {
        return typeVoyageRepository.findAll();
    }

    public Optional<TypeVoyage> getTypeVoyageById(Integer id) {
        return typeVoyageRepository.findById(id);
    }

    public TypeVoyage createTypeVoyage(TypeVoyage typeVoyage) {
        return typeVoyageRepository.save(typeVoyage);
    }

    public TypeVoyage updateTypeVoyage(Integer id, TypeVoyage typeVoyage) {
        if (typeVoyageRepository.existsById(id)) {
            typeVoyage.setIdTypeVoyage(id);
            return typeVoyageRepository.save(typeVoyage);
        }
        return null;
    }

    public void deleteTypeVoyage(Integer id) {
        typeVoyageRepository.deleteById(id);
    }
}
