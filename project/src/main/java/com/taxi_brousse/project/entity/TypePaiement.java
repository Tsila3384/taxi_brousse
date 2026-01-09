package com.taxi_brousse.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "type_paiement")
public class TypePaiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_type_paiement")
    private Integer idTypePaiement;

    @Column(name = "libelle", length = 50)
    private String libelle;

    public TypePaiement() {
    }

    public TypePaiement(String libelle) {
        this.libelle = libelle;
    }

    public TypePaiement(Integer idTypePaiement, String libelle) {
        this.idTypePaiement = idTypePaiement;
        this.libelle = libelle;
    }

    public Integer getIdTypePaiement() {
        return idTypePaiement;
    }

    public void setIdTypePaiement(Integer idTypePaiement) {
        this.idTypePaiement = idTypePaiement;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
