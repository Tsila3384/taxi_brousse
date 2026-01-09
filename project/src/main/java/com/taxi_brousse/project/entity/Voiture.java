package com.taxi_brousse.project.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Voiture")
    private Integer idVoiture;

    @Column(name = "Immatriculation", length = 50)
    private String immatriculation;

    @Column(name = "nb_place", length = 50)
    private String nbPlace;

    @Column(name = "consommation", precision = 15, scale = 2)
    private BigDecimal consommation;

    public Voiture() {
    }

    public Voiture(String immatriculation, String nbPlace, BigDecimal consommation) {
        this.immatriculation = immatriculation;
        this.nbPlace = nbPlace;
        this.consommation = consommation;
    }

    public Voiture(Integer idVoiture, String immatriculation, String nbPlace, BigDecimal consommation) {
        this.idVoiture = idVoiture;
        this.immatriculation = immatriculation;
        this.nbPlace = nbPlace;
        this.consommation = consommation;
    }

    public Integer getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(Integer idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(String nbPlace) {
        this.nbPlace = nbPlace;
    }

    public BigDecimal getConsommation() {
        return consommation;
    }

    public void setConsommation(BigDecimal consommation) {
        this.consommation = consommation;
    }
}
