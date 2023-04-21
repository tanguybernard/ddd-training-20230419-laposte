package com.zenika.laposte.bc_preparation.application;

import com.zenika.laposte.bc_preparation.domain.colis.ColisId;
import com.zenika.laposte.bc_preparation.domain.etiquette.*;
import com.zenika.laposte.bc_preparation.domain.etiquette.events.EtiquetteCreated;
import com.zenika.laposte.shared_kernel.domain_event.DomainEvent;
import com.zenika.laposte.shared_kernel.domain_event.DomainEventPublisher;

public class CreateEtiquette {

    private   EtiquetteRepository etiquetteRepository ;


    public CreateEtiquette(EtiquetteRepository etiquetteRepository ) {
        this.etiquetteRepository = etiquetteRepository;

    }


    public void execute(EtiquetteDto dto, String idColis){

        Etiquette etiquette = Etiquette.create(new EtiquetteId(dto.idEtiquette()), new Poids(dto.poids(), "g"), new Dimension(dto.dProfondeur(), dto.dLongueur(), dto.dLargeur()));

        etiquette.assignColis(new ColisId(idColis));
        //saved repo
        etiquetteRepository.create(etiquette);
        //Domain event

        etiquette.pullDomainEvents().forEach(DomainEventPublisher::dispatch);

    }
}
