CREATE TABLE Voiture(
   Id_Voiture SERIAL,
   Immatriculation VARCHAR(50) ,
   nb_place VARCHAR(50) ,
   consommation NUMERIC(15,2)  ,
   PRIMARY KEY(Id_Voiture)
);

CREATE TABLE Client(
   Id_Client SERIAL,
   nom VARCHAR(255) ,
   telephone VARCHAR(50) ,
   PRIMARY KEY(Id_Client)
);

CREATE TABLE Lieu(
   Id_Lieu SERIAL,
   libelle VARCHAR(50) ,
   PRIMARY KEY(Id_Lieu)
);

CREATE TABLE parametre(
   Id_parametre SERIAL,
   libelle VARCHAR(50) ,
   valeur VARCHAR(50) ,
   PRIMARY KEY(Id_parametre)
);

CREATE TABLE Itineraire(
   Id_Itineraire SERIAL,
   duree TIME,
   Id_Lieu INTEGER NOT NULL,
   Id_Lieu_1 INTEGER NOT NULL,
   PRIMARY KEY(Id_Itineraire),
   FOREIGN KEY(Id_Lieu) REFERENCES Lieu(Id_Lieu),
   FOREIGN KEY(Id_Lieu_1) REFERENCES Lieu(Id_Lieu)
);

CREATE TABLE Etat(
   Id_Etat SERIAL,
   libelle VARCHAR(50) ,
   PRIMARY KEY(Id_Etat)
);

CREATE TABLE type_paiement(
   Id_type_paiement SERIAL,
   libelle VARCHAR(50) ,
   PRIMARY KEY(Id_type_paiement)
);

CREATE TABLE entretien(
   Id_entretien SERIAL,
   daty DATE,
   motif VARCHAR(50) ,
   Id_Voiture INTEGER NOT NULL,
   PRIMARY KEY(Id_entretien),
   FOREIGN KEY(Id_Voiture) REFERENCES Voiture(Id_Voiture)
);

CREATE TABLE place(
   Id_place SERIAL,
   libelle VARCHAR(50) ,
   PRIMARY KEY(Id_place)
);

CREATE TABLE caisse(
   Id_caisse SERIAL,
   libelle VARCHAR(50) ,
   solde NUMERIC(15,2)  ,
   PRIMARY KEY(Id_caisse)
);

CREATE TABLE type_voyage(
   Id_type_voyage SERIAL,
   prix MONEY,
   Id_Itineraire INTEGER NOT NULL,
   PRIMARY KEY(Id_type_voyage),
   FOREIGN KEY(Id_Itineraire) REFERENCES Itineraire(Id_Itineraire)
);

CREATE TABLE type_mouvement(
   Id_type_mouvement SERIAL,
   libelle VARCHAR(50) ,
   PRIMARY KEY(Id_type_mouvement)
);

CREATE TABLE statut(
   Id_statut SERIAL,
   libelle VARCHAR(50) ,
   PRIMARY KEY(Id_statut)
);

CREATE TABLE genre(
   Id_genre SERIAL,
   libelle VARCHAR(50) ,
   PRIMARY KEY(Id_genre)
);

CREATE TABLE utilisateur(
   Id_utilisateur SERIAL,
   nom VARCHAR(255) ,
   mdp VARCHAR(50) ,
   PRIMARY KEY(Id_utilisateur)
);

CREATE TABLE employe(
   Id_Employe SERIAL,
   nom VARCHAR(50) ,
   telephone NUMERIC(15,2)  ,
   Id_genre INTEGER NOT NULL,
   PRIMARY KEY(Id_Employe),
   FOREIGN KEY(Id_genre) REFERENCES genre(Id_genre)
);

CREATE TABLE voyage(
   Id_voyage SERIAL,
   daty TIMESTAMP,
   Id_Chauffeur INTEGER NOT NULL,
   Id_aide_chauffeur INTEGER NOT NULL,
   Id_type_voyage INTEGER NOT NULL,
   Id_Voiture INTEGER NOT NULL,
   PRIMARY KEY(Id_voyage),
   FOREIGN KEY(Id_Chauffeur) REFERENCES employe(Id_Employe),
   FOREIGN KEY(Id_aide_chauffeur) REFERENCES employe(Id_Employe),
   FOREIGN KEY(Id_type_voyage) REFERENCES type_voyage(Id_type_voyage),
   FOREIGN KEY(Id_Voiture) REFERENCES Voiture(Id_Voiture)
);

CREATE TABLE Reservation(
   Id_Reservation SERIAL,
   daty DATE,
   nb_personnes INTEGER,
   statut_paiement BOOLEAN,
   Id_voyage INTEGER NOT NULL,
   Id_Client INTEGER NOT NULL,
   PRIMARY KEY(Id_Reservation),
   FOREIGN KEY(Id_voyage) REFERENCES voyage(Id_voyage),
   FOREIGN KEY(Id_Client) REFERENCES Client(Id_Client)
);

CREATE TABLE paiement(
   Id_paiement SERIAL,
   daty DATE,
   montant MONEY,
   Id_Reservation INTEGER NOT NULL,
   Id_caisse INTEGER NOT NULL,
   Id_type_paiement INTEGER NOT NULL,
   PRIMARY KEY(Id_paiement),
   FOREIGN KEY(Id_Reservation) REFERENCES Reservation(Id_Reservation),
   FOREIGN KEY(Id_caisse) REFERENCES caisse(Id_caisse),
   FOREIGN KEY(Id_type_paiement) REFERENCES type_paiement(Id_type_paiement)
);

CREATE TABLE mouvement(
   Id_mouvement SERIAL,
   Id_type_mouvement INTEGER NOT NULL,
   Id_caisse INTEGER NOT NULL,
   Id_paiement INTEGER NOT NULL,
   PRIMARY KEY(Id_mouvement),
   FOREIGN KEY(Id_type_mouvement) REFERENCES type_mouvement(Id_type_mouvement),
   FOREIGN KEY(Id_caisse) REFERENCES caisse(Id_caisse),
   FOREIGN KEY(Id_paiement) REFERENCES paiement(Id_paiement)
);

CREATE TABLE voiture_etat(
   Id_Voiture INTEGER,
   Id_Etat INTEGER,
   daty DATE,
   PRIMARY KEY(Id_Voiture, Id_Etat),
   FOREIGN KEY(Id_Voiture) REFERENCES Voiture(Id_Voiture),
   FOREIGN KEY(Id_Etat) REFERENCES Etat(Id_Etat)
);

CREATE TABLE voiture_place(
   Id_Voiture INTEGER,
   Id_place INTEGER,
   PRIMARY KEY(Id_Voiture, Id_place),
   FOREIGN KEY(Id_Voiture) REFERENCES Voiture(Id_Voiture),
   FOREIGN KEY(Id_place) REFERENCES place(Id_place)
);

CREATE TABLE statut_voyage(
   Id_voyage INTEGER,
   Id_statut INTEGER,
   PRIMARY KEY(Id_voyage, Id_statut),
   FOREIGN KEY(Id_voyage) REFERENCES voyage(Id_voyage),
   FOREIGN KEY(Id_statut) REFERENCES statut(Id_statut)
);


insert into client(nom, telephone) values
('Alice Dupont', '0612345678'),
('Bob Martin', '0698765432'),
('Charlie Bernard', '0623456789');