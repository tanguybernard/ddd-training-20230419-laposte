package com.zenika.laposte.bc_preparation.domain.etiquette.events;

import com.zenika.laposte.bc_preparation.domain.colis.ColisId;
import com.zenika.laposte.bc_preparation.domain.etiquette.EtiquetteId;
import com.zenika.laposte.shared_kernel.domain_event.DomainEvent;

import java.time.LocalDate;
import java.util.Date;

public class EtiquetteCreated implements DomainEvent {


    LocalDate occuredOn;
    public EtiquetteId id;
    public ColisId colisId;

    public EtiquetteCreated(EtiquetteId id, ColisId colisId) {
        this.id = id;
        this.colisId = colisId;
        this.occuredOn = LocalDate.now();

    }
}
