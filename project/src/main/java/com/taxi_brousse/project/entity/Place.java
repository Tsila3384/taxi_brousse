package com.taxi_brousse.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_place")
    private Integer idPlace;

    @Column(name = "libelle", length = 50)
    private String libelle;

    @Column(name = "statut")
    private Boolean statut;



    public Place() {
    }

    public Place(String libelle) {
        this.libelle = libelle;
    }

    public Place(Integer idPlace, String libelle, Boolean statut) {
        this.idPlace = idPlace;
        this.libelle = libelle;
        this.statut = statut;
    }
    public Boolean getStatut() {
        return statut;
    }
    public void setStatut(Boolean statut) {
        this.statut = statut;
    }
    public Integer getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Integer idPlace) {
        this.idPlace = idPlace;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
