package com.taxi_brousse.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Etat")
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Etat")
    private Integer idEtat;

    @Column(name = "libelle", length = 50)
    private String libelle;

    public Etat() {
    }

    public Etat(String libelle) {
        this.libelle = libelle;
    }

    public Etat(Integer idEtat, String libelle) {
        this.idEtat = idEtat;
        this.libelle = libelle;
    }

    public Integer getIdEtat() {
        return idEtat;
    }

    public void setIdEtat(Integer idEtat) {
        this.idEtat = idEtat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
