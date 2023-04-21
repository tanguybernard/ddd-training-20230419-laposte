package com.zenika.laposte.bc_preparation.domain.colis;

import com.zenika.laposte.bc_preparation.domain.etiquette.EtiquetteId;
import com.zenika.laposte.shared_kernel.AggregateRoot;

import java.time.LocalDate;

public class Colis extends AggregateRoot<ColisId> {

   private LocalDate dateDeCreation;
   public String expediteurId ;

   public EtiquetteId etiquetteId = null;

    private Colis(ColisId colisId, LocalDate dateDeCreation,String expediteurId) {
        super(colisId);
        this.dateDeCreation = dateDeCreation;
        this.expediteurId = expediteurId ;
    }

    public Colis(ColisId colisId, LocalDate dateDeCreation, String expediteurId, EtiquetteId etiquetteId) {
        super(colisId);
        this.dateDeCreation = dateDeCreation;
        this.expediteurId = expediteurId ;
        this.etiquetteId = etiquetteId ;
    }

    public static Colis create(ColisId colisId, LocalDate dateDeCreation, String expediteurId){

        return new Colis(colisId, dateDeCreation, expediteurId);

    }

    public static Colis load(ColisId colisId, LocalDate dateDeCreation, String expediteurId, EtiquetteId etiquetteId) {

        return new Colis(colisId, dateDeCreation, expediteurId, etiquetteId);
    }

    public ColisId id() {
        return this.id;
    }

    public LocalDate dateDeCreation() {
        return this.dateDeCreation;
    }

    public void assignerEtiquette(EtiquetteId etiquetteId){
        this.etiquetteId = etiquetteId;
    }
}
