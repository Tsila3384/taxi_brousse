package com.taxi_brousse.project.repository;

import com.taxi_brousse.project.entity.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntretienRepository extends JpaRepository<Entretien, Integer> {
}
