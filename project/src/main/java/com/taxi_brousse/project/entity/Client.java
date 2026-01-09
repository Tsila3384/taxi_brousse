package com.taxi_brousse.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Client")
    private Integer idClient;

    @Column(name = "nom", length = 255)
    private String nom;

    @Column(name = "telephone", length = 50)
    private String telephone;

    public Client() {
    }

    public Client(String nom, String telephone) {
        this.nom = nom;
        this.telephone = telephone;
    }

    public Client(Integer idClient, String nom, String telephone) {
        this.idClient = idClient;
        this.nom = nom;
        this.telephone = telephone;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
