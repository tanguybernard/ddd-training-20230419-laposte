package com.zenika.laposte.bc_preparation.application;

import com.zenika.laposte.bc_preparation.domain.colis.Colis;
import com.zenika.laposte.bc_preparation.domain.colis.ColisId;
import com.zenika.laposte.bc_preparation.domain.colis.ColisRepository;
import com.zenika.laposte.bc_preparation.domain.etiquette.Etiquette;
import com.zenika.laposte.bc_preparation.domain.etiquette.EtiquetteRepository;
import com.zenika.laposte.bc_preparation.domain.etiquette.events.EtiquetteCreated;
import com.zenika.laposte.shared_kernel.domain_event.DomainEvent;
import com.zenika.laposte.shared_kernel.domain_event.EventHandler;

public class CreateEtiquetteHandler implements EventHandler<EtiquetteCreated> {

    public CreateEtiquetteHandler(ColisRepository colisRepository) {
        this.colisRepository = colisRepository;
    }

    ColisRepository colisRepository ;


    @Override
    public void handle(EtiquetteCreated evt) throws Exception {
        //recuperer le colis

        Colis colis = colisRepository.getById(evt.colisId);

        //assigner l'etiquette au colis
        colis.assignerEtiquette(evt.id);

        this.colisRepository.create(colis);
    }
}
