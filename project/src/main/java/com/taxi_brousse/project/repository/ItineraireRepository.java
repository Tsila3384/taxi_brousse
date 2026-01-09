package com.taxi_brousse.project.repository;

import com.taxi_brousse.project.entity.Itineraire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraireRepository extends JpaRepository<Itineraire, Integer> {
}
