package com.taxi_brousse.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_genre")
    private Integer idGenre;

    @Column(name = "libelle", length = 50)
    private String libelle;

    public Genre() {
    }

    public Genre(String libelle) {
        this.libelle = libelle;
    }

    public Genre(Integer idGenre, String libelle) {
        this.idGenre = idGenre;
        this.libelle = libelle;
    }

    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
