package com.taxi_brousse.project.repository;

import com.taxi_brousse.project.entity.TypeMouvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeMouvementRepository extends JpaRepository<TypeMouvement, Integer> {
}
