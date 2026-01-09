package com.taxi_brousse.project.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "type_voyage")
public class TypeVoyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_type_voyage")
    private Integer idTypeVoyage;

    @Column(name = "prix")
    private BigDecimal prix;

    @ManyToOne
    @JoinColumn(name = "Id_Itineraire", nullable = false)
    private Itineraire itineraire;

    public TypeVoyage() {
    }

    public TypeVoyage(BigDecimal prix, Itineraire itineraire) {
        this.prix = prix;
        this.itineraire = itineraire;
    }

    public TypeVoyage(Integer idTypeVoyage, BigDecimal prix, Itineraire itineraire) {
        this.idTypeVoyage = idTypeVoyage;
        this.prix = prix;
        this.itineraire = itineraire;
    }

    public Integer getIdTypeVoyage() {
        return idTypeVoyage;
    }

    public void setIdTypeVoyage(Integer idTypeVoyage) {
        this.idTypeVoyage = idTypeVoyage;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Itineraire getItineraire() {
        return itineraire;
    }

    public void setItineraire(Itineraire itineraire) {
        this.itineraire = itineraire;
    }
}
