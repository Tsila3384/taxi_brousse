package com.taxi_brousse.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_utilisateur")
    private Integer idUtilisateur;

    @Column(name = "nom", length = 255)
    private String nom;

    @Column(name = "mdp", length = 50)
    private String mdp;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String mdp) {
        this.nom = nom;
        this.mdp = mdp;
    }

    public Utilisateur(Integer idUtilisateur, String nom, String mdp) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.mdp = mdp;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
