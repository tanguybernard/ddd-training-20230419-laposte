package com.zenika.laposte.bc_preparation.domain.colis;

import com.zenika.laposte.shared_kernel.AggregateRoot;

import java.time.LocalDate;

public class Colis extends AggregateRoot<ColisId> {

    LocalDate dateDeCreation;

    public Colis(ColisId colisId, LocalDate dateDeCreation) {
        super(colisId);
        this.dateDeCreation = dateDeCreation;
    }

    public ColisId id() {
        return this.id;
    }

    public LocalDate dateDeCreation() {
        return this.dateDeCreation;
    }
}
