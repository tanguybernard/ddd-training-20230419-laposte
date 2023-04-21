package com.zenika.laposte.bc_preparation.infrastructure.postgres.etiquette;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class EtiquetteEntity {

    @Id
    public String id;

    public int poids;

    public int dimensionLongueur;

    public int dimensionLargeur;

    public int dimensionProfondeur;




}
