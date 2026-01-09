package com.taxi_brousse.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mouvement")
public class Mouvement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_mouvement")
    private Integer idMouvement;

    @ManyToOne
    @JoinColumn(name = "Id_type_mouvement", nullable = false)
    private TypeMouvement typeMouvement;

    @ManyToOne
    @JoinColumn(name = "Id_caisse", nullable = false)
    private Caisse caisse;

    @ManyToOne
    @JoinColumn(name = "Id_paiement", nullable = false)
    private Paiement paiement;

    public Mouvement() {
    }

    public Mouvement(TypeMouvement typeMouvement, Caisse caisse, Paiement paiement) {
        this.typeMouvement = typeMouvement;
        this.caisse = caisse;
        this.paiement = paiement;
    }

    public Mouvement(Integer idMouvement, TypeMouvement typeMouvement, Caisse caisse, Paiement paiement) {
        this.idMouvement = idMouvement;
        this.typeMouvement = typeMouvement;
        this.caisse = caisse;
        this.paiement = paiement;
    }

    public Integer getIdMouvement() {
        return idMouvement;
    }

    public void setIdMouvement(Integer idMouvement) {
        this.idMouvement = idMouvement;
    }

    public TypeMouvement getTypeMouvement() {
        return typeMouvement;
    }

    public void setTypeMouvement(TypeMouvement typeMouvement) {
        this.typeMouvement = typeMouvement;
    }

    public Caisse getCaisse() {
        return caisse;
    }

    public void setCaisse(Caisse caisse) {
        this.caisse = caisse;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }
}
