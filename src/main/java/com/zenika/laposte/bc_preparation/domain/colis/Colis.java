package com.zenika.laposte.bc_preparation.domain.colis;

import com.zenika.laposte.shared_kernel.AggregateRoot;

import java.time.LocalDate;

public class Colis extends AggregateRoot<ColisId> {

   private LocalDate dateDeCreation;
   public String expediteurId ;

    private Colis(ColisId colisId, LocalDate dateDeCreation,String expediteurId) {
        super(colisId);
        this.dateDeCreation = dateDeCreation;
        this.expediteurId = expediteurId ;
    }

    public static Colis create(ColisId colisId, LocalDate dateDeCreation, String expediteurId){

        return new Colis(colisId, dateDeCreation, expediteurId);

    }

    public static Colis load(ColisId colisId, LocalDate dateDeCreation, String expediteurId) {

        return new Colis(colisId, dateDeCreation, expediteurId);
    }

    public ColisId id() {
        return this.id;
    }

    public LocalDate dateDeCreation() {
        return this.dateDeCreation;
    }
}
