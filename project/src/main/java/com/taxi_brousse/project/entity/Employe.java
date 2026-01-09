package com.taxi_brousse.project.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Employe")
    private Integer idEmploye;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "telephone", precision = 15, scale = 2)
    private BigDecimal telephone;

    @ManyToOne
    @JoinColumn(name = "Id_genre", nullable = false)
    private Genre genre;

    public Employe() {
    }

    public Employe(String nom, BigDecimal telephone, Genre genre) {
        this.nom = nom;
        this.telephone = telephone;
        this.genre = genre;
    }

    public Employe(Integer idEmploye, String nom, BigDecimal telephone, Genre genre) {
        this.idEmploye = idEmploye;
        this.nom = nom;
        this.telephone = telephone;
        this.genre = genre;
    }

    public Integer getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(Integer idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getTelephone() {
        return telephone;
    }

    public void setTelephone(BigDecimal telephone) {
        this.telephone = telephone;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
