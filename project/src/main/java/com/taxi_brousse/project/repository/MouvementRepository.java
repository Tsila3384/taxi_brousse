package com.taxi_brousse.project.repository;

import com.taxi_brousse.project.entity.Mouvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MouvementRepository extends JpaRepository<Mouvement, Integer> {
}
