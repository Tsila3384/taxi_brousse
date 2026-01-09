package com.taxi_brousse.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "type_mouvement")
public class TypeMouvement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_type_mouvement")
    private Integer idTypeMouvement;

    @Column(name = "libelle", length = 50)
    private String libelle;

    public TypeMouvement() {
    }

    public TypeMouvement(String libelle) {
        this.libelle = libelle;
    }

    public TypeMouvement(Integer idTypeMouvement, String libelle) {
        this.idTypeMouvement = idTypeMouvement;
        this.libelle = libelle;
    }

    public Integer getIdTypeMouvement() {
        return idTypeMouvement;
    }

    public void setIdTypeMouvement(Integer idTypeMouvement) {
        this.idTypeMouvement = idTypeMouvement;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
