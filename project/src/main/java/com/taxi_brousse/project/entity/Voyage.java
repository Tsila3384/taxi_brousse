package com.taxi_brousse.project.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "voyage")
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_voyage")
    private Integer idVoyage;

    @Column(name = "daty")
    private LocalDateTime daty;

    @ManyToOne
    @JoinColumn(name = "Id_Chauffeur", nullable = false)
    private Employe chauffeur;

    @ManyToOne
    @JoinColumn(name = "Id_aide_chauffeur", nullable = false)
    private Employe aideChauffeur;

    @ManyToOne
    @JoinColumn(name = "Id_type_voyage", nullable = false)
    private TypeVoyage typeVoyage;

    @ManyToOne
    @JoinColumn(name = "Id_Voiture", nullable = false)
    private Voiture voiture;

    public Voyage() {
    }

    public Voyage(LocalDateTime daty, Employe chauffeur, Employe aideChauffeur, TypeVoyage typeVoyage,
            Voiture voiture) {
        this.daty = daty;
        this.chauffeur = chauffeur;
        this.aideChauffeur = aideChauffeur;
        this.typeVoyage = typeVoyage;
        this.voiture = voiture;
    }

    public Voyage(Integer idVoyage, LocalDateTime daty, Employe chauffeur, Employe aideChauffeur, TypeVoyage typeVoyage,
            Voiture voiture) {
        this.idVoyage = idVoyage;
        this.daty = daty;
        this.chauffeur = chauffeur;
        this.aideChauffeur = aideChauffeur;
        this.typeVoyage = typeVoyage;
        this.voiture = voiture;
    }

    public Integer getIdVoyage() {
        return idVoyage;
    }

    public void setIdVoyage(Integer idVoyage) {
        this.idVoyage = idVoyage;
    }

    public LocalDateTime getDaty() {
        return daty;
    }

    public void setDaty(LocalDateTime daty) {
        this.daty = daty;
    }

    public Employe getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Employe chauffeur) {
        this.chauffeur = chauffeur;
    }

    public Employe getAideChauffeur() {
        return aideChauffeur;
    }

    public void setAideChauffeur(Employe aideChauffeur) {
        this.aideChauffeur = aideChauffeur;
    }

    public TypeVoyage getTypeVoyage() {
        return typeVoyage;
    }

    public void setTypeVoyage(TypeVoyage typeVoyage) {
        this.typeVoyage = typeVoyage;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }
}
