package com.taxi_brousse.project.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "paiement")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_paiement")
    private Integer idPaiement;

    @Column(name = "daty")
    private LocalDate daty;

    @Column(name = "montant")
    private BigDecimal montant;

    @ManyToOne
    @JoinColumn(name = "Id_Reservation", nullable = false)
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "Id_caisse", nullable = false)
    private Caisse caisse;

    @ManyToOne
    @JoinColumn(name = "Id_type_paiement", nullable = false)
    private TypePaiement typePaiement;

    public Paiement() {
    }

    public Paiement(LocalDate daty, BigDecimal montant, Reservation reservation, Caisse caisse,
            TypePaiement typePaiement) {
        this.daty = daty;
        this.montant = montant;
        this.reservation = reservation;
        this.caisse = caisse;
        this.typePaiement = typePaiement;
    }

    public Paiement(Integer idPaiement, LocalDate daty, BigDecimal montant, Reservation reservation, Caisse caisse,
            TypePaiement typePaiement) {
        this.idPaiement = idPaiement;
        this.daty = daty;
        this.montant = montant;
        this.reservation = reservation;
        this.caisse = caisse;
        this.typePaiement = typePaiement;
    }

    public Integer getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(Integer idPaiement) {
        this.idPaiement = idPaiement;
    }

    public LocalDate getDaty() {
        return daty;
    }

    public void setDaty(LocalDate daty) {
        this.daty = daty;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Caisse getCaisse() {
        return caisse;
    }

    public void setCaisse(Caisse caisse) {
        this.caisse = caisse;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }
}
