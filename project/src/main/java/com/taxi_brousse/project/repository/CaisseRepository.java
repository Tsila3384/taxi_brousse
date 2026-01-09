package com.taxi_brousse.project.repository;

import com.taxi_brousse.project.entity.Caisse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaisseRepository extends JpaRepository<Caisse, Integer> {
}
