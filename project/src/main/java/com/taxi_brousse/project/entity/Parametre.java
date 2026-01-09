package com.taxi_brousse.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "parametre")
public class Parametre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_parametre")
    private Integer idParametre;

    @Column(name = "libelle", length = 50)
    private String libelle;

    @Column(name = "valeur", length = 50)
    private String valeur;

    public Parametre() {
    }

    public Parametre(String libelle, String valeur) {
        this.libelle = libelle;
        this.valeur = valeur;
    }

    public Parametre(Integer idParametre, String libelle, String valeur) {
        this.idParametre = idParametre;
        this.libelle = libelle;
        this.valeur = valeur;
    }

    public Integer getIdParametre() {
        return idParametre;
    }

    public void setIdParametre(Integer idParametre) {
        this.idParametre = idParametre;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
}
