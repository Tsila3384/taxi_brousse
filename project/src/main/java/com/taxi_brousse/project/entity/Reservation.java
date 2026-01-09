package com.taxi_brousse.project.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Reservation")
    private Integer idReservation;

    @Column(name = "daty")
    private LocalDate daty;

    @Column(name = "nb_personnes")
    private Integer nbPersonnes;

    @Column(name = "statut_paiement")
    private Boolean statutPaiement;

    @ManyToOne
    @JoinColumn(name = "Id_voyage", nullable = false)
    private Voyage voyage;

    @ManyToOne
    @JoinColumn(name = "Id_Client", nullable = false)
    private Client client;

    public Reservation() {
    }

    public Reservation(LocalDate daty, Integer nbPersonnes, Boolean statutPaiement, Voyage voyage, Client client) {
        this.daty = daty;
        this.nbPersonnes = nbPersonnes;
        this.statutPaiement = statutPaiement;
        this.voyage = voyage;
        this.client = client;
    }

    public Reservation(Integer idReservation, LocalDate daty, Integer nbPersonnes, Boolean statutPaiement,
            Voyage voyage, Client client) {
        this.idReservation = idReservation;
        this.daty = daty;
        this.nbPersonnes = nbPersonnes;
        this.statutPaiement = statutPaiement;
        this.voyage = voyage;
        this.client = client;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public LocalDate getDaty() {
        return daty;
    }

    public void setDaty(LocalDate daty) {
        this.daty = daty;
    }

    public Integer getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(Integer nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    public Boolean getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(Boolean statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
