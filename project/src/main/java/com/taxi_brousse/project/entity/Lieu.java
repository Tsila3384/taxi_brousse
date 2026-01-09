package com.taxi_brousse.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Lieu")
public class Lieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Lieu")
    private Integer idLieu;

    @Column(name = "libelle", length = 50)
    private String libelle;

    public Lieu() {
    }

    public Lieu(String libelle) {
        this.libelle = libelle;
    }

    public Lieu(Integer idLieu, String libelle) {
        this.idLieu = idLieu;
        this.libelle = libelle;
    }

    public Integer getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(Integer idLieu) {
        this.idLieu = idLieu;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
