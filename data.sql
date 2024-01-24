create sequence user_seq start with 1 increment by 1; 
create table user(
    id varchar(60) primary key default,
    nom varchar(150),
    prenom varchar(150),
    email varchar(150),
    role varchar(10),
    password varchar(150)
);

-- create table admin (
--     id serial primary key,
--     email varchar(150),
--     password varchar(150)
-- );

---gestion des éléments necessaires
create table categorie (
    id serial primary key,
    nom varchar(150)
);

create table marque (
    id serial primary key,
    nom varchar(150)
);

create table marque_model (
    id serial primary key,
    id_marque integer references marque(id),
    nom_model varchar(100)
);

create table transmission(
    id serial primary key,
    nom varchar(150)
);

create table couleur (
    id serial primary key,
    nom varchar(150)
);

create table energie (
    id serial primary key,
    nom varchar(150)
);

create table pays (
    id serial primary key,
    nom varchar(150)
);

---gestion des annonces
create table voiture (
    id serial primary key,
    id_user integer references user(id),
    id_marque_model integer references marque_model(id),
    id_categorie integer references categorie(id),
    id_transmission integer references transmission(id),
    id_couleur integer references couleur(id),
    id_energie integer references energie(id),
    id_pays integer references pays(id),
    matricule varchar(100),
    annee integer,
    consommation float,
    reservoir float,
    nombre_place integer,
    kilometrage float
);

create table equipement (
    id serial primary key,
    nom varchar(100)
);
-----direction_assiste ,ecran_tactile ,climatisation ,radio ,bluetooth ,gps ,airbag ,fermeture_centralise ,siege_chauffant ,vitre_electrique 

create table equipement_voiture (
    id serial primary key,
    id_voiture integer references voiture(id),
    id_equipement integer references equipement(id)
);

create table annonce (
    id serial primary key,
    id_voiture integer references voiture(id),
    prix float,
    descriptions text,
    date_annonce date default current_date(),
    etat integer
);

create table annonce_valider (
    id serial primary key,
    id_annonce integer references annonce(id),
    date_validation date default current_date()
);

create table annonce_refuser (
    id serial primary key,
    id_annonce integer references annonce(id),
    date_refus date default current_date()
);

create table annonce_favoris (
    id serial primary key,
    id_user integer references user(id),
    id_annonce integer references annonce(id),
    date_ajout date default current_date()
);