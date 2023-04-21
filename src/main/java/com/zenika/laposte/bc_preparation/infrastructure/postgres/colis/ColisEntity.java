package com.zenika.laposte.bc_preparation.infrastructure.postgres.colis;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ColisEntity {

    @Id
    public String id;

    public LocalDate dateDeCreation;

    public String expediteurId;

    public String etiquetteId;




}
