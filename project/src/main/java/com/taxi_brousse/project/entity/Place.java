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

    public Place() {
    }

    public Place(String libelle) {
        this.libelle = libelle;
    }

    public Place(Integer idPlace, String libelle) {
        this.idPlace = idPlace;
        this.libelle = libelle;
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
