package com.taxi_brousse.project.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "Itineraire")
public class Itineraire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Itineraire")
    private Integer idItineraire;

    @Column(name = "duree")
    private LocalTime duree;

    @ManyToOne
    @JoinColumn(name = "Id_Lieu", nullable = false)
    private Lieu lieuDepart;

    @ManyToOne
    @JoinColumn(name = "Id_Lieu_1", nullable = false)
    private Lieu lieuArrivee;

    public Itineraire() {
    }

    public Itineraire(LocalTime duree, Lieu lieuDepart, Lieu lieuArrivee) {
        this.duree = duree;
        this.lieuDepart = lieuDepart;
        this.lieuArrivee = lieuArrivee;
    }

    public Itineraire(Integer idItineraire, LocalTime duree, Lieu lieuDepart, Lieu lieuArrivee) {
        this.idItineraire = idItineraire;
        this.duree = duree;
        this.lieuDepart = lieuDepart;
        this.lieuArrivee = lieuArrivee;
    }

    public Integer getIdItineraire() {
        return idItineraire;
    }

    public void setIdItineraire(Integer idItineraire) {
        this.idItineraire = idItineraire;
    }

    public LocalTime getDuree() {
        return duree;
    }

    public void setDuree(LocalTime duree) {
        this.duree = duree;
    }

    public Lieu getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(Lieu lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public Lieu getLieuArrivee() {
        return lieuArrivee;
    }

    public void setLieuArrivee(Lieu lieuArrivee) {
        this.lieuArrivee = lieuArrivee;
    }
}
