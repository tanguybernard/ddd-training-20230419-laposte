package com.zenika.laposte.bc_preparation.configuration;

import com.zenika.laposte.bc_preparation.application.CreateEtiquetteHandler;
import com.zenika.laposte.bc_preparation.domain.colis.ColisRepository;
import com.zenika.laposte.bc_preparation.domain.etiquette.EtiquetteRepository;
import com.zenika.laposte.bc_preparation.domain.etiquette.events.EtiquetteCreated;
import com.zenika.laposte.shared_kernel.domain_event.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;


@Configuration
public class InitDomainEventHandlerConfiguration {

    @Autowired
    ColisRepository colisRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        System.out.println("Register handler");

        DomainEventPublisher.register(new CreateEtiquetteHandler(colisRepository), EtiquetteCreated.class.getName());

    }


}
