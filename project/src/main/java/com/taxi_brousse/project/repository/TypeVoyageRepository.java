package com.taxi_brousse.project.repository;

import com.taxi_brousse.project.entity.TypeVoyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeVoyageRepository extends JpaRepository<TypeVoyage, Integer> {
}
