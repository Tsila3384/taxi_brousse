package com.taxi_brousse.project.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "entretien")
public class Entretien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_entretien")
    private Integer idEntretien;

    @Column(name = "daty")
    private LocalDate daty;

    @Column(name = "motif", length = 50)
    private String motif;

    @ManyToOne
    @JoinColumn(name = "Id_Voiture", nullable = false)
    private Voiture voiture;

    public Entretien() {
    }

    public Entretien(LocalDate daty, String motif, Voiture voiture) {
        this.daty = daty;
        this.motif = motif;
        this.voiture = voiture;
    }

    public Entretien(Integer idEntretien, LocalDate daty, String motif, Voiture voiture) {
        this.idEntretien = idEntretien;
        this.daty = daty;
        this.motif = motif;
        this.voiture = voiture;
    }

    public Integer getIdEntretien() {
        return idEntretien;
    }

    public void setIdEntretien(Integer idEntretien) {
        this.idEntretien = idEntretien;
    }

    public LocalDate getDaty() {
        return daty;
    }

    public void setDaty(LocalDate daty) {
        this.daty = daty;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }
}
