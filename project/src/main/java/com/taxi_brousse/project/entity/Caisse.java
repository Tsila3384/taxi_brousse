package com.taxi_brousse.project.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "caisse")
public class Caisse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_caisse")
    private Integer idCaisse;

    @Column(name = "libelle", length = 50)
    private String libelle;

    @Column(name = "solde", precision = 15, scale = 2)
    private BigDecimal solde;

    public Caisse() {
    }

    public Caisse(String libelle, BigDecimal solde) {
        this.libelle = libelle;
        this.solde = solde;
    }

    public Caisse(Integer idCaisse, String libelle, BigDecimal solde) {
        this.idCaisse = idCaisse;
        this.libelle = libelle;
        this.solde = solde;
    }

    public Integer getIdCaisse() {
        return idCaisse;
    }

    public void setIdCaisse(Integer idCaisse) {
        this.idCaisse = idCaisse;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }
}
